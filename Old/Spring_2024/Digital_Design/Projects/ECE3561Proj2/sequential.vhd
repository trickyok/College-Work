----------------------------------------------------------------------------------
-- Company: Ohio State University
-- Engineer: Gage Farmer
-- 
-- Create Date:    16:08:11 03/06/2024 
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

ENTITY sequential IS
PORT(	Q0		:	OUT	STD_LOGIC;
		Q1		:	OUT	STD_LOGIC;
		RCO	:	OUT	STD_LOGIC;
		CLK	:	IN		STD_LOGIC;
		INPUT	:	IN		STD_LOGIC;
		CLR	:	IN		STD_LOGIC);
END sequential;

ARCHITECTURE behavioral OF sequential IS

		SIGNAL	CE1	:	STD_LOGIC:= '1';
		SIGNAL	CE0	:	STD_LOGIC;
		SIGNAL	IQ0	:	STD_LOGIC:='0';
		SIGNAL	IQ1	:	STD_LOGIC:='0';

BEGIN
	process (IQ0,IQ1,INPUT)   -- output 1) the 3-8 decoder 2) Q0 3) Q1
		begin
			if IQ0='1' and IQ1='1' and INPUT='1' then
				RCO <= '1';
			elsif	IQ0='0' and IQ1='0' and INPUT='0' then
				RCO <= '1';
			else
				RCO <= '0';
			end if;
			Q0 <= IQ0;
			Q1 <= IQ1;
	end process;

	process (CLK, CLR) -- The first T flip-flop
		begin
			if (CLK'event and CLK='1') then
				if CLR = '1' then
					IQ1 <= '0';
				elsif CE1 = '1' then
					IQ1 <= not(IQ1);
				end if;
			end if;
	end process;

	process (CLK, CLR) -- The second T flip-flop
		begin
			if INPUT='1' and IQ1='1' then
				CE0<='1';
			elsif INPUT='0' and IQ1='0' then
				CE0<='1';
			else
				CE0<='0';
			end if;

			if CLK'event and CLK='1' then
				if CLR='1' then
					IQ0<='0';
				elsif CE0='1' then
					IQ0<=not(IQ0);
				end if;
			end if;
	end process;

END;