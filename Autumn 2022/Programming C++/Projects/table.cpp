/*
  File: table.cpp
  Created by: Gage Farmer
  Creation Date: 10/4/2022
  Synopsis: Outputs a table with a bunch
  of roots
*/

#include <iostream>
#include <cmath>
#include <iomanip>
using namespace std;

int main()
{
	int numRoots, incVal;
	
	
	// enter vars
	cout << "Enter number of roots (positive integer): " << endl;
	cin >> numRoots;
	
	while (numRoots <= 0) {
		cout << "Number of roots must be positive." << endl;
		cout << "Enter number of roots: " << endl;
		cin >> numRoots;
	}
	
	cout << "Enter value increment (positive integer): " << endl;
	cin >> incVal;
	
	while (incVal <= 0) {
		cout << "Value increment must be positive." << endl;
		cout << "Enter value increment: " << endl;
		cin >> incVal;
	}
	
	
	// label output
	cout << "Value";
	for (int i=0; i < numRoots; i++) {
		cout << setw(5) << "x^1/" << i + 2;
	}
	cout << endl;
	
	
	// value output
	int j=1;
	for (int i=incVal; i <= 100; i+=incVal) {
		for (int p=0; p < numRoots; p++) {
			cout << setw(5) << pow(i, 1/j);
		}
		cout << endl;
	}
	
	return 0;
}
