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

#include "xsi.h"

struct XSI_INFO xsi_info;

char *IEEE_P_2592010699;
char *STD_STANDARD;
char *IEEE_P_1242562249;
char *UNISIM_P_0947159679;
char *IEEE_P_2717149903;
char *STD_TEXTIO;


int main(int argc, char **argv)
{
    xsi_init_design(argc, argv);
    xsi_register_info(&xsi_info);

    xsi_register_min_prec_unit(-12);
    ieee_p_2592010699_init();
    ieee_p_1242562249_init();
    unisim_p_0947159679_init();
    std_textio_init();
    ieee_p_2717149903_init();
    unisim_a_1525108159_2393828108_init();
    unisim_a_2952178788_1492584465_init();
    unisim_a_2661327437_0605893366_init();
    unisim_a_3055263662_1392679692_init();
    unisim_a_3762448000_2971575191_init();
    unisim_a_2867636556_1359619727_init();
    unisim_a_2472646025_1397528790_init();
    unisim_a_1717296735_4086321779_init();
    unisim_a_3056901965_2640411640_init();
    work_a_1211938896_3212880686_init();
    work_a_1376644171_3212880686_init();
    unisim_a_1801614988_1818890047_init();
    unisim_a_2472025866_3046367013_init();
    work_a_2431652570_3212880686_init();
    unisim_a_3988446151_0546328132_init();
    unisim_a_2211953871_3811244703_init();
    unisim_a_3126493194_3781969094_init();
    unisim_a_2904659017_3769511665_init();
    work_a_3935199734_3212880686_init();
    unisim_a_2562466605_1496654361_init();
    work_a_1335952598_3212880686_init();
    work_a_4191933935_3212880686_init();


    xsi_register_tops("work_a_4191933935_3212880686");

    IEEE_P_2592010699 = xsi_get_engine_memory("ieee_p_2592010699");
    xsi_register_ieee_std_logic_1164(IEEE_P_2592010699);
    STD_STANDARD = xsi_get_engine_memory("std_standard");
    IEEE_P_1242562249 = xsi_get_engine_memory("ieee_p_1242562249");
    UNISIM_P_0947159679 = xsi_get_engine_memory("unisim_p_0947159679");
    IEEE_P_2717149903 = xsi_get_engine_memory("ieee_p_2717149903");
    STD_TEXTIO = xsi_get_engine_memory("std_textio");

    return xsi_run_simulation(argc, argv);

}
