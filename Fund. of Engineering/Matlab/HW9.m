clc;
clear;
fprintf('Gage Farmer 10AM M/W\n');


N=['A.A.'; 'B.B.'; 'C.C.'; 'D.D.'; 'E.E.'; 'F.F.'];
H=[74 61 67 70 69 65];
W=[180 150 112 160 170 185];
ifRequired = true;


for i=1:length(N)
    BMI=(703*W(i))/(H(i)^2);
    fprintf('\nThe BMI of %s is %f.\n', N(i,:), BMI)
end

if ifRequired
    return      %I don't need an if statement lol
end