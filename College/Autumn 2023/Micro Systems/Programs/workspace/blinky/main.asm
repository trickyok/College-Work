;-------------------------------------------------------------------------------
; MSP430 Assembler Code Template for use with TI Code Composer Studio
;
;
;BLINKY V3
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

			clr.b	#BIT0,

			; configure red LED for output - P1.0 - P1xyz registers BIT0
			bic.b	#BIT0, &P1OUT
			bis.b	#BIT0, &P1DIR

			; configure S1 for input - P1.2 - P1xyz registers BIT1
			bis.b	#BIT1, &P1REN			; enable resistor
			bis.b	#BIT1, &P1OUT			; pull-up resistor
			bis.b	#BIT1, &P1IES			; interrupt on falling edge
			bis.b	#BIT1, &P1IE			; interrupt enable for port 1

;			bic.w	#LOCKPM5,&PM5CTL0

			; clear all IFGs in P1
			clr.b	&P1IFG

			nop
			eint
			nop
			bis.w	#GIE|LPM3,	SR			; Enable general interrupts and LPM3
			nop

main:		jmp main						; infinite loop
			nop


;-------------------------------------------------------------------------------
; Interrupt Service Routines
;-------------------------------------------------------------------------------

P1_ISR:
			bit.b	#BIT1, P1IFG
			jnc		ret_from_P1_ISR

			xor.b	#BIT0, &P1OUT			; toggling LED output

clear:
			bic.b	#BIT1, P1IFG

ret_from_P1_ISR:
			reti							; return from interrupt

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
            
            .sect	".int37"
            .short	P1_ISR

