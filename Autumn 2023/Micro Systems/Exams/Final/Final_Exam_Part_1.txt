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
			bic.w	#LOCKLPM5, &PM5CTL0			; Disable power lock

			; Configure LEDs
			bic.b	#BIT0,	&P1OUT				; Red LED off
			bis.b	#BIT0,	&P1DIR 				; Direction to output
			bis.b	#BIT7,	&P9OUT				; Green LED off
			bis.b	#BIT7,	&P9DIR				; Direction to output

			nop
			bis.w	#GIE|LPM3,	SR				; Enable general interrupts and LPM3
			nop

main:		nop
			jmp		main


;-------------------------------------------------------------------------------
; Interrupt Service Routines
;-------------------------------------------------------------------------------

Timer_B0_ISR:
			bit.b	#TBIFG,	&TB0CTL				; Check source of interrupt: is it B0?
			jnc		return_from_ISR

toggle_lights:
			xor.b	#BIT7,	&P9OUT				; Toggle green LED
			xor.b	#BIT0,	&P1OUT				; Toggle red LED
			call	#delay						; delay

return_from_ISR:
			reti								; Return from interrupt

;-------------------------------------------------------------------------------
; Delay
;-------------------------------------------------------------------------------

delay:
			push	R10
			nop
			mov.w	#0xFFFF, R10

countdown:
			dec.w	R10
			nop
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
