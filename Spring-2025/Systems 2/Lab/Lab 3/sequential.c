#include <stdio.h>
#include <stdlib.h>
#define ARRAY_SIZE 1000000

int sum = 0;
lock_t mutex;

int main(){
    int num[ARRAY_SIZE];
    srand(100);

    for(int i=0; i< ARRAY_SIZE; i++){
        lock(&mutex);
        num[i] = rand() % 100;
        unlock(&mutex);
    }

    for(int i=0; i<ARRAY_SIZE; i++){
	lock(&mutex);
        sum += num[i];
        unlock(&mutex);
    }

    printf("sum = %d\n", sum);
    return 0;
}
