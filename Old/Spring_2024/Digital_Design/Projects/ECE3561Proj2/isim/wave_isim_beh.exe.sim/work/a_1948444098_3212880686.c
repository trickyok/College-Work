/**********************************************************************/
/*   ____  ____                                                       */
/*  /   /\/   /                                                       */
/* /___/  \  /                                                        */
/* \   \   \/                                                       */
/*  \   \        Copyright (c) 2003-2009 Xilinx, Inc.                */
/*  /   /          All Right Reserved.                                 */
/* /---/   /\                                                         */
/* \   \  /  \                                                      */
/*  \___\/\___\                                                    */
/***********************************************************************/

/* This file is designed for use with ISim build 0xfbc00daa */

#define XSI_HIDE_SYMBOL_SPEC true
#include "xsi.h"
#include <memory.h>
#ifdef __GNUC__
#include <stdlib.h>
#else
#include <malloc.h>
#define alloca _alloca
#endif
static const char *ng0 = "/home/gage/Documents/College-Work/ASpring_2024/Digital_Design/Projects/ECE3561Proj2/wave.vhd";
extern char *IEEE_P_1242562249;

char *ieee_p_1242562249_sub_1006216973935652998_1035706684(char *, char *, char *, char *, int );


static void work_a_1948444098_3212880686_p_0(char *t0)
{
    char t18[16];
    char *t1;
    char *t2;
    char *t3;
    int t4;
    int t5;
    char *t6;
    char *t7;
    int t8;
    unsigned int t9;
    unsigned int t10;
    unsigned int t11;
    unsigned char t12;
    char *t13;
    char *t14;
    char *t15;
    char *t16;
    char *t17;
    char *t19;
    int64 t20;

LAB0:    t1 = (t0 + 3784U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    xsi_set_current_line(65, ng0);
    t2 = (t0 + 7176);
    *((int *)t2) = 0;
    t3 = (t0 + 7180);
    *((int *)t3) = 50;
    t4 = 0;
    t5 = 50;

LAB4:    if (t4 <= t5)
        goto LAB5;

LAB7:    xsi_set_current_line(79, ng0);

LAB33:    *((char **)t1) = &&LAB34;

LAB1:    return;
LAB5:    xsi_set_current_line(66, ng0);
    t6 = (t0 + 2312U);
    t7 = *((char **)t6);
    t8 = (0 - 5);
    t9 = (t8 * -1);
    t10 = (1U * t9);
    t11 = (0 + t10);
    t6 = (t7 + t11);
    t12 = *((unsigned char *)t6);
    t13 = (t0 + 4168);
    t14 = (t13 + 56U);
    t15 = *((char **)t14);
    t16 = (t15 + 56U);
    t17 = *((char **)t16);
    *((unsigned char *)t17) = t12;
    xsi_driver_first_trans_fast(t13);
    xsi_set_current_line(67, ng0);
    t2 = (t0 + 2312U);
    t3 = *((char **)t2);
    t2 = (t0 + 7136U);
    t6 = ieee_p_1242562249_sub_1006216973935652998_1035706684(IEEE_P_1242562249, t18, t3, t2, 1);
    t7 = (t0 + 4232);
    t13 = (t7 + 56U);
    t14 = *((char **)t13);
    t15 = (t14 + 56U);
    t16 = *((char **)t15);
    memcpy(t16, t6, 6U);
    xsi_driver_first_trans_fast(t7);
    xsi_set_current_line(69, ng0);
    t2 = (t0 + 2312U);
    t3 = *((char **)t2);
    t2 = (t0 + 7184);
    t12 = 1;
    if (6U == 6U)
        goto LAB11;

LAB12:    t12 = 0;

LAB13:    if (t12 != 0)
        goto LAB8;

LAB10:
LAB9:    xsi_set_current_line(73, ng0);
    t2 = (t0 + 2312U);
    t3 = *((char **)t2);
    t2 = (t0 + 7190);
    t12 = 1;
    if (6U == 6U)
        goto LAB20;

LAB21:    t12 = 0;

LAB22:    if (t12 != 0)
        goto LAB17;

LAB19:
LAB18:    xsi_set_current_line(77, ng0);
    t20 = (50 * 1000LL);
    t2 = (t0 + 3592);
    xsi_process_wait(t2, t20);

LAB28:    *((char **)t1) = &&LAB29;
    goto LAB1;

LAB6:    t2 = (t0 + 7176);
    t4 = *((int *)t2);
    t3 = (t0 + 7180);
    t5 = *((int *)t3);
    if (t4 == t5)
        goto LAB7;

LAB30:    t8 = (t4 + 1);
    t4 = t8;
    t6 = (t0 + 7176);
    *((int *)t6) = t4;
    goto LAB4;

LAB8:    xsi_set_current_line(70, ng0);
    t14 = (t0 + 4296);
    t15 = (t14 + 56U);
    t16 = *((char **)t15);
    t17 = (t16 + 56U);
    t19 = *((char **)t17);
    *((unsigned char *)t19) = (unsigned char)3;
    xsi_driver_first_trans_fast(t14);
    goto LAB9;

LAB11:    t9 = 0;

LAB14:    if (t9 < 6U)
        goto LAB15;
    else
        goto LAB13;

LAB15:    t7 = (t3 + t9);
    t13 = (t2 + t9);
    if (*((unsigned char *)t7) != *((unsigned char *)t13))
        goto LAB12;

LAB16:    t9 = (t9 + 1);
    goto LAB14;

LAB17:    xsi_set_current_line(74, ng0);
    t14 = (t0 + 4360);
    t15 = (t14 + 56U);
    t16 = *((char **)t15);
    t17 = (t16 + 56U);
    t19 = *((char **)t17);
    *((unsigned char *)t19) = (unsigned char)2;
    xsi_driver_first_trans_fast(t14);
    goto LAB18;

LAB20:    t9 = 0;

LAB23:    if (t9 < 6U)
        goto LAB24;
    else
        goto LAB22;

LAB24:    t7 = (t3 + t9);
    t13 = (t2 + t9);
    if (*((unsigned char *)t7) != *((unsigned char *)t13))
        goto LAB21;

LAB25:    t9 = (t9 + 1);
    goto LAB23;

LAB26:    goto LAB6;

LAB27:    goto LAB26;

LAB29:    goto LAB27;

LAB31:    goto LAB2;

LAB32:    goto LAB31;

LAB34:    goto LAB32;

}


extern void work_a_1948444098_3212880686_init()
{
	static char *pe[] = {(void *)work_a_1948444098_3212880686_p_0};
	xsi_register_didat("work_a_1948444098_3212880686", "isim/wave_isim_beh.exe.sim/work/a_1948444098_3212880686.didat");
	xsi_register_executes(pe);
}
