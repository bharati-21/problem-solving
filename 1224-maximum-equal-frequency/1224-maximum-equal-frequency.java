class Solution {
    public int maxEqualFreq(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap(), frequency = new HashMap();
        int res = 0;
        for(int i = 0; i<nums.length; i++) {
            int n = nums[i];
            count.put(n, count.getOrDefault(n, 0) + 1);
            int freq = count.get(n);
            frequency.put(freq, frequency.getOrDefault(freq, 0) + 1);
            
            int total = freq * frequency.get(freq);
            if (total == i + 1 && i != nums.length - 1) { 
                res = Math.max(res, i + 2);
            } else if (total == i) { 
                res = Math.max(res, i + 1);
            }
        }
        
        return res;
    }
}

/*
- All the numbers have same frequency
- One number will have a different frequency
- Include that number and 
*/