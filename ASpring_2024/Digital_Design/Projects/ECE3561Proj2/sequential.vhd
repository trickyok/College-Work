----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    16:08:11 03/06/2024 
-- Design Name: 
-- Module Name:    sequential - Behavioral 
-- Project Name: 
-- Target Devices: 
-- Tool versions: 
-- Description: 
--
-- Dependencies: 
--
-- Revision: 
-- Revision 0.01 - File Created
-- Additional Comments: 
--
----------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity sequential is
    Port ( INPUT : in  STD_LOGIC;
           CLR : in  STD_LOGIC;
           CLK : in  STD_LOGIC;
           Q0 : out  STD_LOGIC;
           Q1 : out  STD_LOGIC;
           RCO : out  STD_LOGIC);
end sequential;

architecture Behavioral of sequential is

begin

process (CLK)
begin

   if CLK'event and CLK='1' then  
	
-- T Flip-Flop 0
      if CLR='1' then   
         Q0 <= '0';
      elsif INPUT ='1' then
         Q0 <= not(Q0);
      end if;
	
-- T Flip-Flop 1
      if <reset>='1' then   
         <output> <= '0';
      elsif <clock_enable> ='1' then
         <output> <= not(<output>);
      end if;
   end if;
	
	
	
	
end process;
 
	
end process;
 


end Behavioral;

