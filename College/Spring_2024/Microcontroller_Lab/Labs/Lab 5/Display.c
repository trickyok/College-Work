// ----------------------------------------------------------------------------
// The Ohio State University
// ECE 3567 - Microcontrollers Lab
// Spring Semester 2020
// Instructor: Prof. Gregg Chapman
// (MSP430FR6989 Launchpad) - Texas Instruments Corporation
// Code Composer Studio version 9.0.1
// main.c  - GJC 2/16/2020
// ----------------------------------------------------------------------------
/*******************************************************************************//* Interrupt Service Routine used to time Blinking Red and Green LEDs
 * This is the 4rd lab in Spring of 2020
 * Resources: Timer A0, BO, Ports  1 and 9
 */

//*************************************** Header Files ********************************************
#include <driverlib.h>
#include "stdio.h"
#include "string.h"
#include "ECE3567.h"



void displayString(char *Str, unsigned int n)
{
    unsigned char i;
    int k;
    char j;
    unsigned int position[6] = {pos1,pos2,pos3,pos4,pos5,pos6};

    clearLCD();
    for(i=0;i<n;i++)
    {
        j  = Str[i];
        k = position[i];
        showChar(j, k);

        }
        return;
}

void displayNumber(unsigned int display_number)
{

    clearLCD();

    // Decimal point
//    LCDMEM[pos3+1] |= 0x01;
    return;
}

void displayTemp()
{
    clearLCD();

    showChar('F',pos6);

    // Degree symbol
    LCDMEM[pos5+1] |= 0x04;
    return;
}
