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
			; Configure red LED for output, start with unlit LED
			; Red LED is connected to P1.0
			bic.b	#BIT0, &P1OUT				; Red LED off
			bis.b	#BIT0, &P1DIR 				; Direction to outpu

			; Configure green LED for output, start with unlit LED
			; Green LED is connected to P9.7
			bic.b	#BIT7, &P9OUT
			bis.b	#BIT7, &P9DIR

			; Configure push buttons S1 and S2 for input
			; S1 is connected to P1.1; S2 is connected to P1.2
			bis.b	#BIT1|BIT2, &P1REN 			; Resistor enabled
			bis.b	#BIT1|BIT2, &P1OUT			; Pullup resistor
			bic.b	#BIT1|BIT2, &P1IES			; Interrupt on raising-edge
			bis.b	#BIT1|BIT2, &P1IE			; Enable port interrupts

			; Disable power lock
			bic.w	#LOCKLPM5, &PM5CTL0

			; Clear all IFGs in P1 in case they are set during config
			clr.b  	&P1IFG

			nop
			eint 				; Enable general interrupts
			nop

main:		jmp 	main

;-------------------------------------------------------------------------------
; Interrupt Service Routines
;-------------------------------------------------------------------------------
P1_ISR:

check_S1:	; Check source of interrupt: is it P1.1?
			bit.b	#BIT1, &P1IFG
			jnc		check_S2

service_S1:
			xor.b	#BIT7, &P9OUT
			bic.b	#BIT1, &P1IFG	; clear the flag

check_S2:
			; Check source of interrupt: is it P1.2?
			bit.b	#BIT2, &P1IFG
			jnc		return_from_P1_ISR

service_S2:
			xor.b	#BIT0, &P1OUT
			bic.b	#BIT2, &P1IFG	; clear the flag

return_from_P1_ISR:

			reti					; return from interrupt


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

            .sect	".int37"				; I/O Port 1 Vector
			.short	P1_ISR
