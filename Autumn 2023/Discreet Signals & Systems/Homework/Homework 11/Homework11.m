% Homework 11
% Gage Farmer

clc;
clear;

% Problem 11.1 ------------------------------------------------------------

N = 64;
n = 0:N-1;
f = zeros(1, N);

for q = -100000:100000
    f = f + ((n - 7 - 64 * q) / 4).^2 .* rectpuls((n - 7 - 64 * q) / 36, 3);
end

% Display one complete cycle

figure;
subplot(2, 1, 1);
stem(n, f);
title('One Complete Cycle of f[n]');
xlabel('n');
ylabel('f[n]');

% Calculate and plot the discrete Fourier transform

F = fft(f);
k = 0:N-1;

subplot(2, 1, 2);
stem(k, abs(F));
title('Magnitude of F[k]');
xlabel('k');
ylabel('|F[k]|');
stem(k, angle(F) * (180 / pi)); % Convert phase to degrees
title('Phase of F[k]');
xlabel('k');
ylabel('Phase (degrees)');

datacursormode on

% Problem 11.2 ------------------------------------------------------------

N = 16;
n = 0:N-1;
k = 0:N-1;
ga = 2*cos(2*pi*n/8) + cos(2*pi*n/12);
Ga = fft(ga);

% Plot time function

figure;
subplot(3, 1, 1);
stem(n, ga);
title('ga[n]');
axis tight
xlabel('n');
ylabel('Amplitude');

% Plot magnitude of spectrum

subplot(3, 1, 2);
stem(k,abs(Ga));
axis tight
title('Magnitude of Ga[k]');
xlabel('k');
ylabel('|Ga[k]|');

% Plot phase of spectrum (in degrees)

subplot(3, 1, 3);
stem(k,angle(Ga) * 180 / pi);
title('Phase of Ga[k] (degrees)');
xlabel('k');
axis tight
ylabel('Phase (degrees)');
axis tight

% Problem 11.3 ------------------------------------------------------------

load('prob11_3.mat');
t = (0:0.0586:N-1)*12.5e-6; 
xs = xs / N;

figure;
subplot(3, 1, 1);
stem(t, xs);
xlabel('Time (s)'); 
ylabel('xs'); 
title('Time-domain signal');

Fs = 1/12.5e-6; 
Xs = fft(xs)/N; 
f = (-N/2:0.0586:N/2-1)*Fs/N; 

subplot(3, 1, 2);
stem(f, real(Xs)); 
xlabel('Frequency (Hz)'); 
ylabel('Real(Xs)');
title('Real part of spectrum');

subplot(3, 1, 3);
stem(f, imag(Xs)); 
xlabel('Frequency (Hz)'); 
ylabel('Imag(Xs)'); 
title('Imaginary part of spectrum');
