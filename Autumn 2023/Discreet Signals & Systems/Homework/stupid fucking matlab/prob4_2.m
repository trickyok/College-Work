clc;
clear;


% a -----------------------------------------------------------------------

yzi(1) = 7;                                     % yzi[-2] = 7
yzi(2) = -2.5;                                  % yzi[-1] = -2.5

for k=3:18
    yzi(k) = 0.9 * yzi(k-1) - 0.81 * yzi(k-2);  % calculate each value 
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

stepn_1 = [zeros(1,3) ones(1,15)];

k;
x = (0.5 .^ k) .* stepn_1;

for k=3:18
    yzs(k) = 0.9 * yzs(k-1) - 0.81 * yzs(k-2) + 10*x(k) - 15*x(k-2);  % calculate each value                                               
end

k = -2:length(yzs)-3;

figure;
plot(k, yzs);
title('Part B');
xlabel('n');
ylabel('γ[n]');
grid on;

% c -----------------------------------------------------------------------

delta = [zeros(1, 3) ones(1, 15)];              % shows which values in the range are negative or positive

h(1) = 0;                                       % h[-2] = 0
h(2) = 0;                                       % h[-1] = 0

for k=3:18
    h(k) = 0.9 * h(k-1) - 0.81 * h(k-2) + 10 * delta(k) - 15 * delta(k-2);
end

k = -2:length(h)-3;

figure;
plot(k,h);
title('Part C');
xlabel('n');
ylabel('γ[n]');
grid on;

