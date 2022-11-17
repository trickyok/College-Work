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
int getGrades(int[] gradeList, int year);
void printHeader();
void printStats(const int year, const int[] gradeList, const int numGrades, int min, int max);
void printGrades(const int[] gradeList, const int numGrades);
void printOutliers(const int[] gradeList, const int numGrades, int avg, int stdDev, int numOutliers);
void computeStats(const int year, const int[] gradeList, const int numGrades, int& avg, int& min, int& max);
void average(const int[] gradeList, const int numGrades, int& avg);
int stdDeviation(const int[] gradeList, const int numGrades, int avg, int& numOutliers);
void printMinMax(int min1, int max1, int min2, int max2);



int main() {
   // init vars
	int gradeList1[MAX_GRADES];             // grade array of each year
	int gradeList2[MAX_GRADES];
	int numGrades1(-1), numGrades2(-1);     // number of grades in the lists
	int avg1(-1), min1(-1), max1(-1), 		// average, minimum, and maximum grades
	int avg2(-1), min2(-1), max2(-1);  		
	int numOutliers1(-1), stdDev1(-1);        // number of outliers and standard deviation
	int numOutliers2(-1), stdDev2(-1);        
	
	// get grades
	numGrades1 = getGrades(gradeList1, 1);
	numGrades2 = getGrades(gradeList2, 2);
	
	// calculate stats
	computeStats(1, gradeList1, numGrades1, avg1, min1, max1, stdDev1, numOutliers1);
	computeStats(2, gradeList2, numGrades2, avg2, min2, max2, stdDev2, numOutliers2);
	
	// empty line
	cout << endl;
	
	printHeader();
	printStats(1, gradeList1, numGrades1, avg1, stdDev1);
	printStats(2, gradeList2, numGrades2, avg2, stdDev2);
	
	
	return 0;
}

// FUNCTION DEFINITIONS GO HERE:
int getGrades(int[] gradeList, int year) {
   int numGrades;
   
   cout << "Enter # of grades during year " << year << ": ";
   cin >> numGrades;
   
   cout << endl << "Enter the " << numGrades << " grade(s): ";
   for (int i(0), i < numGrades, i++) {
      cin >> gradeList[i];
   }
   
   return numGrades;
}


void printHeader() {
   cout << setw(4) << "Year" << setw(7) << "Avg" << setw(8) << "Stddev" << setw(9) << "Grades" << endl;
   cout << "----------------------------" << endl;
}


// print stats of a given year
void printStats(const int year, const int[] gradeList, const int numGrades, int avg, int stdDev) {
   
   cout << setw(4) << year << setw(7) << avg << 
   
}


void printGrades(const int[] gradeList, const int numGrades) {
   
   
}


void printOutliers(const int[] gradeList, const int numGrades, int avg, int stdDev, int numOutliers) {
   
   
}


// compute average, min, max, standard deviaton
void computeStats(const int year, const int[] gradeList, const int numGrades, int& avg, int& min, int& max, int& stdDev, int& numOutliers) {
   average(gradeList, numGrades, avg);
   minimum(gradeList, numGrades, min);
   maximum(gradeList, numGrades, max);
   stdDev = stdDeviation(gradeList, numGrades, avg, numOutliers);
}


void average(const int[] gradeList, const int numGrades, int& avg) {
   
   
}


int stdDeviation(const int[] gradeList, const int numGrades, int avg, int& numOutliers) {
   
   
}


void printMinMax(int min1, int max1, int min2, int max2) {
   
   
}
