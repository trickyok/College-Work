clc;
clear;

disp('HW12, Gage Farmer, M/W 10AM');

% Problem 1

x=[0:.5:6];
y=-0.4*(x.^4)+7*(x.^2)-20.5*x-28;
plot(x,y);
figure();


% Problem 2

b=[1:.2:8];
Volume=(38-(b*2)).*(24-(b*2)).*b;
plot(b,Volume);
figure();


% Problem 3

x=[2.4, 5.3];
y=[7, 11];
plot(x,y);
fprintf('\nWhen x = 3.2, y = ~8.1\n');


% Problem 4

x=[2,5,6,8,9,13,15];
y=[7,8,10,11,12,14,15];
plot(x,y);
fprintf('\nThe slope of the line is 0.64005\n');
fprintf('\nThe y intercept of the line is 5.6968\n');


% Problem 5

x=[6,10,30,50,80,100];
y=[4.54,5.39,7.77,9.21,10.77,11.6];
plot(x,y);
figure();
x3=nthroot(x,3);
plot(x3,y);
ytest=2.4987*x3;
fprintf('\na is equal to 2.4987\n');
plot(x,ytest);
