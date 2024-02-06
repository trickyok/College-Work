#include <time.h>
#include <stdlib.h>
#include <stdio.h>



// declaration (no arguments)
void spacer();

// prototype (declaration, but with arguments)
void addEmail(char *nameList, char *serviceList, int *length, char email);

// also prototype
int sum(int x, int y);

// also prototype
void printEmail();

int main() {

    char EmailAccountList[20][20] = {"charlesgagefarmer", "woodraft", "eggman", "yomama69"};
    char EmailServiceList[20][20] = {"@gmail.com", "@yahoo.com", "@gmail.com", "@rambler.ru"};
    char listLength = 4;

    srand(time(NULL));
    int randInt = rand() % 20;
    
    if (randInt > 10) {
        printf("Hello World!\n");
        spacer();
    } else {
        printf("Goodbye World!\n");
        spacer();
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
 
    spacer();

    printEmail(&EmailAccountList[0], &EmailServiceList[0], listLength);

    return 0;
}

int sum(int x, int y) {
    return x + y;
}

void spacer() {
    printf("-----------------------------------------------\n");
}

void addEmail(char *nameList, char *serviceList, int *length, char email) {
    
    char name, service;

    // split email at the @ symbol

    length++;
}

void printEmail(char *nameList, char *serviceList, int length) {

    printf("Enter a position between  1 and %d: ", length);

    int position = 0;
    scanf("%d", &position);

    // professional error catching
    if (position > length) {
        return;
    }

    // since array starts on position 1
    position--;

    int i = 0;

    // print name loop
    while (i < position){
        printf("%s\n", *nameList);
        nameList = nameList + 1;
        i = i+1;
    }

    // print service loop
    while (i < position){
        printf("%s\n", *serviceList);
        serviceList = serviceList + 1;
        i = i+1;
    }

    spacer();
}