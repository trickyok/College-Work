#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#define ARRAY_SIZE 1000000

int sum = 0;
pthread_mutex_t mutex;

int main(){
    int num[ARRAY_SIZE];
    srand(100);

    for(int i=0; i< ARRAY_SIZE; i++){
        pthread_mutex_init(&mutex, NULL);
	pthread_mutex_lock(&mutex);
        num[i] = rand() % 100;
        pthread_mutex_unlock(&mutex);
	pthread_mutex_destroy(&mutex);
    }

    for(int i=0; i<ARRAY_SIZE; i++){
	pthread_mutex_init(&mutex, NULL);
	pthread_mutex_lock(&mutex);
        sum += num[i];
        pthread_mutex_unlock(&mutex);
	pthread_mutex_destroy(&mutex);
    }

    printf("sum = %d\n", sum);
    return 0;
}
