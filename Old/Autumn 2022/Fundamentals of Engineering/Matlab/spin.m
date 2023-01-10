SensorExplore.m
servoPin = 'D3';
s = servo(a, servoPin);
pPin = 'D2';

while (true)
distance = readVoltage(a, pPin);
position = 5 / distance;
writePosition(s, position);
pause(0.1);
end