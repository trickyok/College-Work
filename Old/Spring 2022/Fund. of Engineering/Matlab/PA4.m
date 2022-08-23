clc;
clear;

A = randperm(12);
A = flip(A,2);
A = A(1:9);
B = A(A>5);
B2 = A > 5;
C = find(A>5);

D = [0,6,3,0,2];
D1 = D(D>0);
D2 = D;

A2 = sort(A);
Alen = length(A);
Amean = mean(A);
Adev = 0;
Amed = median(A);
Alast = A(end);
Alast2 = [A(end-1), A(end)];
Asum = sum(A); 

J = [1 5 3 9 6];
Jvertical = J';
% also represented by
J = [1; 5; 3; 9; 6];

D = 1:3:24;
F = linspace(5,75,10);

