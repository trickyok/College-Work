clc;
clear;
fprintf('Gage Farmer, Final Exam, M/W 10AM');


% Problem 4

Req = 1/((1/100)+(1/220)+(1/330));


% Problem 8b

k=29;
d=4800;
m=3.7*10^-4;
Y=(k*d*(m^2))/((4.23*10^-3)*(cosd(67)));


% Problem 9

D=[1.4 2.9 3.8 5.1 7.1 9.2 12.2];
Mass=[13.94 39.74 63.86 110.14 207.74 344.66 601.46];
plot(D, Mass);
xlabel('Length (m)');
ylabel('Mass (kg)');
title('Length vs Mass');


% Problem 10

p=polyfit(D, Mass, 2);
a=p(1)
b=p(2)
c=p(3)


% Problem 17

X=[-14 3.2 -30 15 22 56 39 16 -4.5 8 71]
X2=[];
for i=1:length(X)
    if (X(i) > 5) && (X(i) < 32)
        X2(end+1)=X(i);
    end
end
X2=sort(X2)


% Problem 18

Xsum=sum(X);
fprintf('Xsum = %.1f\n', Xsum);


% Extra Credit

J = [0 1 3 0 2 0 4 0 0 8 2];
K = [3 5 1];
J2 = nonzeros(J)
J = [];
for i=1:length(J2)
    J(end+1)=J2(i);
end
for i=1:length(K)
    J(end+1)=K(i);
end