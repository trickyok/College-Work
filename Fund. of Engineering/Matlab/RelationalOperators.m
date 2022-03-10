clc;
clear;

A=1;
B=3;
C=5;

D=(A>B);
D=(A==B);
D=(A<B);
D=50*(A>B)+60*(A<B)+30*((2*A+B)==C);



clear;
fprintf('\nSample Problem 1\n')

x=-2;
y=-2;
QUADRANT=(x>0)*(y>0)*1+(x<0)*(y>0)*2+(x<0)*(y<0)*3+(x>0)*(y<0)*4



clear;
fprintf('\nSample Problem 2\n\n')

D=[7 3 1 9 4 8 2 3];
F=[-6 1 7 2 -1 3 4 0];

for N=1:length(D)
    if D(N)>3
        disp('Raise your right hand')
    elseif F(N)>=4
        disp('Raise your left hand')
    else
        disp('Stand up goober')
    end
end



clear;
fprintf('\n\nSample Problem 3\n')


hours=input('\nEnter hours worked:  ');

if hours>40
    pay=(hours-40)*30+40*20;
else
    pay=hours*20;
end

fprintf('\nYou worked %.2f hours for $ %.2f of pay', hours, pay)



clear;
fprintf('\n\nSample Problem 4\n\n')

disp('deez')