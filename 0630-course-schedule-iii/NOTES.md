- n different courses
- 1 to n
- courses[i] = [duration, lastDay]
- ith course taken continuously from day d to d + duration
- must be finished on or before the last day
- start on day 1, cannot take two or more courses simultaneously
​
day 1 to day 100
day 101 to day 300
day 301 to day 1300
​
or
day 1 to day 100
day 101 to day 1100
day 1101 to day 3100
​
# Observations
- If a course start day + duration > course last day => cannot pick this course
-- Can sort the array based on last day so that we pick those that end early
​
[[100,200],[200,1300],[1000,1250],[2000,3200]]
[100,200], [1000,1250],[200,1300],[2000, 3200]
​
day 0 to day 100
day 101 to day 1100
day 1100 + 1300
​
​
[0,50], [56, 80], [223, 400], [100, 250]
[50,50], [56,80], [100,250], [223, 400]
​
day 0 to day 50
day 51 to 150
day 151 to day 374