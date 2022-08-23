clc;
clear;
disp('Gage Farmer HW7 M/W 10AM')


fprintf('\nProblem 1\n')
v = 25;
a = -9.8;
t = 0:.01:3;
d = v*t+(1/2)*a*t.^2;
plot(t,d)
title('Distance vs Time')
xlabel('Time (s)')
ylabel('Height (m)')
fprintf('The maximum height of the ball was% .2f meters\n', max(d))


fprintf('\nProblem 2\n')
rad=[10 15 20 25 30];
vol=(4/3)*pi*rad.^2;
figure('Color', 'white')
plot(rad, vol)
title('Volume vs Radius')
ylabel('Volume (mm^3)')
xlabel('Radius (mm)')
fprintf('The total volume of all of the spheres is %.2f mm^3\n', sum(vol))


fprintf('\nProblems 3 and 4\n')
fprintf('10110111 in base 10 form is %.0f\n', bin2dec('10110111'))
fprintf('231 in binary form is %s\n', dec2bin(231))