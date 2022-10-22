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
    
        for(int i = 0; i<n-3; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            long first = nums[i];
            for(int j = i+1; j<n-2; j++) {
                if(j > i+1 && nums[j] == nums[j-1]) {
                    continue;  
                }
                
                long second = nums[j];
                long t = target - (first + second);
                
                int left = j+1, right = n-1;
                while(left < right) {
                    long third = nums[left];
                    long fourth = nums[right];
                    
                    long sum = third + fourth;
                    
                    if(sum == t) {
                        List<Integer> l = new ArrayList();
                        l.add((int) first);
                        l.add((int) second);
                        l.add((int) third);
                        l.add((int) fourth);
                        list.add(l);
                        
                        while(left < right && nums[left] == nums[left+1]) left++;
                        while(left < right && nums[right] == nums[right-1]) right--;
                        
                        left++;
                        right--;
                    }
                    else if(sum > t) {
                        right--;
                    }
                    else {
                        left++;
                    }
                }
            }
        }
        
        return list;
    }
    
}