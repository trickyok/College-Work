/*
 * ECE3567.h
 *
 */

#include "myUart.h"
#include "myLcd.h"
//#include "TempSensorMode.h"


#define RE 0x01 // Commands
#define RD 0x02
#define RS 0x03
#define TE 0x04
#define TD 0x05
#define TM 0x06
#define TC 0x07
#define TF 0x08
#define TK 0x09
#define TS 0x0A
#define TT 0x0B
#define LE 0x0C
#define LD 0x0D
#define LT 0x0E
#define LH 0x0F
#define LR 0x10
#define LO 0x11
#define LY 0x12
#define LG 0x13
#define LB 0x14
#define LV 0x15
#define LC 0x16
#define DE 0x17
#define DD 0x18
#define UT 0x19
#define SR 0x1A
#define XX 0x1B
#define XY 0x1C
#define Red 0x30    // Colors for LED
#define Orange 0x31
#define Yellow 0x32
#define Green 0x33
#define Blue 0x34
#define Violet 0x35
#define White 0x36
#define No_Color 0x39
#define R 0x52      // ASCII Characters
#define E 0x45
#define C 0x43	// Causes a Warning, but you need it for Commands
#define D 0x44
#define T 0x54
#define S 0x53
#define M 0x4D
#define K 0x4B
#define F 0x46
#define S 0x53
#define H 0x48
#define O 0x4F
#define Y 0x59
#define G 0x47
#define B 0x42
#define P 0x50
#define U 0x55
#define V 0x56
#define L 0x4C
#define X 0x58

#define Tsize 16                // Number of averages for Temperature
#define Vsize 8                 // Number of averages for Voltage
#define ADC12_SHT_16 0x0200     // 16 clock cycles for sample and hold
#define ADC12_ON 0x0010         // Used to turn ADC12 peripheral on
#define ADC12_SHT_SRC_SEL 0x0200// Selects source for sample & hold
#define ADC12_12BIT 0x0020      // Selects 12-bits of resolution
#define ADC12_P84 0x0007        // ADC12  parameter for 8.4 I/O

#define TRUE 0x01               // Boolean States
#define FALSE 0x00

#define ACLK 0x0100             // Timer_A ACLK source
#define UP 0x0010               // Timer_A Up mode

#define ADC12_P84 0x0007        // Use input P8.4 for analog input
#define ADC12_P92 0x000A        // Use input P9.2 for analog input

#define EUSCI_A0 0x05C0         // UART 0 base address
#define EUSCI_A1 0x05E0         // UART 2 base address

#define Buffer_Size 6           // Default size for val[] communications buffer
#define Full_Array 0            // Flag for array overflow

#ifndef MYCLOCKS_H_             // Conditional code for clock setup
#define MYCLOCKS_H_             // Not used
//***** Defines provided by TI ****************************************
#define LF_CRYSTAL_FREQUENCY_IN_HZ     32768
#define HF_CRYSTAL_FREQUENCY_IN_HZ     0            // FR6989 Launchpad does not ship with HF Crystal populated
#define myMCLK_FREQUENCY_IN_HZ         8000000
#define mySMCLK_FREQUENCY_IN_HZ        8000000
#define myACLK_FREQUENCY_IN_HZ         32768
#endif /* MYCLOCKS_H_ */


#ifndef MYGPIO_H_       //  Conditional assembly for GPIO
#define MYGPIO_H_
#endif /* MYGPIO_H_ */

/**************** RC Feedback Defines *************************/
#define PERIOD 0x0148           // Redefined PWM period NOT USED
#define max_step_size 0x52;     // Initial step size for PWM5 modulation
#define init_duty_cycle 0xA4  // Maximum count for PWM5 duty cycle
#define max_duty_cycle 0x0148 // Maximum count for PWM5 duty cycle
#define LED_low 25              // Number of .1 millivolts for LED hysteresis used in RC Control
#define LED_high 25             // Number of .1 millivolts for LED hysteresis used in RC Control
#define RC_low_limit 1          // Number of .1 millivots  for RC voltage hysteresis
#define RC_high_limit 1         // Number of .1 millivolts for RC voltage hysteresis
#define RGB_Period 0x00D0  // NOTE: MAXs can't be larger than this number


