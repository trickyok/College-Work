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
			.data
			.retain
			.retainrefs

LENGTH: 	.set	2*8
array_1: 	.word   34590, 29032, 42887, 3423, 45996, 46895, 5654, 16842
array_2: 	.space  LENGTH
empty: 		.space	LENGTH

            .text
			.retain
			.retainrefs

;-------------------------------------------------------------------------------
RESET       mov.w   #__STACK_END,SP         ; Initialize stackpointer
StopWDT     mov.w   #WDTPW|WDTHOLD,&WDTCTL  ; Stop watchdog timer
;-------------------------------------------------------------------------------
; Main loop here
;-------------------------------------------------------------------------------
			mov.w	#LENGTH-2, R4

read_nxt: 	mov.w 	array_1(R4), R5
			call	#signed_div_by_16
ret_addr:	mov.w	R5, array_2(R4)

			decd.w  R4
			jhs		read_nxt

main: 		jmp		main
			nop

;-------------------------------------------------------------------------------
; Subroutine: div_by_16
; Input: 	16-bit unsigned number in R5 -- modified
; Output: 	16-bit unsigned number in R5 -- R5 = floor(R5/16)
;-------------------------------------------------------------------------------
signed_div_by_16:
			rra.w	R5
			rra.w	R5
			rra.w	R5
			rra.w	R5
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
