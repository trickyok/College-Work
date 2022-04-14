#include <Servo.h>

Servo left;
Servo right;
const int sensIn=11;
const int sensOut=10;
long duration, inches;
int consec=0;

void setup() {
  // put your setup code here, to run once:
  left.attach(7);
  right.attach(8);
  left.write(90);
  right.write(90);
  Serial.begin(9600);
  
}

void loop() {
  // put your main code here, to run repeatedly:
  if detectHazard() {
    if consec >= 2 {
      backward();
      consec+=1;
    }
    else if consec > 0 {
      rightTurn();
      consec+=1;
    }
    else {
      leftTurn();
      consec+=1;
    }
  }
  else {
    forward();
    consec-=1;
  }
}

int forward() {
  // Robot go forward
  left.write(0);
  right.write(180);
  return 0;
}

int backward() {
  // Robot go backward
  left.write(180);
  right.write(0);
  return 0;
}

int leftTurn() {
  // Robot turn left 90 deg
  left.write(0);
  right.write(0);
  return 0;
}

int rightTurn() {
  // Robot turn left 90 deg
  left.write(180);
  right.write(180);
  return 0;
}

bool detectHazard() {
  // Returns true if there is a hazard
}

/* Game Plan
 *  
 *  1. Get wheels to operate together
 *    Forward
 *    Left Turn
 *    Right Turn
 *    Backward
 *    
 *  2. Get sensor to detect hazard
 *    Makes vehicle turn away from hazard
 *  
 *  3. RGB Led Config
 *    Green if moving
 *    Blue if stopped
 *    Red if hazard detected
 */
