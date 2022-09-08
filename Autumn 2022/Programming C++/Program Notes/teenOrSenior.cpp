#include <iostream>
using namespace std;

int main() {
	
	int age;
	bool teenOrSenior;
	
	cout << "Input age: " << endl;
	cin >> age;
	
	if (age >= 13 && age <= 19 || age > 80) {
		teenOrSenior = true;
		if (age > 80) {
			cout << "Is a senior" << endl;
		}
		else {
			cout << "Is a teen" << endl;
		}
	}
	
	return 0;
}