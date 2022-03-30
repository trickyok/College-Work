clc;
clear;
fprintf('Gage Farmer HW8 10AM M/W\n')

W=500;
L=120;
h=50;
d=0.5;
A=pi*d^2/4;
x=(10:110);
t=(10:110);

for n=10:1:110
    t(n-9)=(W*L)*((sqrt(h^2+x(n-9)^2))/(h*n))*(1/(2*A));
end

plot(x,t);
ylabel('Stress (lbs/in^2)');
xlabel('Distance (in)');
title('Stress vs Distance');