--------------------------------------------------------------------------------
-- Copyright (c) 1995-2013 Xilinx, Inc.  All rights reserved.
--------------------------------------------------------------------------------
--   ____  ____ 
--  /   /\/   / 
-- /___/  \  /    Vendor: Xilinx 
-- \   \   \/     Version : 14.7
--  \   \         Application : sch2hdl
--  /   /         Filename : top.vhf
-- /___/   /\     Timestamp : 02/23/2024 19:41:42
-- \   \  /  \ 
--  \___\/\___\ 
--
--Command: sch2hdl -intstyle ise -family xc9500 -flat -suppress -vhdl /home/gage/Documents/College-Work/ASpring_2024/Digital_Design/Projects/ECE3561Proj1/top.vhf -w /home/gage/Documents/College-Work/ASpring_2024/Digital_Design/Projects/ECE3561Proj1/top.sch
--Design Name: top
--Device: xc9500
--Purpose:
--    This vhdl netlist is translated from an ECS schematic. It can be 
--    synthesized and simulated, but it should not be modified. 
--

library ieee;
use ieee.std_logic_1164.ALL;
use ieee.numeric_std.ALL;
library UNISIM;
use UNISIM.Vcomponents.ALL;

entity D3_8E_MXILINX_top is
   port ( A0 : in    std_logic; 
          A1 : in    std_logic; 
          A2 : in    std_logic; 
          E  : in    std_logic; 
          D0 : out   std_logic; 
          D1 : out   std_logic; 
          D2 : out   std_logic; 
          D3 : out   std_logic; 
          D4 : out   std_logic; 
          D5 : out   std_logic; 
          D6 : out   std_logic; 
          D7 : out   std_logic);
end D3_8E_MXILINX_top;

architecture BEHAVIORAL of D3_8E_MXILINX_top is
   attribute BOX_TYPE   : string ;
   component AND4
      port ( I0 : in    std_logic; 
             I1 : in    std_logic; 
             I2 : in    std_logic; 
             I3 : in    std_logic; 
             O  : out   std_logic);
   end component;
   attribute BOX_TYPE of AND4 : component is "BLACK_BOX";
   
   component AND4B1
      port ( I0 : in    std_logic; 
             I1 : in    std_logic; 
             I2 : in    std_logic; 
             I3 : in    std_logic; 
             O  : out   std_logic);
   end component;
   attribute BOX_TYPE of AND4B1 : component is "BLACK_BOX";
   
   component AND4B2
      port ( I0 : in    std_logic; 
             I1 : in    std_logic; 
             I2 : in    std_logic; 
             I3 : in    std_logic; 
             O  : out   std_logic);
   end component;
   attribute BOX_TYPE of AND4B2 : component is "BLACK_BOX";
   
   component AND4B3
      port ( I0 : in    std_logic; 
             I1 : in    std_logic; 
             I2 : in    std_logic; 
             I3 : in    std_logic; 
             O  : out   std_logic);
   end component;
   attribute BOX_TYPE of AND4B3 : component is "BLACK_BOX";
   
begin
   I_36_30 : AND4
      port map (I0=>A2,
                I1=>A1,
                I2=>A0,
                I3=>E,
                O=>D7);
   
   I_36_31 : AND4B1
      port map (I0=>A0,
                I1=>A2,
                I2=>A1,
                I3=>E,
                O=>D6);
   
   I_36_32 : AND4B1
      port map (I0=>A1,
                I1=>A2,
                I2=>A0,
                I3=>E,
                O=>D5);
   
   I_36_33 : AND4B2
      port map (I0=>A1,
                I1=>A0,
                I2=>A2,
                I3=>E,
                O=>D4);
   
   I_36_34 : AND4B1
      port map (I0=>A2,
                I1=>A0,
                I2=>A1,
                I3=>E,
                O=>D3);
   
   I_36_35 : AND4B2
      port map (I0=>A2,
                I1=>A0,
                I2=>A1,
                I3=>E,
                O=>D2);
   
   I_36_36 : AND4B2
      port map (I0=>A2,
                I1=>A1,
                I2=>A0,
                I3=>E,
                O=>D1);
   
   I_36_37 : AND4B3
      port map (I0=>A2,
                I1=>A1,
                I2=>A0,
                I3=>E,
                O=>D0);
   
end BEHAVIORAL;



library ieee;
use ieee.std_logic_1164.ALL;
use ieee.numeric_std.ALL;
library UNISIM;
use UNISIM.Vcomponents.ALL;

