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
	int year1Grades[MAX_GRADES];                          // grade array of each year
	int year2Grades[MAX_GRADES];
	int numGrades1(-1), numGrades2(-1);                   // number of grades in the lists
	int avg(-1), min1(-1), max1(-1), min2(-1), max2(-1);  // average, minimum, and maximum grades
	int numOutliers(-1), stdDev(-1);                      // number of outliers and standard deviation
	
	// get grades
	numGrades1 = getGrades(year1Grades, 1);
	numGrades2 = getGrades(year2Grades, 2);
	
	// empty line
	cout << endl;
	
	printHeader();
	
	
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
void printStats(const int year, const int[] gradeList, const int numGrades, int min, int max) {
   int avg(-1);
   computeStats
   cout << setw(4) << year << setw(7) << avg
   
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
