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

    		mov.w	#5, R5
    		mov.w	#6, R6
    		call	#x_Times_y




;-------------------------------------------------------------------------------
; Subroutine: 	x_Times_y_inefficient
; Inputs: 		unsigned 8-bit number x in R5 -- Returned unchanged
;				unsigned 8-bit number y in R6 -- Returned unchanged
;
; Output:		unsigned 16-bit number in R12 -- R12 = R5 * R6
;
; All other core registers in R4-R15 unchanged
;-------------------------------------------------------------------------------

x_Times_y:
											; Initialize Registers
Init		clr		R10						; R10 is counter
			clr		R12						; R12 is result
			mov.w	#BIT0, R11				; R11 is bitmask

Repeat:
			bit.w	R11, R5					; Check first bit of value in R5
			jnc		next_bit

; code reaches here if bit is 1
			add.w	R6, R12					; Add R6 to R12

next_bit:
			rla.w	R6						; Shift bit
			rla.w	R11						; Shift bit
			inc.w	R10						; Increment counter
			cmp.w	#8, R10
			jne		Repeat					; Exit loop if R10 = 8


			pop R11
			pop R10
			pop R6

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
            
