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
                                            ; and retain current section.
            .retainrefs                     ; And retain any sections that have
                                            ; references to current section.

TAP_COLD:	.set -1
COLD:		.set 30
WARM:		.set 40
HOT:		.set 60
EXTRA_HOT:	.set 95

ind_TAP_COLD:	.set 0
ind_COLD:		.set 2
ind_WARM:		.set 4
ind_HOT:		.set 6
ind_EXTRA_HOT:	.set 8
ind_WRAPAROUND:	.set 10

target_temp:	.word	WARM
ind_target_temp:.word	ind_WARM

;-------------------------------------------------------------------------------
RESET       mov.w   #__STACK_END,SP         ; Initialize stackpointer
StopWDT     mov.w   #WDTPW|WDTHOLD,&WDTCTL  ; Stop watchdog timer


;-------------------------------------------------------------------------------
; Main loop here
;-------------------------------------------------------------------------------

			; Configure S1 for input (P1.1)
			bis.b	#BIT1,	&P1REN			; Resistor enabled
			bis.b	#BIT1,	&P1OUT			; Pull-up resistor
			bis.b	#BIT1,	&P1IES			; Falling edge resistors interrupt
			bis.b	#BIT1,	&P1IE			; Interrupts enabled

			; Enable interrupts
			nop
			eint
			nop

main:		jmp main


set_target_temp:
			cmp.w	#TAP_COLD, target_temp
			jne		check_COLD

			mov.w	#COLD, target_temp


;-------------------------------------------------------------------------------
; Interrupt Service Routines
;-------------------------------------------------------------------------------

P1_ISR:
			; Check the source of interrupt
check_S1:
			bit.b	#BIT1,	&P1IFG
			jnc		P

service_S1:
			bic.b


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
            
