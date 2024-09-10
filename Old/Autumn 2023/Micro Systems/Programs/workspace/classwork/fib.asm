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

    		push	#4
    		push	#17

    		push 	#0

    		call 	#fib

			pop		R5
			add.w	#4, SP

done:		jmp 	done
			nop

;-------------------------------------------------------------------------------
; Subroutine: 	almost_fib
; Inputs:
;
;
; Output:
;
; All other core registers in R4-R15 unchanged
;-------------------------------------------------------------------------------

almost_fib:
			mov.w	6(SP), 2(SP)
			add.w	4(SP), 2(SP)

			ret

;-------------------------------------------------------------------------------
; Subroutine:	fib
;-------------------------------------------------------------------------------

fib:
			tst.w	8(SP)
			jeq		end_fib

			add.w	6(SP), 2(SP)
			mov.w	4(SP), 6(SP)
			mov.w	2(SP), 4(SP)

			dec.w	8(SP)
			jmp		fib


end_fib:
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

