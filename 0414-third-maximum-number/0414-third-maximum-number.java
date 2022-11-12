class Pair {
    int num;
    boolean wasUpdated;
    Pair(int num, boolean wasUpdated) {
        this.num = num;
        this.wasUpdated = wasUpdated;
    }
}

class Solution {
    public int thirdMax(int[] nums) {
        Pair first = new Pair(-1, false);
        Pair second = new Pair(-1, false);
        Pair third = new Pair(-1, false);
        
        for(int num: nums) {
            if((first.num == num && first.wasUpdated) ||
               (second.num == num && second.wasUpdated) ||
               (third.num == num && third.wasUpdated)) {
                continue;
            }
            
            if(!first.wasUpdated || num >= first.num) {
                third = second;
                second = first;
                first = new Pair(num, true);
            }
            else if(!second.wasUpdated || num >= second.num) {
                third = second;
                second = new Pair(num, true);
            }
            else if(!third.wasUpdated || num >= third.num) {
                third = new Pair(num, true);
            }
        }
        
        if(!third.wasUpdated) {
            return first.num;
        }
        
        return third.num;
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