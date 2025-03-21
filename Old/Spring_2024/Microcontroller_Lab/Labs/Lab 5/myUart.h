// Gregg Chapman, The Ohio State University, February 2018
// ----------------------------------------------------------------------------
// uart.h   ('FR6989 Launchpad)
// ----------------------------------------------------------------------------
#ifndef MYUART_H_
#define MYUART_H_

//***** Header Files **********************************************************
#include <driverlib.h>
#include "ECE3567.h"

//***** Defines ***************************************************************
#define ASCII_ENTER       0x0D
#define ASCII_CR          0x0D
#define ASCII_LINEFEED    0x0A
#define ASCII_LF          0x0A

#define NOCRLF            0
#define CRLF              1

#define NOECHO            0
#define DOECHO            1

#define DEFAULT_MAX_READ  80

#define NUM_CHANNELS      2
#define CHANNEL_0         0
#define CHANNEL_1         1
#define BACKCHANNEL_UART  1                                                     // Backchannel UART - which connects to PC through emulation port on the LaunchPad

#define STATUS_INIT_SUCCESSFUL     0
#define STATUS_ALREADY_OPEN        1
#define STATUS_INIT_FAILED         2
#define STATUS_FAIL_NOBUFFER       3
#define STATUS_FAIL_BUSY           4
#define STATUS_RX_MISSED_REAL_TIME 5

//***** TypeDefs **************************************************************
struct Channel
{
	const uint16_t BaseAddress;                                                 // Base Address of EUSCI_A port                     
	const uint8_t  TxPort;														// GPIO Port settings for TX pin                    
	const uint8_t  TxPin;														                                                    
	const uint8_t  TxSel;														                                                    
	const uint8_t  RxPort;														// GPIO Port settings for RX pin                    
	const uint8_t  RxPin;														                                                    
	const uint8_t  RxSel;														                                                    
	uint32_t BaudRate;															// Baud Rate
	uint8_t  Open;																// Open - UART port has been opened and configured  
	uint8_t  TxBusy;														    // Busy -
	uint8_t  TxRDY;
	uint8_t  RxBusy;
	uint8_t  RxRDY;
	uint8_t  RxEcho;
} Channel;

struct Uart_t
{
	const uint16_t NumChannels;
	struct Channel Channels[ NUM_CHANNELS ];
} Uart_t;


//***** Global Variables ******************************************************
extern struct Uart_t myUart;
extern EUSCI_A_UART_initParam myUart_Param_9600_8N1_SMCLK8MHz;
extern EUSCI_A_UART_initParam myUart_Param_9600_8N1_ACLK32Kz;




#endif /* MYUART_H_ */

/************************************************** END OF CODE *************************************************/
