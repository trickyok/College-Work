% Gage Farmer
% 2/28/2022
% Challenge Problems
clear;
ohioRain = [3, 1, 0, 2, 9, 3, 0];


%%% Problem 1
percentRain = (sum(ohioRain > 7) / length(ohioRain)) * 100


%%% Problem 2
ohioRainSorted = sort(ohioRain)
highestThree = ohioRainSorted(end-2:end)


%%% Problem 3
noRain = length(ohioRain(ohioRain==0))


%%% Problem 4
greaterAvg = length(find(ohioRain>mean(ohioRain)))