/**
/   Author - Gage Farmer
/   lab1.c
**/

#include <stdio.h>

// function prototypes
int checkPerfectNumber(int num);
double power_int(double base, int exp);


int main(void) {

    // test case for even perfect number
    int p= 496;
    int n = 36;

    printf("checkPerfectNumber(%d) = %d\n", p, checkPerfectNumber(p));
    printf("checkPerfectNumber(%d) = %d\n", n, checkPerfectNumber(n));

    // i did finish the bonus question
    double b1 = -7.1, b2 = -3.0;
    int e1 = -4, e2 = 4;

    printf("power_int(%If, %d) = %If\n", b1, e1, power_int(b1, e1));
    printf("power_int(%If, %d) = %If\n", b2, e2, power_int(b2, e2));
}


// function definitions
int checkPerfectNumber(int num) {
    int sum = 0;

    if (num % 2 != 0 || num < 1) {
        return 0;
    }
    
    for (int i = 1; i < num; i++) {
        if (num % i == 0) {
            sum += 1;
        }
    }

    return sum == num;
}

double power_int(double base, int exp) {
    double ans;

    if (exp == 0) {
        ans = 1.00;
    } else if (exp > 0) {
        ans = base * power_int(base, exp - 1);
    } else {
        ans = 1 / power_int(base, -exp);
    }

    return ans;
}

