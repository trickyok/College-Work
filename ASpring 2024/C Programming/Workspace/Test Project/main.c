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
        int i = randInt - 1;

        while (i > -1) {
            printf("%d ", randInt - i);
            i--;
        }

        printf("\n");
        randInt--;
    }
 
    return 0;
}
