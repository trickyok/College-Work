#include <iostream>
using namespace std;

int main() {

	double weight, height, bmi;
	
	cout << "Enter your height (in) and weight (lbs): ";
	cin >> height >> weight;
	
	bmi = weight * 705.0 / (height * height);
	cout << endl << "The BMI is " << bmi << endl;
	
	return 0;
}