entity FD_MXILINX_top is
   generic( INIT : bit :=  '0');
   port ( C : in    std_logic; 
          D : in    std_logic; 
          Q : out   std_logic);
end FD_MXILINX_top;

architecture BEHAVIORAL of FD_MXILINX_top is
   attribute BOX_TYPE   : string ;
   signal XLXN_4 : std_logic;
   component GND
      port ( G : out   std_logic);
   end component;
   attribute BOX_TYPE of GND : component is "BLACK_BOX";
   
   component FDCP
      generic( INIT : bit :=  '0');
      port ( C   : in    std_logic; 
             CLR : in    std_logic; 
             D   : in    std_logic; 
             PRE : in    std_logic; 
             Q   : out   std_logic);
   end component;
   attribute BOX_TYPE of FDCP : component is "BLACK_BOX";
   
begin
   I_36_43 : GND
      port map (G=>XLXN_4);
   
   U0 : FDCP
   generic map( INIT => INIT)
      port map (C=>C,
                CLR=>XLXN_4,
                D=>D,
                PRE=>XLXN_4,
                Q=>Q);
   
end BEHAVIORAL;



library ieee;
use ieee.std_logic_1164.ALL;
use ieee.numeric_std.ALL;
library UNISIM;
use UNISIM.Vcomponents.ALL;

entity FDRE_MXILINX_top is
   generic( INIT : bit :=  '0');
   port ( C  : in    std_logic; 
          CE : in    std_logic; 
          D  : in    std_logic; 
          R  : in    std_logic; 
          Q  : out   std_logic);
end FDRE_MXILINX_top;

architecture BEHAVIORAL of FDRE_MXILINX_top is
   attribute BOX_TYPE   : string ;
   attribute HU_SET     : string ;
   attribute RLOC       : string ;
   signal A0      : std_logic;
   signal A1      : std_logic;
   signal QD      : std_logic;
   signal Q_DUMMY : std_logic;
   component AND3B1
      port ( I0 : in    std_logic; 
             I1 : in    std_logic; 
             I2 : in    std_logic; 
             O  : out   std_logic);
   end component;
   attribute BOX_TYPE of AND3B1 : component is "BLACK_BOX";
   
   component AND3B2
      port ( I0 : in    std_logic; 
             I1 : in    std_logic; 
             I2 : in    std_logic; 
             O  : out   std_logic);
   end component;
   attribute BOX_TYPE of AND3B2 : component is "BLACK_BOX";
   
   component OR2
      port ( I0 : in    std_logic; 
             I1 : in    std_logic; 
             O  : out   std_logic);
   end component;
   attribute BOX_TYPE of OR2 : component is "BLACK_BOX";
   
   component FD_MXILINX_top
      generic( INIT : bit :=  '0');
      port ( C : in    std_logic; 
             D : in    std_logic; 
             Q : out   std_logic);
   end component;
   
   attribute HU_SET of I_36_42 : label is "I_36_42_0";
   attribute RLOC of I_36_42 : label is "R0C0";
begin
   Q <= Q_DUMMY;
   I_36_32 : AND3B1
      port map (I0=>R,
                I1=>D,
                I2=>CE,
                O=>A1);
   
   I_36_33 : AND3B2
      port map (I0=>CE,
                I1=>R,
                I2=>Q_DUMMY,
                O=>A0);
   
   I_36_34 : OR2
      port map (I0=>A1,
                I1=>A0,
                O=>QD);
   
   I_36_42 : FD_MXILINX_top
   generic map( INIT => INIT)
      port map (C=>C,
                D=>QD,
                Q=>Q_DUMMY);
   
end BEHAVIORAL;



library ieee;
use ieee.std_logic_1164.ALL;
use ieee.numeric_std.ALL;
library UNISIM;
use UNISIM.Vcomponents.ALL;

entity FJKRSE_MXILINX_top is
   generic( INIT : bit :=  '0');
   port ( C  : in    std_logic; 
          CE : in    std_logic; 
          J  : in    std_logic; 
          K  : in    std_logic; 
          R  : in    std_logic; 
          S  : in    std_logic; 
          Q  : out   std_logic);
end FJKRSE_MXILINX_top;

