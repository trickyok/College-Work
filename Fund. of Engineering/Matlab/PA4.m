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
D2 = find(D);
D2 = D(D2);

A2 = sort(A);
Alen = length(A);
Amean = mean(A);
Adev = 0;
Amed = median(A);
Alast = A(end);
Alast2 = [A(end-1), A(end)];