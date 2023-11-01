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
LENGTH:	.set 16
array: 	.word 4, -3, -7, 6, -5, -1, 2, 0

;LENGTH: 	.set 512
;array: 	.space LENGTH
min_value:	.word 32767
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
			push.w	R7						; R7 is array position counter
			push.w  R9						; R9 is smallest num pointer
			mov.w	#0, R7

sort_loop:
			call	#select					; Select next lowest number with R9

			add.w	R7, R8					; Add index to array address
			call	#swap					; Swap R8 and R9

			incd.w	R7

			cmp.w	R10, R7
			jne		sort_loop				; loop if R7 < R10


			pop.w	R9						; restore and return
			pop.w	R7
			ret

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
			mov.w	#0x7FFF, R9				; init min_value = max_value
			push.w	R5						; R5 is index
			clr.w	R5
			rla.w	R10


compare_to_min:
			cmp.w	#R9, array(R5)			; compare current element to max
			jge		next_element			; if larger than min, proceed to next

			add.w	#array, R5
			mov.w	R5, R9					; update min
			sub.w	#array, R5


next_element:
			incd.w	R5						; increment counter
			cmp.w	R10, R5
			jl		compare_to_min			; loop if counter == length


			rra.w	R10
			pop.w	R5						; Restore R5
			ret

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

		push.w	R8
		push.w	R9

		pop.w	R8
		pop.w	R9

		ret

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
            
