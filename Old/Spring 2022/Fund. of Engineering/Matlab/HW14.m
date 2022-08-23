clc;
clear;
fprintf('Gage Farmer HW14 M/W 10AM\n\n');


% Problem 1

match=randperm(12,12);
days={'Monday' 'Tuesday' 'Wednesday' 'Thursday' 'Friday' 'Saturday'};
for i=1:2:12
    fprintf('Team %.0f will play Team %.0f on %s.\n', match(i), match(i+1), days{(i+1)/2})
end


% Problem 2

h=0;     % height of water m
maxH=0;  % max height      m
hArray=[]; % holds h vals
v=0;     % vol of water    m^3
r=2;     % radius          m
f=.14;   % flow            m^3/s
o=.023;  % outlet          m^2
g=9.8;   % gravity         m/s^2

for i=0:1:3000
    v=v+f;             % flow in tank      m^3
    q=o*(sqrt(2*g*h)); % flow out outlet   m^3/s
    v=v-q;             % flow out tank
    h=v/(pi()*(2^2));    % height of water   m
    hArray=[hArray h];
    if (h>maxH)
        maxH=h;
    end
end

fprintf('\n\nThe minimum height of the tank without overflowing is %.2f\n', maxH);
plot(0:1:3000, hArray);
title('Water Height Over Time');
xlabel('Time (s)');
ylabel('Water Height (m)');
