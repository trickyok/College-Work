#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#define ARRAY_SIZE 1000000
#define THREAD_NO 10

int sum = 0;

int main(){
    int num[THREAD_NO][ARRAY_SIZE/THREAD_NO];
    int sumarray[THREAD_NO];
    int sum = 0;

    srand(100);
    //initialize arrays
    for(int i=0; i< THREAD_NO; i++){
	for(int j=0; j< ARRAY_SIZE/THREAD_NO; j++){
            num[i][j] = rand() % 100;
	}
    }

    // sum of columns
    for (int i=0; i<THREAD_NO; i++) {
	for (int j=0; j<ARRAY_SIZE/THREAD_NO; j++) {
            sumarray[i] += num[i][j];
        }
    }

    for (int i=0; i<THREAD_NO; i++) {
	sum += sumarray[i];
    }

    // your code here. Also add more definition if necessary!
    // ....

    printf("sum = %d\n", sum);
    return 0;
}
