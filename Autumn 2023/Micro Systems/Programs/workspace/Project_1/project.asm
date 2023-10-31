;-------------------------------------------------------------------------------
; MSP430 Assembler Code Template for use with TI Code Composer Studio
;
;
;-------------------------------------------------------------------------------
            .cdecls C,LIST,"msp430.h"       ; Include device header file
            
;-------------------------------------------------------------------------------
            .def    RESET                   ; Export program entry-point to
                                            ; make it known to linker.

;-------------------------------------------------------------------------------
            .data                           ; Assemble into program memory.
            .retain                         ; Override ELF conditional linking
            .retainrefs                     ; And retain any sections that have

;You can uncomment this portion and use this array to test your code
;Do not submit your results for this array !!
;LENGTH:	.set 16
;array: 	.word 4, -3, -7, 6, -5, -1, 2, 0

LENGTH: 	.set 512
array: 		.space LENGTH
;-------------------------------------------------------------------------------
            .text                           ; Assemble into program memory.
            .retain                         ; Override ELF conditional linking
                                            ; and retain current section.
            .retainrefs                     ; And retain any sections that have
                                            ; references to current section.

;-------------------------------------------------------------------------------
RESET       mov.w   #__STACK_END,SP         ; Initialize stackpointer
StopWDT     mov.w   #WDTPW|WDTHOLD,&WDTCTL  ; Stop watchdog timer

;-------------------------------------------------------------------------------
; Main loop here
;-------------------------------------------------------------------------------

			mov.w	#array, R8				; sort takes the address of
			mov.w	#LENGTH/2, R10

			call	#sort

done: 		jmp 	done
			nop


;-------------------------------------------------------------------------------
; Subroutine: sort
; Inputs: R8 pointer to word array -- returned unchanged
; 			R8 contains the 16-bit starting address of an array
; 				The array contains N 16-bit signed integers
;
;		  R10 = N, the number of elements in the array -- returned unchanged
;
; Output: The subroutine sorts the elements in a given array from smallest to largest
; 			You will implement selection sort
;
; All core registers in R4-R15 unchanged
; Subroutine does not access any global variables or defined constants
;-------------------------------------------------------------------------------
sort:


;-------------------------------------------------------------------------------
; Subroutine: select
; Inputs: R8 pointer to word array -- returned unchanged
; 			R8 contains the 16-bit starting address of an array
; 				The array contains N 16-bit signed integers
;
;		  R10 = N, the number of elements in the array -- returned unchanged
;
; Output: R9 pointer to the smallest element in the array
;			R9 contains the 16-bit address of the smallest element
;
; All other core registers in R4-R15 unchanged
; Subroutine does not access any global variables or defined constants
;-------------------------------------------------------------------------------
select:
			mov.w	#0x7FFF, min_value		// init min_value = max_value
			clr.w	min_count
			push.w	R5
			clr.w	R5						// R5 is index


compare_to_min:
			cmp.w	min_value, array(R5)	// compare current element to max
			jl		next_element			// if larger than min, proceed to next

			jeq		same_max				// if equal to min, update count


new_max:
			mov.w	array(R5), min_value	// update min
			mov.w	#1, max_count			// restart count
			jmp		next_element


same_max:
			inc.w	max_count				// same max, update count


next_element:
			incd.w	R5						// increment counter
			cmp.w	R10, R5
			jne		compare_to_max			// loop if counter == length

			pop.w	R5						// Restore R5
			mov.w	min_value, R9			// move min to R9


;-------------------------------------------------------------------------------
; Subroutine: swap
; Inputs: R8 address of word with value x -- returned unchanged
; 		  R9 address of word with value y -- returned unchanged
;
; Output: The subroutine swaps x and y
; 			i.e., the word with address in R8 will have value y
;				  the word with address in R9 will have value x
;
; All core registers in R4-R15 unchanged
; Subroutine does not access any global variables or defined constants
; It is allowed to use the stack
;-------------------------------------------------------------------------------
swap:
		push.w	R8							; Push to stack
		push.w	R9

		pop.w	R8							; Pull from stack in backwards order
		pop.w	R9


;-------------------------------------------------------------------------------
; Stack Pointer definition
;-------------------------------------------------------------------------------
            .global __STACK_END
            .sect   .stack
            
;-------------------------------------------------------------------------------
; Interrupt Vectors
;-------------------------------------------------------------------------------
            .sect   ".reset"                ; MSP430 RESET Vector
            .short  RESET
            
