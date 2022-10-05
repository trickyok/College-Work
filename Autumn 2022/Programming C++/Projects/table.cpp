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
	cout << "Enter number of roots (positive integer): ";
	cin >> numRoots;
	
	while (numRoots <= 0) {
		cout << "Number of roots must be positive." << endl;
		cout << "Enter number of roots: ";
		cin >> numRoots;
	}
	
	cout << "Enter value increment (positive integer): ";
	cin >> incVal;
	
	while (incVal <= 0) {
		cout << "Value increment must be positive." << endl;
		cout << "Enter value increment: ";
		cin >> incVal;
	}
	
	
	// label output
	cout << "Value";
	for (int i=0; i < numRoots; i++) {
	   if (i+2<10) {
		   cout << fixed << setw(6) << "x^1/" << i + 2;
	   }
	   else {
	      cout << fixed << setw(5) << "x^1/" << i + 2;
	   }
	}
	cout << endl;
	
	
	// value output
	for (double i=incVal; i <= 100; i+=incVal) {
		int j = 1;
		cout << setw(5) << fixed << setprecision(0) << i;
		for (double p=2; p <= numRoots+1; p++) {
			cout << setw(7) << fixed << setprecision(2) << pow(i, 1.0/p);
		}
		cout << endl;
	}
	
	return 0;
}
