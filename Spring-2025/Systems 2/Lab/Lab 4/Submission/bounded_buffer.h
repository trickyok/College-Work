#ifndef _BOUNDED_BUFFER_H
#define _BOUNDED_BUFFER_H
#include <pthread.h>

/* do not use any global variables in this file */

struct bounded_buffer{
    void **buffer;
    int size;
    int head;
    int tail;
    int count;
    
    pthread_mutex_t lock;
    pthread_cond_t not_full;
    pthread_cond_t not_empty;
};

/* do not change the following function definitions */

/* Initialize a buffer; size is the max number of items in the buffer*/
void bounded_buffer_init(struct bounded_buffer *b, int size);

/** Add item to the tail of the buffer. If the buffer is full, wait
 * till the buffer is not full. This function should be thread-safe. */
void bounded_buffer_push(struct bounded_buffer *b, void *item);

/** Remove an item from the head of the buffer. If the buffer is empty,
 * wait till the buffer is not empty. Return the removed item. 
 * This function should be thread-safe. */
void* bounded_buffer_pop(struct bounded_buffer *b);

/* Release the buffer */
void bounded_buffer_destroy(struct bounded_buffer *b);

#endif
