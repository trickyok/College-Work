clc;
clear;

% Problem 1 - Name, Assignment, Class
disp('Gage Farmer, HW 5, M/W 10AM');

% Problem 2 - Cosine of 20 degrees
P2 = cosd(20)

% Problem 3 - Cosine of 1 radian
P3 = cos(1)

% Problem 4 - Angle in deg of cos^-1(0.866)
P4 = acosd(.866)

% Problem 5 - Round B to integer
B = 4.96246;
P5 = round(B)

% Problem 6 - Print B with 3 sig figs
fprintf('\n P6 = \n\n     B is equal to %.2f',B)
fprintf('\n\n')

% Problem 7 - 1 row matrix with odd values 1-21
P7 = 1:2:21

% Problem 8 - Same as problem 7 but with 2 rows

P8 = [1:2:21; 1:2:21]

% Problem 9 - 2 roots for (x^2 - 1.6x - 35.36 = 0)
%             (will use quadratic equation)

a9 = 1;
b9 = -1.6;
c9 = -35.36;
x9 = ((-b9+sqrt(b9^2-4*a9*c9))/(2*a9));
y9 = ((-b9-sqrt(b9^2-4*a9*c9))/(2*a9));
P9 = [x9, y9]





