% Homework 11
clc;
clear;


% Define the function f[n]
syms n q
f_n = symsum((n-2-32*q)^2 * rectpuls((n-2-32*q)/24, 24), q, -inf, inf);

% a.) Period of the signal
N = 32;

% b.) Display one complete cycle of f[n] in the range of 0 <= n <= (N-1)
n_range = 0:(N-1);
f_n_range = eval(subs(f_n, n, n_range));
figure;
stem(n_range, f_n_range);
xlabel('n');
ylabel('f[n]');
title('One Complete Cycle of f[n]');
grid on;

% c.) Calculate the discrete Fourier transform F[k]
F_k = fft(f_n_range);

% d.) Evaluate F[0], F[7], F[16], and F[25]
F0 = F_k(1); % F[0]
F7 = F_k(8); % F[7]
F16 = F_k(17); % F[16]
F25 = F_k(26); % F[25]

% Plot the magnitude and phase of F[k]
k_range = 0:(N-1);
figure;
subplot(2, 1, 1);
stem(k_range, abs(F_k));
xlabel('k');
ylabel('|F[k]|');
title('Magnitude of F[k]');
grid on;
subplot(2, 1, 2);
stem(k_range, angle(F_k) * 180 / pi);
xlabel('k');
ylabel('Phase (degrees)');
title('Phase of F[k]');
grid on;

% Display the magnitude and phase of F[0], F[7], F[16], and F[25]
disp('Magnitude and Phase of F[k]:');
disp(['F[0]: Magnitude = ', num2str(abs(F0)), ', Phase = ', num2str(angle(F0) * 180 / pi), ' degrees']);
disp(['F[7]: Magnitude = ', num2str(abs(F7)), ', Phase = ', num2str(angle(F7) * 180 / pi), ' degrees']);
disp(['F[16]: Magnitude = ', num2str(abs(F16)), ', Phase = ', num2str(angle(F16) * 180 / pi), ' degrees']);
disp(['F[25]: Magnitude = ', num2str(abs(F25)), ', Phase = ', num2str(angle(F25) * 180 / pi), ' degrees']);
%Note: The rectpuls() function is used to generate a rectangular pulse, which is not a built-in Matlab function. You can define it as follows:

function y = rectpuls(t, width)
%RECTPULS Rectangular pulse function
%   Y = RECTPULS(T, WIDTH) generates a rectangular pulse of width WIDTH
%   centered at time T. T and WIDTH are scalar values.
%   The function returns Y, a vector of the same size as T, with values 0 or 1.

t = abs(t);
y = double(t < width/2);
end