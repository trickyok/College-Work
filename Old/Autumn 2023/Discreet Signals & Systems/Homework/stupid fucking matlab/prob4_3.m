clc;
clear;


% a -----------------------------------------------------------------------

yzi(1) = -3;                                     % yzi[-2] = -3
yzi(2) = 1.5;                                    % yzi[-1] = 1.5

for k=3:18
    yzi(k) = -0.12 * yzi(k-1) + 0.24 * yzi(k-2);  % calculate each value 
                                                  % of y(k)
end

k = -2:length(yzi)-3;                           % length of k same as y

figure;
plot(k, -yzi); 
title('Part A');
xlabel('n');
ylabel('γ[n]');
grid on;


% b -----------------------------------------------------------------------

yzs(1) = 0;                                     % yzs[-2] = 0
yzs(2) = 0;                                     % yzs[-1] = 0

stepn_1 = [ones(1,18)];

k;
x = cos(0.15 * pi * k - ((15*pi)/180))  .* stepn_1;

for k=3:18
    yzs(k) = -0.12 * yzs(k-1) + 0.24 * yzs(k-2) - 6 * x(k-1) + 2 * x(k-2);
end

k = -2:length(yzs)-3;

figure;
plot(k, yzs);
title('Part B');
xlabel('n');
ylabel('γ[n]');
grid on;

% c -----------------------------------------------------------------------

delta = [ones(1, 18)];              % shows which values in the range are negative or positive

h(1) = 0;                                       % h[-2] = 0
h(2) = 0;                                       % h[-1] = 0

for k=3:18
    h(k) = -0.12 * h(k-1) + 0.24 * h(k-2) - 6 * delta(k-1) + 2 * delta(k-2);
end

k = -2:length(h)-3;

figure;
plot(k,h);
title('Part C');
xlabel('n');
ylabel('γ[n]');
grid on;

