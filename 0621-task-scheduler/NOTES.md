Observations:
if n == 0 => that means all tasks can be done in any order without any cooldown period
1. Any time we process task[i], we note down it's previous time.
​
[A,1] => task A conducted at time 1
-- Initiaize a queue with tasks
-- Remove them one by one, add the <task, time> to a map
-- Every time we get a same task, we check if current time - map[task] > n
-- If yes, we process this task and update the time
-- else, we need to polll and add it back to the queue.
​
-- But we need to be cautious because we should not be stuck in an infinite loop if all the tasks present are the same.
-- To tackle. this, we could use a map with <task, num> where num = count of tasks.
-- And if topTask = queue.peek() and map[topTask] == queue.size() then we need to stop and return number of tasks * cool down period
​
​
​