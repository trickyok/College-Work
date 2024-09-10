----------------------------------------------------------------------------------
-- Company: Ohio State University
-- Engineer: Gage Farmer
-- 
-- Create Date:    09:09:08 03/08/2024 
-- Design Name: 	 Project 2
-- Module Name:    wave - Behavioral 
-- Project Name: 	 2
-- Target Devices: Xilinx for Windows on Linux (via Wine Compatability Shell)
-- Tool versions:  14.7
-- Description: Designed to be a simple sequential machine
--
-- Dependencies: ieee
--
-- Revision: 1
-- Revision 0.01 - File Created
-- Additional Comments: Hi Drew
--
----------------------------------------------------------------------------------
LIBRARY ieee;
USE ieee.std_logic_1164.ALL;
USE ieee.numeric_std.ALL;

ENTITY wave IS 
    -- there are no inputs and outputs
END wave;

ARCHITECTURE behavioral OF wave IS

	COMPONENT sequential
	PORT(	Q0	:	OUT	STD_LOGIC;
			RCO	:	OUT	STD_LOGIC;
			Q1	:	OUT	STD_LOGIC;
			CLK	:	IN	STD_LOGIC;
			INPUT	:	IN	STD_LOGIC;
			CLR	:	IN	STD_LOGIC
	);
	END COMPONENT;

	SIGNAL Q0	:	STD_LOGIC:='0';
	SIGNAL CLK	:	STD_LOGIC;
	SIGNAL INPUT	:	STD_LOGIC:='0';
	SIGNAL RCO	:	STD_LOGIC;
	SIGNAL Q1	:	STD_LOGIC:='0';
	SIGNAL CLR	:	STD_LOGIC:='1';
	SIGNAL CE1	:	STD_LOGIC:='1';
	SIGNAL CE0	:	STD_LOGIC;
	SIGNAL TEMPORAL	:	STD_LOGIC_VECTOR(5 downto 0):="000000";
	SIGNAL IQ0	:	STD_LOGIC:='0';
	SIGNAL IQ1	:	STD_LOGIC:='0';

BEGIN
	--Unit under test
	uut: sequential PORT MAP(
		INPUT => INPUT,
		CLR => CLR,
		CLK => CLK,
		Q0 => Q0,
		Q1 => Q1,
		RCO=> RCO
		);
-- *** Test Bench - User Defined Section ***
tb : PROCESS
BEGIN
	for i in 0 to 50 loop -- VHDL loop statement
		CLK <= TEMPORAL(0); --assigning the LSB of TEMPORAL to CLK
		TEMPORAL <= std_logic_vector(UNSIGNED(TEMPORAL) + 1);
			-- increment TEMPORAL
		if (TEMPORAL = "010111") then -- VHDL if statement
			INPUT <= '1';
			-- set INPUT=1 when TEMPORAL = "010110",
		end if;
		if (TEMPORAL = "000010") then -- VHDL if statement
			CLR <= '0';
			-- set CLR=0 after the first clock period
		end if;
		wait for 50 ns; -- CLK high/low for 50ns
		end loop;
	WAIT;
END PROCESS;
-- *** End Test Bench - User Defined Section ***

END;