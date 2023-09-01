% Step 1: Load the data
load('prob1_3.mat')

% Step 2: Plot the data
figure;
plot(t, g)
xlabel('Time')
ylabel('Signal')
title('Signal Data')

% Step 3: Enable Data Cursor mode and guide user through data selection
disp('Use Data Cursor tool to select points.')
datacursormode on
pause

% Step 4: Select the peak of the signal
disp('Click on the peak of the signal.')
peakCursor = datacursormode(gcf);
waitfor(gcf, 'SelectionType', 'click')
peakPoint = getCursorInfo(peakCursor);
A = peakPoint.Position(2);  % Vertical offset (A)

% Step 5: Select the mean value of the signal
disp('Click on the mean value of the signal.')
meanCursor = datacursormode(gcf);
waitfor(gcf, 'SelectionType', 'click')
meanPoint = getCursorInfo(meanCursor);
meanValue = meanPoint.Position(2);  % Mean value of the signal (M + A)

% Step 6: Select two consecutive zero-crossings
disp('Click on the first zero-crossing.')
zeroCursor = datacursormode(gcf);
waitfor(gcf, 'SelectionType', 'click')
zero1Point = getCursorInfo(zeroCursor);
zero1 = zero1Point.Position(1);  % Time of the first zero-crossing

disp('Click on the second zero-crossing.')
waitfor(gcf, 'SelectionType', 'click')
zero2Point = getCursorInfo(zeroCursor);
zero2 = zero2Point.Position(1);  % Time of the second zero-crossing

% Step 7: Calculate f and θ
wavelength = zero2 - zero1;
f = 1 / wavelength;

% Step 8: Calculate θ using trigonometry
theta_rad = acos((meanValue - A) / M);

% Step 9: Convert θ to degrees
theta_deg = rad2deg(theta_rad);

% Display calculated values
fprintf('Calculated values:\n')
fprintf('A (Vertical Offset): %.2f\n', A)
fprintf('M (Peak-to-Mean Distance): %.2f\n', M)
fprintf('f (Frequency): %.2f Hz\n', f)
fprintf('θ (Phase Angle): %.2f degrees\n', theta_deg)

% Save the plot as a PDF file
saveas(gcf, 'signal_plot.pdf')

% Function to retrieve cursor information
function cursorInfo = getCursorInfo(cursorObj)
    cursorInfo = getCursorInfo(cursorObj);
    cursorInfo = cursorInfo(end);
end
