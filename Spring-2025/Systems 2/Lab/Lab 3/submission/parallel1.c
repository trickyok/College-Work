#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#define ARRAY_SIZE 1000000
#define THREAD_NO 10

int sum = 0;
int num[THREAD_NO][ARRAY_SIZE/THREAD_NO];
int sumarray[THREAD_NO] = {0};

// Structure to pass arguments
typedef struct {
    int thread_id;
} ThreadArgs;


void *sum_calc(void *arg) {
    ThreadArgs *args = (ThreadArgs *)arg;
    int id = args->thread_id;
    free(args);  // Free allocated memory

    for (int j = 0; j < ARRAY_SIZE / THREAD_NO; j++) {
        sumarray[id] += num[id][j];
    }

    sum += sumarray[id];

    return NULL;
}


int main(){
    pthread_t threads[THREAD_NO];
    srand(100);
    
    //initialize arrays
    for(int i=0; i< THREAD_NO; i++){
	for(int j=0; j< ARRAY_SIZE/THREAD_NO; j++){
            num[i][j] = rand() % 100;
	}
    }
    
    // Create threads
    for (int i=0; i < THREAD_NO; i++) {
	ThreadArgs *args = malloc(sizeof(ThreadArgs));
	if (args == NULL) {
		perror("Malloc Error");
		exit(1);
	}
	args->thread_id = i;
	pthread_create(&threads[i], NULL, sum_calc, args);
    }
    
    // Collect finished threads
    for (int i=0; i < THREAD_NO; i++) {
    	pthread_join(threads[i], NULL);
    }

    printf("sum = %d\n", sum);
    return 0;
}
