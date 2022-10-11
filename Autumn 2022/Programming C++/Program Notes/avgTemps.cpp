/* AvgTemps.cpp
	Gage Farmer
	set 1: 45 65 72 83 97 84 75 69 50 49 53 15 46 64 73 81 98 83 76 68 51 47 54 14
	set 2: 45 65 72 83 92 84 75 69 50 49 53 15 47 66 76 84 93 85 78 69 51 47 54 12
*/
	
#include <iostream>
#include <cmath>

using namespace std;
	
int main() {
	
	double avg1, avg2, x, sum=0;
	
	cout << "year 1: ";
	for (int i(0); i<12; i++) {
		cin >> x;
		cout << " " << x;
		sum += x;
	}
	avg1 = sum / 12;
	sum = 0;
	
	cout << endl << "year 2: ";
	for (int i(0); i<12; i++) {
		cin >> x;
		cout << " " << x;
		sum += x;
	}
	cout << endl;
	avg2 = sum / 12;  
	
	cout << "Average for year 1: " << avg1 << endl;
	cout << "Average for year 2: " << avg2 << endl;
	cout << "Difference between averages: " << abs(avg1 - avg2) << endl;
	
	if (abs(avg1 - avg2) > 0.75) { cout << "The difference in averages is greater than 0.75" << endl; }
	
	return 0;
}
