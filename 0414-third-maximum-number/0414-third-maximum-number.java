class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet();
        
        for(int num: nums) {
            if(set.contains(num)) continue;
            if(set.size() == 3) {
                if(set.first() < num) {
                    set.remove(set.first());
                    set.add(num);
                }
            }
            else {
                set.add(num);
            }
        }
        
        if(set.size() == 3) {
            return set.first();
        }
        
        return set.last();
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