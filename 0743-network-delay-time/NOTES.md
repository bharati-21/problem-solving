- can apply Dijkstra's to find the minimum time from source to every other node
- find the max time among all these to get the minimum time.
- If any of the times is still INT_MAX, that means it's impossible to reach that node, hence return -1