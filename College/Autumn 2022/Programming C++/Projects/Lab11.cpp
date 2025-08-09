/*
  File: array_pointers.cpp
  Created by: Gage Farmer
  Creation Date: 11/9/2022
  Synopsis: Gets min from list
*/

#include <iostream>
#include <iomanip>

using namespace std;

// Function PROTOTYPES
int read_size();
void read_list(int list[], const int size);
void display_list(const int list[], const int size);
int find_min(const int list[], const int size);
void display_min(const string & message, const int min);

int main()
{

  /* INSERT CODE HERE */
  // Declare a pointer variable called 'list'
  int * list;

  int size = read_size();

  /* INSERT CODE HERE */
  // Allocate an array into the variable 'list' using Dynamic Memory Allocation
  list = new int[size * 4];

  read_list(list, size);

  display_list(list, size);

  int min = find_min(list, size);

  display_min("The minimum value in the list is ", min);
  
  /* INSERT CODE HERE */
  // Delete the array in the variable 'list'
  delete list;

  return 0;
}

// FUNCTION DEFINITIONS

int read_size() {
   int size;
   cout << "Enter the size of your list: ";
   cin >> size;
   cout << endl;
   
   // loop until size is positive
   while (size <= 0) {
	   cout << endl << "Enter a positive size. Try again." << endl;
	   cout << "Enter the size of your list: ";
	   cin >> size;
	   cout << endl;
   }
   
   return size;
}


void read_list(int list[], const int size) {
   for (int i(0); i < size; i++) {
	   cout << "Enter the value to store at index #" << i << ": ";
	   cin >> *(list + (i * 4));
   }
   cout << endl;
}


void display_list(const int list[], const int size) {
   
   cout << "You entered the list: <" << *list;
   for (int i(1); i < size; i++) {
	   cout << ", " << *(list + (i * 4));
   }
   cout << ">" << endl << endl;
}


int find_min(const int list[], const int size) {
   int min = *list;
   
   for (int i(0); i < size; i++) {
	   if (*(list + (i * 4)) < min) {
		   min = *(list + (i * 4));
	   }
   }
   return min;
}


void display_min(const string & message, const int min) {
   cout << message << min << endl;
}
