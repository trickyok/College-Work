clc
clear
% Gage Farmer HW6
disp('Gage Farmer MW 10 AM HW 6')


% Problem 1
Problem1 = linspace(2,19,8)


% Problem 2
Problem2 = [6:3:21]


% Problem 3
B = [1:2:9; 2:3:14; 3:4:19];
Problem3 = B(:,2)


% Problem 4
Problem4 = B(1:2,3:5)


% Problem 5
m = 3.5;
p = 4.2;
Problem5 = [m/p, m+p, m^p, m/(m+p)]


% Problem 6
r1 = 100;
r2 = 300;
r3 = 500;
Problem6 = 1/((1/r1)+(1/r2)+(1/r3))


% Problem 7
g = 6.67e-11;   %Nm^2/kg^2
m1 = 75;        %kg
m2 = 5.98e28;   %kg
r = 6.378e6;    %m
Problem7 = (g*m1*m2)/r^2
