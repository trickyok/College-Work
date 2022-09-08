#include <iostream>
using namespace std;


int main() {

	if (!(temp >= 10 && temp <= 32)) {
		cout << "woah!" << endl;
	}
	if (temp < 10 || temp > 32) {
		cout << "woah!, but different!" << endl;
	}
	
	return 0;
}