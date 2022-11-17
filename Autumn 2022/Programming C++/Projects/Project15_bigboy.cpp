/*
  File: grades.cpp
  Created by: Gage Farmer
  Creation Date: 11/17/2022
  Synopsis: Takes grades from two years and displays average and std dev of the sets
*/

#include <iostream>
#include <cmath>
#include <iomanip>

using namespace std;

int MAX_GRADES = 15;

// FUNCTION PROTOTYPES GO HERE:
int getGrades(int gradeList[], int year);
void printHeader();
void printStats(const int year, const int gradeList[], const int numGrades, double avg, double stdDev);
void printGrades(const int gradeList[], const int numGrades);
void printOutliers(const int gradeList[], const int numGrades, double avg, double stdDev, int numOutliers);
void computeStats(const int year, const int gradeList[], const int numGrades, double& avg, int& min, int& max, double& stdDev, int& numOutliers);
void average(const int gradeList[], const int numGrades, double& avg);
void minimum(const int gradeList[], const int numGrades, int& min);
void maximum(const int gradeList[], const int numGrades, int& max);
double stdDeviation(const int gradeList[], const int numGrades, double avg, int& numOutliers);
void printMinMax(int max, int min1, int min2, bool in1, bool in2);
void findMax(const int gradeList[], const int numGrades, const int max, bool& hasMax);



int main() {
    // init vars
	int gradeList1[MAX_GRADES];             // grade array of each year
	int gradeList2[MAX_GRADES];
	int numGrades1(-1), numGrades2(-1);     // number of grades in the lists
	double avg1(-1.0), avg2(-1.0);			// averages
	int max(-1), min1(-1), min2(-1);  		// mins and max
	int numOutliers1(-1), numOutliers2(-1); // number of outliers and standard deviation
	double stdDev1(-1.0), stdDev2(-1.0);
	bool hasMax1 = false, hasMax2 = false;
	
	// get grades
	numGrades1 = getGrades(gradeList1, 1);
	numGrades2 = getGrades(gradeList2, 2);
	
	// calculate stats
	computeStats(1, gradeList1, numGrades1, avg1, min1, max, stdDev1, numOutliers1);
	computeStats(2, gradeList2, numGrades2, avg2, min2, max, stdDev2, numOutliers2);
	
	// empty line
	cout << endl;
	
	printHeader();
	printStats(1, gradeList1, numGrades1, avg1, stdDev1);
	printOutliers(gradeList1, numGrades1, avg1, stdDev1, numOutliers1);
	printStats(2, gradeList2, numGrades2, avg2, stdDev2);
	printOutliers(gradeList2, numGrades2, avg2, stdDev2, numOutliers2);
	
	findMax(gradeList1, numGrades1, max, hasMax1);
	findMax(gradeList2, numGrades2, max, hasMax2);
	printMinMax(max, min1, min2, hasMax1, hasMax2);
	
	return 0;
}

// FUNCTION DEFINITIONS GO HERE:
int getGrades(int gradeList[], int year) {
	
   int numGrades;
   
   cout << "Enter # of grades during year " << year << ": ";
   cin >> numGrades;
   
   while (numGrades < 1 || numGrades > MAX_GRADES) {
	   cout << "Enter at least one but no more than " << MAX_GRADES << " grades. Try again." << endl;
	   cout << "Enter # of grades during year " << year << ": ";
	   cin >> numGrades;
   }
   
   cout << "Enter the " << numGrades << " grade(s): ";
   for (int i(0); i < numGrades; i++) {
      cin >> gradeList[i];
   }
   
   return numGrades;
   
}


void printHeader() {
	
   cout << setw(4) << "Year" << setw(7) << "Avg" << setw(8) << "Stddev" << setw(9) << "Grades" << endl;
   cout << "----------------------------" << endl;
   
}


// print stats of a given year
void printStats(const int year, const int gradeList[], const int numGrades, double avg, double stdDev) {
   
   cout << setw(3) << year << setw(8) << fixed << setprecision(1) << avg << setw(8) << setprecision(2) << stdDev << "   ";
   printGrades(gradeList, numGrades);
   
}


// prints grades
void printGrades(const int gradeList[], const int numGrades) {
   
   cout << "{ " << gradeList[0];
   
   for (int i(1); i < numGrades; i++) {
	   cout << ", " << gradeList[i];
   }
   
   cout << " }" << endl;
   
}


// calculates and prints outliers
void printOutliers(const int gradeList[], const int numGrades, double avg, double stdDev, int numOutliers) {
   
    bool first = true;
    int hiLim = avg + stdDev;
    int lowLim = avg - stdDev;
   
    for (int i(0); i < numGrades; i++) {
	    if (gradeList[i] > hiLim || gradeList[i] < lowLim) {
		    if (first) { 
		        cout << "Outliers: < ";
		        cout << gradeList[i]; 
		        first = false;
		    }
		    else { cout << ", " << gradeList[i]; }
		}
    }
    
    if (first) {
        cout << "No outliers" << endl;
    }
	else {
	    cout << " >" << endl;
	}
   
}


// calls average, min, max, and standard deviaton functions
void computeStats(const int year, const int gradeList[], const int numGrades, double& avg, int& min, int& max, double& stdDev, int& numOutliers) {
   
   average(gradeList, numGrades, avg);
   minimum(gradeList, numGrades, min);
   maximum(gradeList, numGrades, max);
   stdDev = stdDeviation(gradeList, numGrades, avg, numOutliers);
   
}


// computes average
void average(const int gradeList[], const int numGrades, double& avg) {
   
   int total(0);
   for (int i(0); i < numGrades; i++) {
	   total += gradeList[i];
   }
   
   avg = total / double(numGrades);
   
}


// computes minimum
void minimum(const int gradeList[], const int numGrades, int& min) {
	
	min = gradeList[0];
	
	for (int i(0); i < numGrades; i++) {
		if (gradeList[i] < min) {
		min = gradeList[i];
		}
	}
	
}


// computes maximum
void maximum(const int gradeList[], const int numGrades, int& max) {
	
	for (int i(0); i < numGrades; i++) {
		if (gradeList[i] > max) {
		max = gradeList[i];
		}
	}
	
}


// computes standard deviation
double stdDeviation(const int gradeList[], const int numGrades, double avg, int& numOutliers) {
	
	double variance;
   
	for (int i(0); i < numGrades; i++) {
	   variance += pow(gradeList[i] - avg, 2);
	}
	
	return sqrt(variance / numGrades);
	
}


// prints minimum and maximum vals
void printMinMax(int max, int min1, int min2, bool in1, bool in2) {
   
   cout << endl;
   
   // max
   if (in1) {
       if (in2) {
           cout << "Both years had the highest grade of " << max << "." << endl << endl;
       }
       else { 
           cout << "The first year had the highest grade of " << max << "." << endl << endl;
       }
   }
   else { cout << "The second year had the highest grade of " << max << "." << endl << endl;
   }
   
   
   // min
   cout << "The first year's lowest grade is " << min1 << "." << endl;
   cout << "The second year's lowest grade is " << min2 << "." << endl;
   
}


// finds if max is in year 1, 2, or both
void findMax(const int gradeList[], const int numGrades, const int max, bool& hasMax) {
    
    for (int i(0); i < numGrades; i++) {
        if (gradeList[i] == max) {
            hasMax = true;
        }
    }
    
}
