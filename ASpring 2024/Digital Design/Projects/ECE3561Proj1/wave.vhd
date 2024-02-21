-- Vhdl test bench created from schematic /home/gage/Documents/College-Work/ASpring 2024/Digital Design/Projects/ECE3561Proj1/top.sch - Wed Feb 21 16:30:21 2024
--
-- Notes: 
-- 1) This testbench template has been automatically generated using types
-- std_logic and std_logic_vector for the ports of the unit under test.
-- Xilinx recommends that these types always be used for the top-level
-- I/O of a design in order to guarantee that the testbench will bind
-- correctly to the timing (post-route) simulation model.
-- 2) To use this template as your testbench, change the filename to any
-- name of your choice with the extension .vhd, and use the "Source->Add"
-- menu in Project Navigator to import the testbench. Then
-- edit the user defined section below, adding code to generate the 
-- stimulus for your design.
--
LIBRARY ieee;
USE ieee.std_logic_1164.ALL;
USE ieee.numeric_std.ALL;
LIBRARY UNISIM;
USE UNISIM.Vcomponents.ALL;
ENTITY top_top_sch_tb IS
END top_top_sch_tb;
ARCHITECTURE behavioral OF top_top_sch_tb IS 

   COMPONENT top
   PORT( Q0		:	OUT	STD_LOGIC;
			CLK	:	IN		STD_LOGIC;
			INPUT	:	IN		STD_LOGIC;
			RCO	:	OUT	STD_LOGIC;
			Q1		:	OUT	STD_LOGIC;
			PRE	:	IN		STD_LOGIC);
   END COMPONENT;

	SIGNAL Q0		:	STD_LOGIC;
	SIGNAL CLK		:	STD_LOGIC;
	SIGNAL RCO		:	STD_LOGIC;
	SIGNAL Q1		:	STD_LOGIC;
	SIGNAL INPUT	:	STD_LOGIC:='0';
	SIGNAL PRE		:	STD_LOGIC:='0';
	SIGNAL TEMPORAL : STD_LOGIC_VECTOR(5 downto 0):= "000000";

BEGIN

   UUT: top PORT MAP(
		Q0 => Q0;
		CLK => CLK;
		INPUT => INPUT;
		RCO => RCO;
		Q1 => Q1;
		PRE => PRE;
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
				-- i.e., INPUT is set to one logic level at 1150ns
							end if;
							wait for 50 ns; -- CLK high/low for 50ns
				end loop;
				WAIT;
END PROCESS;
-- *** End Test Bench - User Defined Section ***

END;
