clc;
clear;

scores=[69 77 95 99 88 92 100 72 87];
s=scores>90;
ss=sum(s);
p=ss/length(scores)*100;


clear;

names={'AA', 'BB', 'CC', 'DD', 'EE', 'FF', 'GG', 'HH', 'II'};
scores=[69 77 95 99 88 92 100 72 84];

fprintf('\n %s score was %i', names{4}, scores(4))


clear;

x=pi/4;
format long
mycos=0;
for n=0:30
    mycos=mycos+(-1)^n*x^(2*n)/factorial(2*n);
end
fprintf('\n estimate of my cos was %.8f',mycos)


clear;

b=3;
c=-4;
d=5;

Y=(b<d)*5+(c^2>d)*2-(d>(2*c))*8


clear;

pay=5000*.1+(6000-5000)*.2;
sales=input('Enter the employee sales this week: ');
if sales<=5000
    pay=.1*sales;
else
    pay=5000*.1+(sales-5000)*.2;
end
fprintf('The pay this week was %.f dollars.\n', pay);

clc;
clear;

cost=10;
group=input('Enter your group size: ');
if group>=8
    cost=8;
end
fprintf('The total cost of tickets for the group of %.f is %.f dollars\n', group, (group*cost));