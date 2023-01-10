/*
  File: vectors.cpp
  Created by: Gage Farmer
  Creation Date: 11/4/2022
  Synopsis: Returns info about vectors
*/

#include <iostream>
#include <cmath>

using namespace std;

const double EPSILON(1e-11);

// function prototypes

void read_vector(const string str, double& x, double& y);

double vec_length(double x, double y);

double dot_product(double x1, double y1, double x2, double y2);

double compute_angle(double x1, double y1, double x2, double y2);

double radians_to_degrees(const double rad);

void normalization(double& x, double& y);

void output_vector(const string& msg, const double x, const double y, const double len);

void resultant_vector(double x1, double y1, double x2, double y2, double& xR, double& yR);

void display_info(double x1, double y1, double x2, double y2, double angle);

// *** DO NOT CHANGE ANY CODE IN THE MAIN FUNCTION.
int main()
{
  double u1, v1;	// coordinates of vector 1
  double u2, v2;	// coordinates of vector 2
  double radians; // angle in radians
  double degrees; // angle in degrees

  read_vector("Enter 1st vector (2 floats): ", u1, v1);
  read_vector("Enter 2nd vector (2 floats): ", u2, v2);
  
  // compute angle in radians between (u1, v1) and (u2, v2)
  radians = compute_angle(u1, v1, u2, v2);

  // convert radians to degrees
  degrees = radians_to_degrees(radians);

  // output information
  display_info(u1, v1, u2, v2, degrees);

  cout << endl;
  
  return(0);
}

void read_vector(const string str, double& x, double& y) {
	
	cout << str;
	cin >> x >> y;
	while (abs(x) <= EPSILON && abs(y) <= EPSILON) {
		cout << "Coordinates cannot both be zero." << endl;
		cout << str;
		cin >> x >> y;
	}
	
	return;
}


double vec_length(double x, double y) {
	
	return sqrt(pow(x, 2) + pow(y, 2));
}


double dot_product(double x1, double y1, double x2, double y2) {
	
	return (x1 * x2) + (y1 * y2);
}


double compute_angle(double x1, double y1, double x2, double y2) {
	
	double dp;
	
	normalization(x1, y1);
	normalization(x2, y2);
	
	dp = dot_product(x1, y1, x2, y2);
	
	return acos(dp);
}


double radians_to_degrees(const double rad) {
	
	return rad * 180 / M_PI;
}


void normalization(double& x, double& y) {
	
	double len = vec_length(x, y);
	
	x = x / len;
	y = y / len;
	
	return;
}


void output_vector(const string& msg, const double x, const double y, const double len) {
	
	cout << msg << "(" << x << ", " << y << ") has length " << len << endl;
	
	return;
}


void resultant_vector(double x1, double y1, double x2, double y2, double& xR, double& yR) {

	xR = x1 + x2;
	yR = y1 + y2;
	
	return;
}


void display_info(double x1, double y1, double x2, double y2, double angle) {
	
	double vec1 = vec_length(x1, y1);
	double vec2 = vec_length(x2, y2);
	double vecR;
	double xR(0), yR(0);
	string str = "The vectors are ";
	cout << endl;
	
	resultant_vector(x1, y1, x2, y2, xR, yR);
	vecR = vec_length(xR, yR);

	output_vector("First vector: ", x1, y1, vec1);
	output_vector("Second vector: ", x2, y2, vec2);
	output_vector("Resultant vector: ", xR, yR, vecR);

	// angle
	cout << "Angle between vectors (" << x1 << ", " << y1 << ") and ("
		 << x2 << ", " << y2 << ") = " << angle << " degrees." << endl;

	normalization(x1, y1);
	normalization(x2, y2);
	vec1 = vec_length(x1, y1);
	vec2 = vec_length(x2, y2);

	// not orthogonal
	if (abs(angle - 90) >= EPSILON) {
		cout << str << "NOT ORTHOGONAL." << endl;
	}
	// orthonormal
	else if (abs(vec1 - 1) <= EPSILON && abs(vec2 - 1) <= EPSILON) {
		cout << str << "ORTHONORMAL." << endl;
	}
	// orthogonal but not orthonormal
	else {
		cout << str << "ORTHOGONAL, but NOT ORTHONORMAL." << endl;
	}
	
	return;
}
