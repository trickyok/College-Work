/*
  File: query.cpp
  Created by: Gage Farmer
  Creation Date: 9/28/22
  Synopsis: Determines which entered shapes
  contain a specified point
*/

#include <iostream>
#include <cmath>
using namespace std;

int main() {
 
	double cx1, cy1, rad1;      // circle 1
	double cx2, cy2, rad2;      // circle 2
	double sqX, sqY, sqL, sqH;  // square
	double pX, pY;              // point
	bool containC1=false, containC2=false, containS=false;
  
	// Data gathering very cool
	cout << "Enter x and y coordinates of the 1st circle: ";
	cin >> cx1 >> cy1;
	cout << endl << "Enter radius of the 1st circle: ";
	cin >> rad1;
  
	cout << endl << "Enter x and y coordinates of the rectangle: ";
	cin >> sqX >> sqY;
	cout << endl << "Enter length and height coordinates of the rectangle: ";
	cin >> sqL >> sqH;
  
	cout << endl << "Enter x and y coordinates of the 2nd circle: ";
	cin >> cx2 >> cy2;
	cout << endl << "Enter radius of the 2nd circle: ";
	cin >> rad2;
  
	cout << endl << "Enter x and y coordinates of the query point: ";
	cin >> pX >> pY;

       
	// circle 1 -> cx1, cy1, rad1
	if (sqrt(pow(pX - cx1, 2) + pow(pY - cy1, 2)) <= rad1) { containC1 = true; }
   
	// circle 2 -> cx2, cy2, rad2
	if (sqrt(pow(pX - cx2, 2) + pow(pY - cy2, 2)) <= rad2) { containC2 = true; }
   
	// square -> sqX, sqY, sqL, sqH;
	if (pX <= sqX + sqL && pY <= sqY + sqH) { containS = true; }
	
	
	// balls and nuts lmao
	
	
	// A metric shit-ton of if statements
	if (containC1) {
		if (containC2) {
			if (containS) { 
				cout << endl << "All shapes contain point (" <<
				pX << ", " << pY << ")" << endl; }
			else { 
				cout << endl << "Both circles contain point (" <<
				pX << ", " << pY << ")" << endl; }
		}
		else if (containS) { 
			cout << endl << "1st circle and rectangle contain point (" <<
			pX << ", " << pY << ")" << endl; 
		}
		else { 
			cout << endl << "1st circle contains point (" <<
			pX << ", " << pY << ")" << endl;
		}
	}
		
	else if (containC2) {
		if (containS) { 
			cout << endl << "2nd circle and rectangle contain point (" <<
			pX << ", " << pY << ")" << endl;
		}
		else { 
			cout << endl << "2nd circle contains point (" <<
			pX << ", " << pY << ")" << endl;
		}
	}
	
	else if (containS) { 
		cout << endl << "Rectangle contains point (" << 
		pX << ", " << pY << ")" << endl; 
	}
	
	else { 
		cout << endl << "No shape contains point (" << 
		pX << ", " << pY << ")" << endl; 
	}
		
		
	return 0;
}
