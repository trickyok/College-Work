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
			.data
array1:		.byte 3, -37, 17, 11
sum:		.space 1
avg:		.space 1


RESET       mov.w   #__STACK_END,SP         ; Initialize stackpointer
StopWDT     mov.w   #WDTPW|WDTHOLD,&WDTCTL  ; Stop watchdog timer



;-------------------------------------------------------------------------------
; Main loop here
;-------------------------------------------------------------------------------

; Task 1
			clr.b 	R4					; R4 is index
			clr.b	R5					; clear!

			mov.b	#0,		   R4		; R4 is index
			mov.b	#0,		   R5		; Initializing R5
            add.b   &array1,   R5       ; R5 <- 3
    		add.b   &array1+1, R5       ; R5 <- R5 + -37
    		add.b   &array1+2, R5       ; R5 <- R5 + 17
    		add.b   &array1+3, R5       ; R5 <- R5 + 11

			mov.b	R5, &sum		    ; sum <- R5

			rra.b   R5					; R5 / 2
			rra.b	R5					; R5 / 2

			add.b	R5, &avg			; avg <- R5


; Task 2
			clr.b	R4

			mov.b	#0xB4, &0x1C11		; 0x1C11 <- 0xB4
			mov.b	#0xFA, &0x1C12		; 0x1C12 <- 0xFA
			mov.b	#0x1C, &0x1C13		; 0x1C13 <- 0x1C
			mov.b	#0xAB, &0x1C14		; 0x1C14 <- 0xAB
			mov.b	#0x27, &0x1C15		; 0x1C15 <- 0x27
			mov.b	#0xD3, &0x1C16		; 0x1C16 <- 0xD3
			mov.b	#0x95, &0x1C17		; 0x1C17 <- 0x95


main:
			jmp		main
			nop

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
            