/***************** ALL Function  Prototypes are listed here ***************/
void Init_ADC12(void);
void clearLCD(void);                // Clears LCD Display - myLcd.c
void Command_Handler(uint16_t);     // Handles Serial port Transmit and Receive - mani.c
void Communications_Link(void);     // Establishes serial link through UART 0 and sends initial messages - myUart.c
void displayTemp(void);             // LCD Temperature Display Routine - TempSensorMode.c
void Init_Clocks(void);             // Initializes internal clocks (from TI) - MyClocks.c
void Init_Command_Timer(void);      // Initializes the Timer A0 used for the main.c ISR - Command.c
void Init_GPIO(void);               // Initializes GPIO - myGpio.c
void Init_LCD(void);                // Initializes LCD Display Drover = MyLcd.c
void Init_PWM(void);                // Initializes Timer_B0 and PWM 2, 3, and 4 for RGB LED Control
void Init_RC(void);                 //  Initialization routine for the RC Voltage Controller - RC_Control.c
int myUart_init    ( uint16_t, uint32_t, EUSCI_A_UART_initParam * );    // Initialization of UARTs. Called by Communications_Link() - myUart.c
int myUart_writeBuf( uint16_t, unsigned char *, uint16_t, int );        // Transmit buffer handler for UARTS - myUart,c
int myUart_readBuf ( uint16_t, unsigned char *, uint16_t * );           //  Receive buffer handler for UARTS - myUart.c
void parse_Command(void);           // Constructs command from received character string and acts on each command - Command.c
void showChar(char, int);           //  Character display routine - MyLcd.c
void tempSensor(void);              // Main function called in TempSensorMode - TempSensorMode.c
void tempSensorModeInit(void);      // Initializes varialbes and heating element for TempSensorMode -  - TempSensorMode.c
void update_RGB(void);              // Selects color for temperature range if in Temeprature Mode.  Otherwise ust updates RGB LED - RGB_LED.c
void displayVolts(void);            // Displays current voltage on the LCD in RC_Command Mode - RC_Mode.c
void RC_Voltage(void);              //  Calculates the RC Voltage from ADC A5 Data in RC_Command Mode - RCMode.c
void RC_Feedback(void);             //  Feedback Controller for RC_Command Mode - RC_Control.c
void PWM_null(void);                //  Sets all PWMS and variables to zero for the RGB LED, Turning it off - RGB_LED.c
void Temp_Feedback(void);           //  Feedback Controller for Temperature Control -  - RGB_LED.c
void Init_Timer_A0(void);
void update_RC(void);

/********************************************************************/
/***************** Place all globals here ***************************/
/********************************************************************/

/**  From main.c **/

volatile unsigned int  ISR_Counter;
volatile char ISR_Flag;
volatile char ISR_Flag_10;
volatile unsigned int  ISR_Counter;
//volatile unsigned char ISR_Flag = 0;
//volatile unsigned char ISR_Flag_10 = 0;
//extern volatile unsigned int duty_cycle_red;

/************** Lab #4 variables  ************************************/
//extern volatile unsigned int display_number;
//extern volatile char Str[6];    // Lab #4
//extern volatile unsigned int n; // Lab #4

/***************** Lab #5 variables **********************************/
//extern volatile unsigned char Command_Flag;
//extern volatile unsigned int length;

/**  From ADC12.c **/

volatile unsigned short ADCValue0;
volatile unsigned short ADCValue1;

/**  From RCMode.c **/

volatile unsigned int volts;
volatile unsigned int tempRC;
volatile unsigned int k2, sum2;
volatile unsigned int RC_duty_cycle;

/**  From RGB_LED.c **/

volatile int duty_cycle_red;
volatile int duty_cycle_green;
volatile int duty_cycle_blue;

//volatile unsigned int duty_cycle_red;
//volatile unsigned int duty_cycle_green;
//volatile unsigned int duty_cycle_blue;
volatile short LED_Color;
unsigned char State;
unsigned char step_size;
unsigned char red_count;


/**  From TempSensorMode.c **/

volatile char tempUnit;         // Temperature Unit
volatile unsigned int deg;
volatile unsigned int degC;                       // Celcius measurement
volatile unsigned int degF;                       // Fahrenheit measurement
volatile unsigned int k, sum;

/**  From Command.c **/

volatile unsigned int New_Data;
volatile unsigned int RC_SetPoint;
volatile short LED_Color;

volatile char RC_Voltage_Mode;
volatile char Temp_Mode;
volatile char LCD_Control;
volatile char LED_Test_Mode;

volatile char Command;
volatile char Command_Flag;
volatile unsigned short step;
volatile char val[Buffer_Size];
volatile unsigned int New_Data;
volatile unsigned int T_SetPoint;
volatile unsigned int  ISR_Counter;
volatile unsigned int  Toggle_Counter;

volatile char T_Measure;

volatile char LED_Test;




volatile unsigned int  Flash, toggle, k, sum, deg;
volatile unsigned int New_Data;
extern volatile unsigned int length;
//extern volatile unsigned int RC_Duty_Cycle;
//extern volatile unsigned int volts;
//extern volatile unsigned short ADCValue0;
//extern volatile unsigned short ADCValue1;
//extern volatile unsigned char ISR_Flag;
//extern volatile unsigned char tempUnit;
volatile int duty_cycle_red;
volatile int duty_cycle_green;
volatile int duty_cycle_blue;
//extern volatile unsigned char proximity,lock;

/**  From myUart.c **/

volatile unsigned int length;

/** From Display.c **/


volatile unsigned int display_number;
volatile char Str[6];
volatile unsigned int n;





/************************************************** END OF CODE *************************************************/








