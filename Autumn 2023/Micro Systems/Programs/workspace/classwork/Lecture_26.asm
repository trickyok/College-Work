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

; Configure Timer B0 to raise interrupts
			bis.w	#TBCLR, &TB0CTL
			bis.w	#TBSSEL__ACLK, &TB0CTL		; connected to ACLK
			bis.w	#MC__CONTINUOUS, &TB0CTL	; continuous mode
			bis.w	#TBIE, &TB0CTL 				; enable interrupts

			; configure red LED for output - P1.0
			bic.b	#BIT0, &P1OUT
			bis.b	#BIT0, &P1DIR

			bic.w	#TBIFG,	&TB0CTL



			nop
			bis.w	#GIE|LPM3,	SR				; Enable general interrupts and LPM3
			nop

main:		jmp		main
			nop

;-------------------------------------------------------------------------------
; Interrupt Service Routine
;-------------------------------------------------------------------------------

Timer_B_ISR:
			bit.b	#TBIFG,	&TB0CTL
			jnc		return_from_ISR

			xor.b	#BIT0,	&P1OUT				; Toggle red LED

			bic.b	#TBIFG,	&TB0CTL				; Clear IFG -- 16 bit

return_from_ISR:
			reti

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

            .sect	".int40"
            .short	Timer_B_ISR
