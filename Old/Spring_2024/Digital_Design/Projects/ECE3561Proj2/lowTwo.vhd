----------------------------------------------------------------------------------
-- Company: Ohio State University
-- Engineer: Gage Farmer
-- 
-- Create Date:    09:34:34 03/08/2024 
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
--(in a new file lowTwo.vhd)
library ieee;               -- added lowTwo entity/architecture
use ieee.std_logic_1164.all;

entity lowTwo is
	port (
		clk	:	in	std_logic;
      wavelowTwo	:	out std_logic
    );
end entity;

architecture foo of lowTwo is
    
begin
    wavelowTwo <= clk after 1us;
end architecture;