architecture BEHAVIORAL of FJKRSE_MXILINX_top is
   attribute HU_SET         : string ;
   attribute BOX_TYPE       : string ;
   signal AD_S    : std_logic;
   signal A0      : std_logic;
   signal A1      : std_logic;
   signal A2      : std_logic;
   signal S_CE    : std_logic;
   signal Q_DUMMY : std_logic;
   component FDRE_MXILINX_top
      generic( INIT : bit :=  '0');
      port ( C  : in    std_logic; 
             CE : in    std_logic; 
             D  : in    std_logic; 
             R  : in    std_logic; 
             Q  : out   std_logic);
   end component;
   
   component AND3B2
      port ( I0 : in    std_logic; 
             I1 : in    std_logic; 
             I2 : in    std_logic; 
             O  : out   std_logic);
   end component;
   attribute BOX_TYPE of AND3B2 : component is "BLACK_BOX";
   
   component AND3B1
      port ( I0 : in    std_logic; 
             I1 : in    std_logic; 
             I2 : in    std_logic; 
             O  : out   std_logic);
   end component;
   attribute BOX_TYPE of AND3B1 : component is "BLACK_BOX";
   
   component AND2B1
      port ( I0 : in    std_logic; 
             I1 : in    std_logic; 
             O  : out   std_logic);
   end component;
   attribute BOX_TYPE of AND2B1 : component is "BLACK_BOX";
   
   component OR4
      port ( I0 : in    std_logic; 
             I1 : in    std_logic; 
             I2 : in    std_logic; 
             I3 : in    std_logic; 
             O  : out   std_logic);
   end component;
   attribute BOX_TYPE of OR4 : component is "BLACK_BOX";
   
   component OR2
      port ( I0 : in    std_logic; 
             I1 : in    std_logic; 
             O  : out   std_logic);
   end component;
   attribute BOX_TYPE of OR2 : component is "BLACK_BOX";
   
   attribute HU_SET of I_36_32 : label is "I_36_32_1";
begin
   Q <= Q_DUMMY;
   I_36_32 : FDRE_MXILINX_top
   generic map( INIT => INIT)
      port map (C=>C,
                CE=>S_CE,
                D=>AD_S,
                R=>R,
                Q=>Q_DUMMY);
   
   I_36_37 : AND3B2
      port map (I0=>J,
                I1=>K,
                I2=>Q_DUMMY,
                O=>A0);
   
   I_36_40 : AND3B1
      port map (I0=>Q_DUMMY,
                I1=>K,
                I2=>J,
                O=>A1);
   
   I_36_43 : AND2B1
      port map (I0=>K,
                I1=>J,
                O=>A2);
   
   I_36_46 : OR4
      port map (I0=>S,
                I1=>A2,
                I2=>A1,
                I3=>A0,
                O=>AD_S);
   
   I_36_55 : OR2
      port map (I0=>CE,
                I1=>S,
                O=>S_CE);
   
end BEHAVIORAL;



library ieee;
use ieee.std_logic_1164.ALL;
use ieee.numeric_std.ALL;
library UNISIM;
use UNISIM.Vcomponents.ALL;

entity top is
   port ( CLK   : in    std_logic; 
          INPUT : in    std_logic; 
          PRE   : in    std_logic; 
          Q0    : out   std_logic; 
          Q1    : out   std_logic; 
          RCO   : out   std_logic);
end top;

