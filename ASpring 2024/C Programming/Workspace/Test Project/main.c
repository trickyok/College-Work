#include <time.h>
#include <stdlib.h>
#include <stdio.h>

int main() {

    srand(time(NULL));
    int randInt = rand() % 20;
    
    if (randInt > 10) {
        printf("Hello World!\n");
    } else {
        printf("Goodbye World!\n");
    }



    while (randInt > 0) {
        printf("%d\n", randInt);
        randInt--;
    }
 
    return 0;
}
