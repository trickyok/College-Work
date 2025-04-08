#include "bounded_buffer.h"
#include <stdio.h>
#include <stdlib.h>

/*Do not use any global variables for implementation*/

void bounded_buffer_init(struct bounded_buffer *b, int size){
	b->buffer = malloc(sizeof(void *) * size);
	b->size = size;
	b->head = 0;
	b->tail = 0;
	b->count = 0;
	
	pthread_mutex_init(&b->lock, NULL);
	pthread_cond_init(&b->not_full, NULL);
	pthread_cond_init(&b->not_empty, NULL);
}

void bounded_buffer_push(struct bounded_buffer *b, void *item){
	pthread_mutex_lock(&b->lock);
	
	while (b->count == b->size) {
		pthread_cond_wait(&b->not_full, &b->lock);
	}
	
	b->buffer[b->tail] = item;
	b->tail = (b->tail + 1) % b->size;
	b->count++;
	
	pthread_cond_signal(&b->not_empty);
	pthread_mutex_unlock(&b->lock);
}

void* bounded_buffer_pop(struct bounded_buffer *b){
    pthread_mutex_lock(&b->lock);
    
    while (b->count == 0) {
    	pthread_cond_wait(&b->not_empty, &b->lock);
    }
    
    void *item = b->buffer[b->head];
    b->head = (b->head + 1) % b->size;
    b->count--;
    
    pthread_cond_signal(&b->not_full);
    pthread_mutex_unlock(&b->lock);
    
    return item;
}

void bounded_buffer_destroy(struct bounded_buffer *b){
	free(b->buffer);
	pthread_mutex_destroy(&b->lock);
	pthread_cond_destroy(&b->not_full);
	pthread_cond_destroy(&b->not_empty);
}
