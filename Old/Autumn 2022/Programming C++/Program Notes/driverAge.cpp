#include <iostream>
using namespace std;

int main() {
	
	int age;
	cin >> age;
	
	if (age <= 14) { cout << "You are too young to drive" << endl; }
	else if (age == 15) { cout << "You can get a learner's permit" << endl; }
	else if (age <= 25) { cout << "You pay more for insurance" << endl; }
	else { cout << "You can drive" << endl; }
	
	return 0;
	
}