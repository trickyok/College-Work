#include <iostream>
#include <cmath>
using namespace std;

int main() {

	double x1, x2, y1, y2, xDiff, yDiff;
	
	cout << "Enter x and y coordinates of the first point: ";
	cin >> x1 >> y1;
	cout << "Enter x and y coordinates of the second point: ";
	cin >> x2 >> y2;
	
	xDiff = x1 - x2;
	yDiff = y1 - y2;
	slope = yDiff / xDiff;
	
	if (xDiff == 0.0) {
		cout << "The slope is infinite" << endl;
	}
	else if (x1 == x2 && y1 == y2) {
		cout << "Input Error: First point equals second point" << endl;
	}
	else {
		cout << "The length of the hypotenuse is " << sqrt(pow(x, 2) + pow(y, 2)) << endl;
	}
	
	return 0;
}