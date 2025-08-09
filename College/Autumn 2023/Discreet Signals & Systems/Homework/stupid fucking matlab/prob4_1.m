clc;
clear;


% a -----------------------------------------------------------------------

% Define the values of n for which you want to calculate γ[n]
n_alpha_a = -2:1;
n_beta_a = 0:4;


% origin offset of each function
origin_alpha_a = 3;                                                         % n=0 is the third index
origin_beta_a = 1;                                                          % n=0 is the first index


% Define the first pair of α[n] and β[n]
alpha_a = (-0.9).^(1 - n_alpha_a);
alpha_a(2) = 0;                                                             % corrects n= -1
beta_a = cos(0.25 .* pi .* n_beta_a);
beta_a(1) = 0;


% Calculate γ[n] for the first pair
gamma_a = conv(alpha_a, beta_a);


% Calculate alignment for the graph
origin_gamma_a = origin_alpha_a + origin_beta_a - 1;
n_gamma_a = (0:length(gamma_a)-1)-(origin_gamma_a - 1);


% Plot the nonzero values of γ[n] vs. n for both pairs
figure;
plot(n_gamma_a, gamma_a);
title('Part A');
xlabel('n');
ylabel('γ[n]');
grid on;


% b -----------------------------------------------------------------------

% Define the values of n for which you want to calculate γ[n]
n_alpha_b = -1:3;
n_beta_b = 1:5;


% origin offset of each function
origin_alpha_b = 2;                                                         % n=0 is the third index
origin_beta_b = -1; 


% Define the second pair of α[n] and β[n]
alpha_b = 36 .^ (n_alpha_b / 2 - 1);
beta_b = (1 ./ (n_beta_b + 1));


% Calculate γ[n] for the first pair
gamma_b = conv(alpha_b, beta_b);


% Calculate alignment for the graph
origin_gamma_b = origin_alpha_b + origin_beta_b - 1;
n_gamma_b = (0:length(gamma_b)-1)-(origin_gamma_b - 1);


% Plot the nonzero values of γ[n] vs. n for both pairs
figure;
plot(n_gamma_b, gamma_b);
title('Part B');
xlabel('n');
ylabel('γ[n]');
grid on;