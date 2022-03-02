% Intro to Loops
clc
clear

% Ex. Problem 3
Fib(1) = 0;
Fib(2) = 1;

for N = 3:20
    Fib(N)=Fib(N-1)+Fib(N-2)
end
disp(Fib)


% While Loops

n=1;
num=1;
while num < 1000
    % The squared values are being allowed to print
    num = 2^n
    n = n+1;
end
