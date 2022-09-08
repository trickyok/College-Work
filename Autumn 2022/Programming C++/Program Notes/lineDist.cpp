#include <iostream>
#include <cmath>
using namespace std;

int main() {

	double x, y;
	
	cout << "Enter x and y: ";
	cin >> x >> y;
	
	cout << "The length of the hypotenuse is " << sqrt(pow(x, 2) + pow(y, 2)) << endl;

	return 0;
}