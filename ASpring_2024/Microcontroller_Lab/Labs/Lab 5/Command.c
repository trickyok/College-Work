/*******************************************************************************/
// ----------------------------------------------------------------------------
// The Ohio State University
// ECE 3567 - Microcontrollers Lab
// Autumn Semester 2019
// Instructor: Prof. Gregg Chapman
// (MSP430FR6989 Launchpad) - Texas Instruments Corporation
// Code Composer Studio version 8.1
// ommand.c
// This module contains files necessary to implement the entire Command Sturcture
// for the ECE 3567 Project - GJC 9/2/2019
// ----------------------------------------------------------------------------
/*******************************************************************************/
//***** Header Files **********************************************************
#include <driverlib.h>
#include "stdio.h"
#include "string.h"
#include "ECE3567.h"

//***** Global Variables ******************************************************


//*****************  Use the UART to R/W from the "Dumb Terminal"  *********************************

void Command_Handler(uint16_t length)
{
    length = Full_Array;   //DEFAULT size which means use the full array
    // Read a character from the terminal (we don't validate it's between 1 and 5)
    myUart_readBuf( BACKCHANNEL_UART, (unsigned char *)val, &length );
    myUart_writeBuf( BACKCHANNEL_UART, "", NULL, CRLF );
    myUart_writeBuf( BACKCHANNEL_UART, "Command: ", NULL, CRLF );
    myUart_writeBuf( BACKCHANNEL_UART, (unsigned char *)val,length,CRLF);
    length = 2;
    Command_Flag = 0;
    EUSCI_A_UART_clearInterrupt( EUSCI_A1, EUSCI_A_UART_RECEIVE_INTERRUPT);
    EUSCI_A_UART_enableInterrupt( EUSCI_A1, EUSCI_A_UART_RECEIVE_INTERRUPT);
    return;
}


//*******************************  Decode the Command  ********************************************
void parse_Command()
{

/*********************** 1) Read in 2 Letter Command *********************/
    if(val[0] == L)		
    {
        if(val[1] == E)
        	Command = LE;
	else if(val[1] == H)
		Command = LH;
	else if(val[1] == R)
		Command = LR;
	else if(val[1] == C)
		Command = LC;
	else if(val[1] == O)
		Command = LO;
	else if(val[1] == Y)
		Command = LY;
	else if(val[1] == G)
		Command = LG;
	else if(val[1] == B)
		Command = LB;
	else if(val[1] == G)
		Command = LV;
    }
    else if(val[0] == R)
    {
	if(val[1] == E)
        	Command = RE;
    }
    else if(val[0] == T)
    {
    	if(val[1] == E)
    		Command = TE;
    else
      {
            Command = NULL;
              myUart_writeBuf( BACKCHANNEL_UART, "UNKNOWN COMMAND ", NULL, CRLF );
              myUart_writeBuf( BACKCHANNEL_UART, "", NULL, CRLF );
              // Ask for the next Command
      }

    /*********************** 2) If there is Data Load up to a 4-digit number,  CLEAR BUFFER  *********************/

    if(length >=5)
    {
        New_Data = 0;
        New_Data = (val[2]-48)*1000 + (val[3]-48)*100 + (val[4]-48)*10 + (val[5]-48);

  /*********************************** 3) Clear the val[] array ********************************************/
        length = 2;
        val[2]=0;
        val[3]=0;
        val[4]=0;
        val[5]=0;
    }
    /************************************* 4) Act on the Command *************************************************/

    switch(Command)
    {

    	case LE:                    // Enable  LED
		

        break;

        case LH:                    // Hot!  Flash LED Red
            if(LED_Test_Mode == TRUE)
            {
                LED_Color = Red;
                Flash = TRUE;
            }

                break;
        case LR:                    // Red
            if(LED_Test_Mode == TRUE)
            {
                LED_Color = Red;
                Flash = FALSE;
            }
               break;

        case LC:                    // COLD! Flash Purple

		if(LED_Test_Mode == TRUE)
		    {
		        LED_Color = Purple;
		        Flash = TRUE;
		    }
               break;
        case LO:			// LED Orange

          	   break;
        case LY:			// LED Yellow

          	   break;
        case LG:			// LED Green

          	   break;
        case LB:			// LED Blue

          	   break;
        case LV:			// LED Violet

          	   break;
        case RE:

          	   break;

        case TE:

          	   break;

        default:
                break;
    }
    /******************************************** Clear Command and Ask for the next one ********************/
    Command = NULL;
    myUart_writeBuf( BACKCHANNEL_UART, "Please enter the next Command Code: ", NULL, CRLF );
}


/************************************************** END OF CODE *************************************************/




