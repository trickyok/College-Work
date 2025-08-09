clc;
clear;
disp('Gage Farmer, M/W 10AM, 3/2/2022')

% Lab 03

A = [-100 330 -560 0 0; 0 330 0 0 33; 0 0 560 -1000 33; -1 0 1 1 0; 0 1 1 0 -1];
B = [0; 9; 0; 0; 0];
I = A \ B;

disp('      ')
disp('------------------------------------')
fprintf('\n The currents for this problem were:\n')
fprintf('\n I1 was equal to% 7.4f Milliamps', I(1)*1000)
fprintf('\n I2 was equal to% 7.4f Milliamps', I(2)*1000)
fprintf('\n I3 was equal to% 7.4f Milliamps', I(3)*1000)
fprintf('\n I4 was equal to% 7.4f  Milliamps', I(4)*1000)
fprintf('\n I5 was equal to% 7.4f Milliamps \n', I(5)*1000)