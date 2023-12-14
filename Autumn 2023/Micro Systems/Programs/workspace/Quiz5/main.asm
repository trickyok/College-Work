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

LENGTH		.set 	10
x_array:	.word	    2, 160, 252, 105,  42
e_array: 	.word	 1030,  77,   0, 180, 103
N_array: 	.word	  221, 221, 207, 225, 209
y_array: 	.space 	LENGTH
;-------------------------------------------------------------------------------
            .text                           ; Assemble into program memory.
            .retain                         ; Override ELF conditional linking
            .retainrefs                     ; And retain any sections that have
;-------------------------------------------------------------------------------
RESET       mov.w   #__STACK_END,SP         ; Initialize stackpointer
StopWDT     mov.w   #WDTPW|WDTHOLD,&WDTCTL  ; Stop watchdog timer

;-------------------------------------------------------------------------------
; Main loop here
;-------------------------------------------------------------------------------
			mov.w	#LENGTH-2, R4

			mov.b	#71, R4
			add.b	#73, R4
			nop

next:		mov.w	x_array(R4), R6
			mov.w	e_array(R4), R7
			mov.w	N_array(R4), R8
			call	#mod_exp
			mov.w	R5, y_array(R4)

			decd.w	R4
			jhs		next

done: 		jmp		done
			nop


;-------------------------------------------------------------------------------
; Subroutine: mod_exp
; Inputs: R6 unsigned 16-bit integer x -- returned unchanged
;		  R7 unsigned 16-bit integer e -- returned unchanged
; 		  R8 unsigned 16-bit nonzero integer N -- returned unchanged
;
; 			Both x and N need to be strictly less than 256
;
; Output: R5 unsigned 16 bit integer y -- R5 is output, may be changed
; 		  	y = x^e % N
;				i.e., 0 <= y < N is the remainder when x^e is divided by N
;
;
; All other core registers in R4-R15 unchanged
;-------------------------------------------------------------------------------
mod_exp:
; Level 1
; Indicate your level above and add your code below

			push.w	R6					; R6 is x
			push.w	R7					; R7 is e
			push.w	R8					; R8 is N
			push.w	R9					; R9 is index

			clr.w	R5
			clr.w	R9

			inc.w	R9					; Increment counter to 1
			mov.w	R6, R5				; Copy R6 to R5

edgeCase0:
			cmp.w	#0, R7				; Check if e = 0
			jne		edgeCase1
			mov.w	#1,	R5				; Assign 0 to R5
			jmp		end

edgeCase1:
			cmp.w	#1, R7				; Check if e = 1
			jne		loop1
			jmp		end

loop1:
			push.w	R6
			mov.w 	R5, R6
			call	#x_times_y			; Multiply y times y
			pop.w	R6					; Restore x
			call	#mod					; Find mod of y
			mov.w	R8, R5				; Move N to y
			push.w	R9
			rra.w	R9					; Double counter
			cmp.w	R7, R9				; Compare doubled counter to e
			jlo		loop1
			pop.w	R9					; Restore counter otherwise

loop2:
			cmp.w	R7, R9				; Compare counter to e
			jge		end					; End loop if counter equals e
			call	#x_times_y			; Multiply x times y
			call	#mod					; Find mod of y
			inc.w	R9
			jmp		loop2

end:
			pop.w	R9					; Restore all registers
			pop.w	R8
			pop.w	R7
			pop.w	R6

			ret

;-------------------------------------------------------------------------------
; Subroutine: mod
; input: R5 unsigned 16-bit integer x -- may be modified
; 		 R8 unsigned 16-bit nonzero integer N -- returned unchanged
; 			you can assume that R8 is nonzero, no need to check
;
; output: R5 unsigned 16-bit integer y
; 		  	y = x % N is a number 0 <= y < N s.t. x=y mod N
;			y is the remainder when x is divided by N
;
; All other core registers in R4-R15 unchanged
;-------------------------------------------------------------------------------
mod:
; Add your code below

divisionLoop:						; Division loop
			sub.w	R8,	R5			; Subtract R8 from R5
			cmp.w	R8, R5			; Break loop if R8 > R5
			jlo		divisionLoop

			ret

;-------------------------------------------------------------------------------
; Subroutine: x_times_y
; Inputs: unsigned byte x in R5 -- returned unchanged
;         unsigned byte y in R6 -- returned unchanged
;
; Output: unsigned word in R12 -- R12 = R5 * R6
;
; All other core registers in R4-R15 unchanged
;-------------------------------------------------------------------------------
x_times_y:

; Save afftected core registers on stack - You can add this part last once you
; know which registered are modified
			push.w 	R6
			push.w	R10
			push.w	R11

			clr.w	R12				; R12 will accumulate R5*R6
			clr.w	R10				; R10 will index bits j = 0, 1, ..., 7
			mov.w	#BIT0, R11 		; R11 has the bitmask to use with tst.w

check_next_bit:
			bit.w	R11, R5			; Is the jth bit 1?
			jnc		prep_next_bit	; If not prepare for checking next bit

			add.w	R6, R12			; Bit j is 1, add

prep_next_bit:
			rla.w	R11				; Prepare next bitmask
			rla.w	R6				; Prepare shifted version of R6
			inc.w	R10				; increase bit index
			cmp.w	#8, R10			; Are we done with all bits?
			jlo		check_next_bit

; Restore saved core registers from stack
; Watch the order and make sure not to leave anything behind
			pop.w	R11
			pop.w	R10
			pop.w	R6

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
            
