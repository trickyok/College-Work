#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <assert.h>
#include <createThreads.h>

#define THREAD_NO 10

void test_threads() {
	main();
}

int test_main() {
	printf("Begin thread testing/n");
	test_threads();
	printf("Thread testing successful\n");
	return 0;
}

