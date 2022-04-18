#include <Servo.h>

Servo left;
Servo right;
#define echoPin 2
#define trigPin 3
long duration; // duration of sound wave travel
int distance; // distance measurement
int consec=0;

void setup() {
  // put your setup code here, to run once:
  left.attach(7);
  right.attach(8);
  left.write(90);
  right.write(90);
  flag.attach(2);
  flag.write(90);
  flag.write(0);
  Serial.begin(9600);
  pinMode(trigPin,OUTPUT);
  pinMode(echoPin,INPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  if (detectHazard()) {
    if (flag
    if (consec >= 2) {
      backward();
      consec+=1;
    }
    else if (consec > 0) {
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
  // Clears the trigPin condition
  digitalWrite(trigPin, LOW);
  delayMicroseconds(2);
  // Sets the trigPin HIGH (ACTIVE) for 10 microseconds
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);
  // Reads the echoPin, returns the sound wave travel time in microseconds
  duration = pulseIn(echoPin, HIGH);
  // Calculating the distance
  distance = duration * 0.034 / 2; // Speed of sound wave divided by 2 (go and back)
  // Displays the distance on the Serial Monitor
  Serial.print("Distance: ");
  Serial.print(distance);
  Serial.println(" cm");
  if (distance < 20) {
    return true;
  }
  return false;
}

class flag() {
  public:
  void up();
  void down();
  int pos();
  
  private:
  Servo flag;
};

void flag::up() {
  flag
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
 *    
 *    4. Flag
 *    Up if hazard detected
 *    Down otherwise
 */
