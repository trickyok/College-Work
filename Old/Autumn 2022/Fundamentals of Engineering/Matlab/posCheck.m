servoPin = 'D3';
a = arduino("COM3");
s = servo(a, servoPin);

writePosition(s, 1);
writePosition(s, 0);
writePosition(s, .5);
