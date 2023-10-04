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
            .data                           ; Assemble into RAM
            .retain                         ; Override ELF conditional linking
            .retainrefs                     ; And retain any sections that have

max_value:	.space  2
max_count:  .space 	2

			.word   0x11, 0x11, 0x11

array: 		.word	5, 3, -5, 5, 17, 7, -3, 17, -3, 5, 13, -3, 17
LENGTH: 	.set	26

			.word   0x11, 0x11, 0x11

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

; Add your code here
; Use the labels given below (alphabetical ordering)
; You can add more labels if really necessary -- but keep in mind
; that the task can be done in ~15 lines
; If you need a lot more, you are making spaghetti

main:
			mov.w 	#0, R4					; Index R4 starts at 0
			mov.w 	array(R4), R5			; Assign first value in array to R5
			mov.w	array(R4), max_value	; First value in array starts as max
											; value
			mov.w	#1, max_count			; Count starts at 1

			jmp		compare_to_max			; Move to first method


compare_to_max:
			cmp.b 	R5, max_value			; Compare value to current max
			jhs 	new_max					; Jump to new_max method


next_element:

			cmp.w 	#LENGTH, R4				; Check if index has reached end of
											; array
			jhs		done					; Jump to end of program

			inc		R4						; Increment array index
			mov.w 	array(R4), R5			; Move value R4 in array to R5
			jmp		compare_to_max			; Jump to comparison method


new_max:
			mov.w	R5, max_value			; Assign R5 to max_value
			mov.w	#1, max_count			; Reset counter

			jmp		next_element			; Jump to method


same_max:
			inc		max_count				; Increment frequency counter
			jmp		next_element			; Jump to method


done:		jmp 	done					; End of program
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
            
