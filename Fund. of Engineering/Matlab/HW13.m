clc;
clear;

fprintf('Gage Farmer, HW13, M/W 10AM\n');

% Problem 1

sum=0;
for n = 0:20
    sum = sum + ((-1/3)^n)/(2*n+1);
end
sum = sum * sqrt(12);
error = (sum-pi())*100/pi()


% Problem 2

x = [-1 2 5 8 11 14 17];
y = [-3.5 45.1 392.5 1459.9 3668.5 7439.5 13194.1];
p=polyfit(x,y,4);
a=p(1)
b=p(2)
c=p(3)
d=p(4)


% Problem 3