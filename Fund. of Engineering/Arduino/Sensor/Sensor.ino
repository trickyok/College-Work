const int sensIn= 11;
const int sensOut= 10;
long duration, inches;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:
  pinMode(sensIn, INPUT); // Set pin to INPUT
  pinMode(sensOut, OUTPUT); // Set pin to OUTPUT
  digitalWrite(sensOut, LOW); // Turn ping off
  delayMicroseconds(2);
  digitalWrite(sensOut, HIGH); // Sends out ultrasonic pulse
  delayMicroseconds(5); // 5 microsecond burst
  digitalWrite(sensOut, LOW); // End of burst, turn off ping
  duration = pulseIn(sensIn, HIGH); // Measure elapsed time
  inches = duration/74/2; // Convert time to distance in inches
  Serial.println(inches); // Print line to Monitor
  delay(200);
}
