/**
/   Author - Gage Farmer
/   lab1.c
**/

#include <stdio.h>

int checkPerfectNumber(int num);
double power_int(double base, int exp);

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

int main(void) {

    int x = 28, y = 16;
    double base1 = 7.1, base2 = -3.0;
    int exp1 = -4, exp2 = 4;

    printf("checkPerfectNumber(%d) = %d\n", x, checkPerfectNumber(x));
    printf("checkPerfectNumber(%d) = %d\n", y, checkPerfectNumber(y));
    printf("\n");
    printf("checkPerfectrNumber(%If, %d) = %If\n", base1, exp1, power_int(base1,exp1));
    printf("checkPerfectrNumber(%If, %d) = %If\n", base2, exp2, power_int(base2,exp2));

    return 0;
}