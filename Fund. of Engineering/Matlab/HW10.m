clc;
clear;

fprintf('Gage Farmer HW10 10AM M/W\n');

fprintf('\nProblem 1\n');
H=randi([-20,20],1,18)
H1=H>0;
H1=H(H1)
H1sort=sort(H1)
H1mean=mean(H1)
fprintf('Largest values of H1 are %.0f and %.0f', H1sort(length(H1sort)), H1sort(length(H1sort)-1));


fprintf('\n\nProblem 2\n');
% Even                  %
% 11900 < x < 27000     %
% sqrt > 110            %
% Div by 17 and 29      %

for i=11900:2:27000
    if sqrt(i)>110
        if rem(i,17)==0
            if rem(i,29)==0
                fprintf('The answer that fits each parameter is %.0f', i);
                break
            end
        end
    end
end

