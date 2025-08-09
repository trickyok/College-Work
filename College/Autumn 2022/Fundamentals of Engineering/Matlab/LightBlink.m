LED = 'D44';
LDR = 'A0';
Threshold = 1;

while (true)
	pause(0.1);
	if (readVoltage(a, LDR) > Threshold)
		writeDigitalPin(a, LED, 1)
	elseif (readVoltage(a, LDR) < Threshold)
		writeDigitalPin(a, LED, 0)
	end
end