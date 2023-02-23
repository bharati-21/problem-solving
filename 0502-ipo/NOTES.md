t - ith projecy has profits[i] and capital[i] to start it
- inital capital == w
- once a project is done, it's profit is added to capital
- k distinct project to maximize final capital
​
k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
- initial capital == 0, hence pick 0 w += 1
- start 1, w+=(2-1) w+=1
- start 2, w+=(3-1) w+=2
- w = 4
​
Pick any project with capital <= w
Choose the project among these that has the highest profits
​