architecture BEHAVIORAL of top is
   attribute BOX_TYPE   : string ;
   attribute SLEW       : string ;
   attribute HU_SET     : string ;
   signal XLXN_24 : std_logic;
   signal XLXN_31 : std_logic;
   signal XLXN_32 : std_logic;
   signal XLXN_33 : std_logic;
   signal XLXN_34 : std_logic;
   signal XLXN_35 : std_logic;
   signal XLXN_36 : std_logic;
   signal XLXN_39 : std_logic;
   signal XLXN_41 : std_logic;
   signal XLXN_42 : std_logic;
   signal XLXN_43 : std_logic;
   signal XLXN_44 : std_logic;
   signal XLXN_61 : std_logic;
   signal XLXN_62 : std_logic;
   signal XLXN_63 : std_logic;
   signal XLXN_67 : std_logic;
   signal XLXN_68 : std_logic;
   component IBUF
      port ( I : in    std_logic; 
             O : out   std_logic);
   end component;
   attribute BOX_TYPE of IBUF : component is "BLACK_BOX";
   
   component OBUF
      port ( I : in    std_logic; 
             O : out   std_logic);
   end component;
   attribute SLEW of OBUF : component is "SLOW";
   attribute BOX_TYPE of OBUF : component is "BLACK_BOX";
   
   component AND2
      port ( I0 : in    std_logic; 
             I1 : in    std_logic; 
             O  : out   std_logic);
   end component;
   attribute BOX_TYPE of AND2 : component is "BLACK_BOX";
   
   component INV
      port ( I : in    std_logic; 
             O : out   std_logic);
   end component;
   attribute BOX_TYPE of INV : component is "BLACK_BOX";
   
   component OR2
      port ( I0 : in    std_logic; 
             I1 : in    std_logic; 
             O  : out   std_logic);
   end component;
   attribute BOX_TYPE of OR2 : component is "BLACK_BOX";
   
   component FJKRSE_MXILINX_top
      generic( INIT : bit :=  '0');
      port ( C  : in    std_logic; 
             CE : in    std_logic; 
             J  : in    std_logic; 
             K  : in    std_logic; 
             R  : in    std_logic; 
             S  : in    std_logic; 
             Q  : out   std_logic);
   end component;
   
   component D3_8E_MXILINX_top
      port ( A0 : in    std_logic; 
             A1 : in    std_logic; 
             A2 : in    std_logic; 
             E  : in    std_logic; 
             D0 : out   std_logic; 
             D1 : out   std_logic; 
             D2 : out   std_logic; 
             D3 : out   std_logic; 
             D4 : out   std_logic; 
             D5 : out   std_logic; 
             D6 : out   std_logic; 
             D7 : out   std_logic);
   end component;
   
   component GND
      port ( G : out   std_logic);
   end component;
   attribute BOX_TYPE of GND : component is "BLACK_BOX";
   
   component VCC
      port ( P : out   std_logic);
   end component;
   attribute BOX_TYPE of VCC : component is "BLACK_BOX";
   
   attribute HU_SET of XLXI_19 : label is "XLXI_19_2";
   attribute HU_SET of XLXI_20 : label is "XLXI_20_3";
   attribute HU_SET of XLXI_21 : label is "XLXI_21_4";
begin
   XLXI_1 : IBUF
      port map (I=>INPUT,
                O=>XLXN_44);
   
   XLXI_2 : IBUF
      port map (I=>PRE,
                O=>XLXN_34);
   
   XLXI_3 : IBUF
      port map (I=>CLK,
                O=>XLXN_31);
   
   XLXI_4 : OBUF
      port map (I=>XLXN_39,
                O=>Q0);
   
   XLXI_5 : OBUF
      port map (I=>XLXN_44,
                O=>Q1);
   
   XLXI_6 : OBUF
      port map (I=>XLXN_43,
                O=>RCO);
   
   XLXI_14 : AND2
      port map (I0=>XLXN_32,
                I1=>XLXN_44,
                O=>XLXN_35);
   
   XLXI_15 : AND2
      port map (I0=>XLXN_33,
                I1=>XLXN_24,
                O=>XLXN_34);
   
   XLXI_16 : INV
      port map (I=>XLXN_44,
                O=>XLXN_24);
   
   XLXI_17 : INV
      port map (I=>XLXN_32,
                O=>XLXN_33);
   
   XLXI_18 : OR2
      port map (I0=>XLXN_34,
                I1=>XLXN_35,
                O=>XLXN_36);
   
   XLXI_19 : FJKRSE_MXILINX_top
      port map (C=>XLXN_31,
                CE=>XLXN_63,
                J=>XLXN_44,
                K=>XLXN_63,
                R=>XLXN_62,
                S=>XLXN_34,
                Q=>XLXN_32);
   
   XLXI_20 : FJKRSE_MXILINX_top
      port map (C=>XLXN_31,
                CE=>XLXN_67,
                J=>XLXN_36,
                K=>XLXN_36,
                R=>XLXN_61,
                S=>XLXN_34,
                Q=>XLXN_39);
   
   XLXI_21 : D3_8E_MXILINX_top
      port map (A0=>XLXN_32,
                A1=>XLXN_39,
                A2=>XLXN_44,
                E=>XLXN_68,
                D0=>XLXN_41,
                D1=>open,
                D2=>open,
                D3=>open,
                D4=>open,
                D5=>open,
                D6=>open,
                D7=>XLXN_42);
   
   XLXI_22 : OR2
      port map (I0=>XLXN_42,
                I1=>XLXN_41,
                O=>XLXN_43);
   
   XLXI_23 : GND
      port map (G=>XLXN_62);
   
   XLXI_24 : GND
      port map (G=>XLXN_61);
   
   XLXI_25 : VCC
      port map (P=>XLXN_63);
   
   XLXI_26 : VCC
      port map (P=>XLXN_68);
   
   XLXI_27 : VCC
      port map (P=>XLXN_67);
   
end BEHAVIORAL;


