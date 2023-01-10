#include <iostream>
using namespace std;

int main() {
	double min, max, i;
	
	cout << "Enter min then max: ";
	cin >> min >> max;
	
	if (min > max) {
		cout << "Error: Min greater than max.";
		return 0;
	}
	
	for (i = min; i <= max;) {
		
		cout << "fahrenheit = " << i << " ";
		cout << "celsius = " << (i - 32.0) * (5.0 / 9.0) << endl;
		
		i += 10.0;
	}
	
	return 0;
}