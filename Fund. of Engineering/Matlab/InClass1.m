% bulllll shit by gage <3
clear;

A = [1 2 0 9 2 5 8]
A = sort(A)
A3 = length(A);
Amean = mean(A);
Astd = std(A);
Amiddle = median(A);
Alast = A(end);
Alast2 = A((end-1):(end));
Asum = sum(A);

prompt = 'press enter to continue';
x = input(prompt);
clear;
G = [4 0 2 6 0 9 0]
GNNZ = nnz(G);
Gmax = max(G);