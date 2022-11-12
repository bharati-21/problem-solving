class Solution {
    public int thirdMax(int[] nums) {
        long third = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long first = Long.MIN_VALUE;
        
        for(int num: nums) {
            if(first == num || second == num || third == num) {
                continue;
            }
            if(num > first) {
                third = second;
                second = first;
                first = num;
            }
            else if(num > second) {
                third = second;
                second = num;
            }
            else if(num > third) {
                third = num;
            }
        }
        
        if(third == Long.MIN_VALUE) {
            return (int) first;
        }
        
        return (int) third;
    }
}

/*
sort: sort numbers are return n-1-3 (if n < 3 return num[n-1]) O(n logn)
heap: maintain a heap sort of length 3 
*/

/*
1 2 4 5 6 7
2 4 5 1 6 5 1 6 7
2 4 5
*/