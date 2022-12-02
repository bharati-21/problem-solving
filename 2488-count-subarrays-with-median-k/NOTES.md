- all integers are distinct in array of size n
- number of non-empty subarray that have median == k
​
Naive way: generate all subarrays and for each subarray check if median is k -> O(n^3)
​
[3]
[3,2]
[3,2,1]
[3,2,1,4]
[3,2,1,4,5]
[2]
[2,1]
[2,1,4]
[2,1,4,5]
[1]
[1,4]
[1,4,5]
[4]
[4,5]
[5]
​
​
[3,2,1,4,5]
[-1,-1,-1,0,1]
[-1,0,-1]