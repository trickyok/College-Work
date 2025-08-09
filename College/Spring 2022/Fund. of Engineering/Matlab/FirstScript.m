clc;
clear;

A = 1:10;
B = 2*A;
C = A.^2;
D = B.^2;

plot(A,B,'g:d',A,C,'c s');
xlabel('Time (s)');
ylabel('Distance (m)');
title('Distance vs Time');
