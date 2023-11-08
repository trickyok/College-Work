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


			; Configure red LED for output (P1.0)
			bic.b	#BIT0,	&P1OUT			; Red LED Off
			bis.b	#BIT0,	&P1DIR			; Direction set to output

			; Configure S1 for input (P1.1)
			bis.b	#BIT1,	&P1REN			; Resistor enabled
			bis.b	#BIT1,	&P1OUT			; Pull-up resistor
			bis.b	#BIT1,	&P1IES			; Falling edge resistors interrupt
			bis.b	#BIT1,	&P1IE			; Interrupts enabled

			; Configure green LED for output (P9.7)
			bic.b	#BIT7,	&P9OUT			; Red LED Off
			bis.b	#BIT7,	&P9DIR			; Direction set to output

			; Configure S2 for input (P1.2)
			bis.b	#BIT2,	&P1REN			; Resistor enabled
			bis.b	#BIT2,	&P1OUT			; Pull-up resistor
			bis.b	#BIT2,	&P1IES			; Falling edge resistors interrupt
			bis.b	#BIT2,	&P1IE			; Interrupts enabled

			; Disable power lock
			bic.w	#LOCKPM5,	&PM5CTL0

			; Enable interrupts
			nop
			eint
			nop

main:		jmp main


;-------------------------------------------------------------------------------
; Interrupt Service Routines
;-------------------------------------------------------------------------------

P11_ISR:
			; Check the source of interrupt
			; Is it P1.1?
			bit.b	#BIT1,	&P1IFG
			jnc		P12_ISR

			; Is P1.1, toggle red LED
			xor.b	#BIT0,	&P1OUT			; Toggle output

			; Jump to end
			jmp return_ISR


P12_ISR:
			; Is it P1.2?
			bit.b	#BIT2, &P1IFG
			jnc		return_ISR

			; Is P1.2, toggle green LED
			xor.b	#BIT7,	&P9OUT


 return_ISR:
 			reti							; Return from interrupt

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
            
