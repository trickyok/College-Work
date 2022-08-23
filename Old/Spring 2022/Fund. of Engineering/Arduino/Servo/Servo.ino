#include <Servo.h>

Servo wheeledServo;
int delayTime = 1000;

void setup() {
  // put your setup code here, to run once:
  wheeledServ.attach(2);

}

void loop() {
  // put your main code here, to run repeatedly:
  myServo.write(90);
  delay(delayTime);

  myServo.write(180);
  delay(delayTime);

  myServo.write(90);
  delay(delayTime);
  myServo.write(0);
  delay(delayTime);
}
