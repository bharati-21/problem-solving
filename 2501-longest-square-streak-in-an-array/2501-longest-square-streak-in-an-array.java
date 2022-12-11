class Solution {
    public int longestSquareStreak(int[] nums) {
        Set<Integer> set = new HashSet();
        
        for(int num: nums) {
            set.add(num);
        }
        
        Arrays.sort(nums);
        
        Map<Integer, Integer> map = new HashMap();
        int longest = -1;
        
        for(int num: nums) {
            int sqrt = (int) Math.sqrt(num);
            
            if(sqrt * sqrt == num) {
                if(set.contains(sqrt)) {
                    int prev = map.get(sqrt);
                    map.put(num, prev + 1);
                    int len = prev + 1;
                    longest = Math.max(len, longest);
                }
                else {
                    map.put(num, 1);
                }
            }
            else map.put(num, 1);
        } 
        return longest;
    }
}

/*
- add all numbers to a map
- then process each number, if there exists a number/2 and that is also a square increment number


[4,3,6,16,8,2]
[2,3,4,6,8,16]
[]

10, 100, 1000
*/