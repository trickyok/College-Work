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
			.data
            .retain                         ; Override ELF conditional linking
            .retainrefs                     ; And retain any sections that have

LENGTH: 	.set	36

array_1: 	.space 	LENGTH
	 		.word 	-2

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

; Code to populate test array
			clr.w	R5
_prep: 		mov.w	R5, array_1(R5)
			incd.w	R5
			cmp.w	#LENGTH, R5
			jlo		_prep


;-------------------------------------------------------------------------------
; Enter your code here

reverseArray:
		clr.b R6					    ; R6 = 0 is counter
		mov #LENGTH, R7					; R7 stores length num
		add #LENGTH, R7					; Doubles R7 for dealing with word array
		decd R7							; decrements R7
		mov &array_1, R4				; Move front value to R4
		mov &array_1+LENGTH, R5			; Move end value to R5
		cmp R4, R5						; is array non-reversable (0 or 1 entry)
		jeq done						; done

loop:

		mov array_1(R6), R4				; Move front value to R4
		mov array_1(R7), R5				; Move end value to R5
		mov R5, array_1(R6)				; Move R5 buffer value to end
		mov R4, array_1(R7)				; Move R4 buffer value to front

		incd.b R6						; double increment
		decd.b R7						; double decrement
		cmp	R6, R7						; are the pointers at the middle?
		jne	loop						; if not, loop again

done:
		ret


;-------------------------------------------------------------------------------

; Use defined constant LENGTH = 36 rather than numbers
; The compiler does understand LENGTH+2, LENGTH-2, LENGTH/2 etc.



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
            
