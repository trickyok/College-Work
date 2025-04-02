#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

#define ARRAY_SIZE 1000000
#define THREAD_NO 10

int sum = 0;
int num[THREAD_NO][ARRAY_SIZE / THREAD_NO];
int sumarray[THREAD_NO] = {0};
pthread_mutex_t lock;

// Structure to pass arguments
typedef struct {
    int thread_id;
} ThreadArgs;

// Thread function to compute partial sum
void *sum_calc(void *arg) {
    ThreadArgs *args = (ThreadArgs *)arg;
    int id = args->thread_id;
    free(args);  // Free allocated memory

    // Update column sum safely
    for (int j = 0; j < ARRAY_SIZE / THREAD_NO; j++) {
    	pthread_mutex_lock(&lock);
        sumarray[id] += num[id][j];
        pthread_mutex_unlock(&lock);
    }

    // Update total sum safely
    pthread_mutex_lock(&lock);
    sum += sumarray[id];
    pthread_mutex_unlock(&lock);

    return NULL;
}

int main() {
    pthread_t threads[THREAD_NO];
    pthread_mutex_init(&lock, NULL);
    srand(100);
    
    // Initialize array with random values
    for (int i = 0; i < THREAD_NO; i++) {
        for (int j = 0; j < ARRAY_SIZE / THREAD_NO; j++) {
            num[i][j] = rand() % 100;
        }
    }
    
    // Create threads
    for (int i = 0; i < THREAD_NO; i++) {
        ThreadArgs *args = malloc(sizeof(ThreadArgs));
        if (args == NULL) {
            perror("Malloc Error");
            exit(1);
        }
        args->thread_id = i;

        // Function pointer passing
        pthread_create(&threads[i], NULL, sum_calc, args);
    }
    
    // Wait for threads to finish
    for (int i = 0; i < THREAD_NO; i++) {
        pthread_join(threads[i], NULL);
    }

    printf("sum = %d\n", sum);
    
    pthread_mutex_destroy(&lock);
    return 0;
}

