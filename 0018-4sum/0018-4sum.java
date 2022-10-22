class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList();
        
        if(nums == null || nums.length == 0) {
            return list;
        }
        
        int n = nums.length;
        if(n < 4) {
            return list;
        }
        
        Arrays.sort(nums);
        fourSumHelper(nums, (long)target, n, 4, list, 0, new ArrayList<>());

        return list;
    }
    
    private void fourSumHelper(int[] nums, long target, int n, int k, List<List<Integer>> list, int index, List<Integer> subList) {
        
        if(k == 2) {
            // to find 2 indices, you need at least n-2 elements
            if(index > n-2) {
                return;
            }
            
            int left = index, right = n-1;
            while(left < right) {
                long sum = nums[left] + nums[right];
                if(sum == target) {
                    List<Integer> l = new ArrayList(subList);
                    l.add(nums[left]);
                    l.add(nums[right]);
                    list.add(l);
                    
                    
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;
                    
                    left++;
                    right--;
                }
                else if(sum > target) {
                    right--;
                }
                else {
                    left++;
                }
            }
            return;
        }
        
        // k = 4, n-4
        for(int i = index; i<n; i++) {
            if(i > index && nums[i] == nums[i-1]) {
                continue;
            }
            
            int num = nums[i];
            long nextTarget = target - num;
            subList.add(num);
            fourSumHelper(nums, nextTarget, n, k-1, list, i+1, subList);
            subList.remove(subList.size()-1);
        }
    }
}