#include "bounded_buffer.h"
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

#define NUM_PRODUCERS 3
#define NUM_CONSUMERS 2
#define MESSAGES_PER_PRODUCER 10

struct bounded_buffer queue;

void *producer(void *ptr);
void *consumer(void *ptr);

int main() {
    srand(time(NULL));
    bounded_buffer_init(&queue, NUM_PRODUCERS + NUM_CONSUMERS);
    
    pthread_t producers[NUM_PRODUCERS];
    pthread_t consumers[NUM_CONSUMERS];

    for (int i = 0; i < NUM_PRODUCERS; i++) {
        int *id = malloc(sizeof(int));
        *id = i;
        pthread_create(&producers[i], NULL, producer, id);
    }

    for (int i = 0; i < NUM_CONSUMERS; i++) {
        int *id = malloc(sizeof(int));
        *id = i;
        pthread_create(&consumers[i], NULL, consumer, id);
    }

    sleep(5);
    bounded_buffer_destroy(&queue);
	
    return 0;
}

/* this is the function executed by the producer thread. 
   It should generate a number of messages and push them into the queue */
void *producer(void *ptr){
    int id = *(int *)ptr;
    free(ptr);

    for (int i = 0; i < MESSAGES_PER_PRODUCER; i++) {
        int* msg = malloc(sizeof(int));
        *msg = id * 100 + i;
        bounded_buffer_push(&queue, msg);
        printf("Producer %d pushed %d\n", id, *msg);
        sched_yield();
    }

    return NULL;
}

/* this is the function executed by the consumer thread. 
   It should pop messages from the queue and print them */
void *consumer(void *ptr){
    int id = *(int *)ptr;
    free(ptr);

    while (1) {
        int* item = (int*)bounded_buffer_pop(&queue);
        printf("Consumer %d popped %d\n", id, item);
        free(item);
        sched_yield();
    }

    return NULL;
}
