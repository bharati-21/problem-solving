class Solution {
	public int[] twoSum(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return new int[0];
        }
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i<n; i++) {
            int num = nums[i];
            map.put(num, i);
        }

        int ans[] = new int[2];
        
        for(int i = 0; i<n; i++) {
            int num = nums[i];
            int complement = target - num;
            if(map.containsKey(complement)) {
                int compIndex = map.get(complement);
                if(compIndex != i) {
                    ans[0] = i;
                    ans[1] = compIndex;
                    break;	
                }
            }
        }

        return ans;
    }
}


/*
- Brute Force: generate all pairs and then check if each of them add up to targetL O(N^2)
- How to optimize? Hash. Add all the numbers to a map, then find for complement of this number.
*/