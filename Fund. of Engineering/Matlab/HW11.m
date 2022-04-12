clc;
clear;
disp('Gage Farmer - HW11 - M/W 10AM');

prompt='\nWhat color licorice are you buying? ';
c=input(prompt,'s');
n=input('\nHow many boxes do you want? ');
p=0;

switch c
    case 'red'
        if 0 < n && n <= 5
            p=p+(n*6);
        elseif 6 <= n && n <= 10
            p=p+30+((n-5)*5);
        elseif n >= 11;
            p=p+55+((n-10)*4);
        else
            disp('That is not a valid number');
        end
    case 'green'
        if 0 < n && n <= 5
            p=p+(n*7);
        elseif 6 <= n && n <= 10
            p=p+35+((n-5)*6);
        elseif n >= 11;
            p=p+65+((n-10)*5);
        else
            disp('That is not a valid number');
        end
    case 'black'
        if 0 < n && n <= 5
            p=p+(n*8);
        elseif 6 <= n && n <= 10
            p=p+40+((n-5)*7);
        elseif n >= 11;
            p=p+75+((n-10)*6);
        else
            disp('That is not a valid number');
        end
    otherwise
        disp('That is not a valid licorice color');
end

fprintf('\nThe total cost is $%.2f for %.f cases of %s licorice.', p, n, c);