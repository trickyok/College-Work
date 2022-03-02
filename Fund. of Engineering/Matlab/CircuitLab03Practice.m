% Gage Farmer
clc;
clear;


% 3.3 Array Division

A = [4 -2 6; 2 8 2; 6 10 3];
B = [8; 4; 0];
X = A \ B;
Xi = inv(A) * B;


% Kirchoff's Laws (Loop and Junction Rules)

C = [100 200 0; 0 200 -300; 1 -1 -1];
D = [5; 0; 0];
I = C \ D;


% Sample Kirchoff Problem

E = [3 6 0 3 4 0 0; 0 -6 4 0 0 0 0; 0 0 -4 0 0 6 0; 0 0 0 -1 1 1 0; -1 1 1 0 0 0 0; 0 1 0 0 -1 0 1; 0 0 -1 0 0 1 1];
F = [42; 6; 6; 0; 0; 0; 0];
G = E\F;
