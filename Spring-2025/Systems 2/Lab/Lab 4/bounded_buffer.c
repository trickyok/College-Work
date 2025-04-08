#include "bounded_buffer.h"
#include <stdio.h>
#include <stdlib.h>

/*Do not use any global variables for implementation*/

void bounded_buffer_init(struct bounded_buffer *buffer, int size){
	buffer->head = 0;
	buffer->tail = 0;
	buffer->count = 0;
	
	pthread_mutex_init(&buffer->lock, NULL);
	pthread_cond_init(&buffer->not_full);
	pthread_cond_init(&buffer->not_empty);
}

void bounded_buffer_push(struct bounded_buffer *buffer, void *item){
	pthread_mutex_lock(&buffer->lock);
	
	while (buffer->count == BUFFER_SIZE) {
		pthread_cond_wait(&buffer->not_full, &buffer->lock);
	}
	
	buffer->*buffer[buffer->tail] = item;
	buffer->tail = (buffer->tail + 1) % BUFFER_SIZE;
	buffer->count++;
	
	pthread_cond_signal(&buffer->not_empty);
	pthread_mutex_unlock(&buffer->lock);
}

void* bounded_buffer_pop(struct bounded_buffer *buffer){
    pthread_mutex_lock(&buffer->lock);
    
    while (buffer->count=0) {
    	pthread_cond_wait(&buffer->not_empty, &buffer->lock);
    }
    
    void *item = buffer->buffer[buffer->head];
    buffer->head = (buffer->head + 1) % BUFFER_SIZE;
    buffer->count--;
    
    pthread_cond_signal(&buffer->not_full);
    pthread_mutex_unlock(&buffer->lock);
    
    return item;
}

void bounded_buffer_destroy(struct bounded_buffer *buffer){
	pthread_mutex_destroy(&buffer->lock);
	pthread_cond_destroy(&buffer->not_full);
	pthread_cond_destroy(&buffer->not_empty);
}
