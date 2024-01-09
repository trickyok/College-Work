;-------------------------------------------------------------------------------
; MSP430 Assembler Code Template for use with TI Code Composer Studio
;
; ECE 2560 Final Exam -- Autumn 2023
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

; Configure Timer B0 to throw interrupts
			bis.w	#TBCLR, &TB0CTL				; reset timer
			bis.w	#TBSSEL__ACLK, &TB0CTL		; source is ACLK
			bis.w	#MC__CONTINUOUS, &TB0CTL	; continuous mode
			bis.w	#CNTL__12, &TB0CTL			; counter length = 12 bits
			bis.w	#ID__4, &TB0CTL				; divide freq. by 4
			bis.w	#TBIE, &TB0CTL 				; enable interrupts
			clr.w	R4

			; clear all IFGs in P1 and B0
			clr.b	&P1IFG
			clr.b	&TB0IFG

			nop
			bis.w	#GIE|LPM3,	SR				; Enable general interrupts and LPM3
			nop


;-------------------------------------------------------------------------------
; Interrupt Service Routine
;-------------------------------------------------------------------------------
Timer_B0_ISR:
			bit.b	#TBIFG,	&TB0CTL				; Check source of interrupt: is it B0?
			jnc		return_from_ISR

			inc.w	R4
			rrc.w	R4
			jnc		red_on

green_on:
			bis.b	#BIT1,	&P1OUT				; Set output value
			bis.b	#BIT1,	&P1DIR				; Change direction to output
			call	#delay						; delay
			rrc.w	R4							; skip second delay
			jnc		return_from_ISR
			call	#delay						; delay
			jmp		return_from_ISR

red_on:
			bic.b	#BIT0, 	&P1OUT
			bis.b	#BIT0, 	&P1DIR
			xor.b	#BIT0,	&P1OUT				; Toggle red LED
			call	#delay						; delay
			rrc.w	R4							; skip second delay
			jnc		return_from_ISR
			call	#delay						; delay

return_from_ISR:
			reti								; Return from interrupt


;-------------------------------------------------------------------------------
; Delay
;-------------------------------------------------------------------------------

delay:
			push	R10
			nop
			mov.w	#0x000F, R10

countdown:
			dec.w	R10
			nop
			jnz		countdown

			pop 	R10
			ret


;-------------------------------------------------------------------------------
; Stack Pointer definition
;-------------------------------------------------------------------------------
            .global __STACK_END
            .sect   .stack
            
;-------------------------------------------------------------------------------
; Interrupt Vectors
;-------------------------------------------------------------------------------
            .sect 	".int50"				; Timer B0 Vector
            .short	Timer_B0_ISR

            .sect   ".reset"                ; MSP430 RESET Vector
            .short  RESET
