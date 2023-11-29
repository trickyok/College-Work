% Homework 11

% 11.1
% B)

syms q;

% Define the parameters
frequency = 1;  % Frequency of the periodic function (in Hz)
sampling_rate = 100;  % Number of samples per second
duration = 64;  % Total duration of the signal (in seconds)

% Generate the time vector
n = linspace(0, duration, duration * sampling_rate);

% Generate the function values
f1 = ((n-7-64*q)/4) .^ 2;

amplitude = int32(max(abs(f)));

% Find the indices where the signal is above a threshold (e.g., 0.5 for a square wave)
above_threshold = find(f > 0.5);

% Calculate the pulse width
pulse_width = n(above_threshold(duration)) - n(above_threshold(1));

disp(['Amplitude: ' num2str(amplitude)]);
disp(['Pulse Width: ' num2str(pulse_width)]);

f2 = rectpulse((n-7-64*q)/36, n);
f = symsum(f1 * f2, q, -Inf, Inf);

% Plot the signal
plot(n, f);
xlabel('Time (seconds)');
ylabel('Amplitude');
title('One Cycle of a Periodic Sampled Time Function');
grid on;
