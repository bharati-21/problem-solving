class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        List<Integer> subsetSumOne = new ArrayList();
        List<Integer> subsetSumTwo = new ArrayList();
        
        int half = n/2;
        generateSubsetSum(nums, 0, half+1, subsetSumOne, 0);
        generateSubsetSum(nums, half+1, n, subsetSumTwo, 0);

        int minDiff = Integer.MAX_VALUE;
        Collections.sort(subsetSumOne);
        
        for(int first: subsetSumTwo){
            int newGoal = goal - first;            
            int position = Collections.binarySearch(subsetSumOne, newGoal);
            if(position >= 0) {
                return 0;
            }
            else {
                position = -1 * (position + 1);
                int low = position-1;
                if(low >= 0) {
                    int sum = first + subsetSumOne.get(low);
                    int diff = Math.abs(goal - sum);
                    minDiff = Math.min(minDiff, diff);
                }
                if(position != subsetSumOne.size()) {
                    int sum = first + subsetSumOne.get(position);
                    int diff = Math.abs(goal - sum);
                    minDiff = Math.min(minDiff, diff);
                }
            } 
        }  
        
        return minDiff;
    }
    
    private void generateSubsetSum(int[] nums, int index, int end, List<Integer> list, int sum) {
        if(index == end) {
            list.add(sum);
            return;
        }
        
        int curr = nums[index];
        generateSubsetSum(nums, index+1, end, list, sum+curr);
        generateSubsetSum(nums, index+1, end, list, sum);
    }
    
    private int getMinDifference(List<Integer> l1, List<Integer> l2, int goal) {
        int m = l1.size(), n = l2.size();
        int left = 0, right = n-1;
        int diff = Integer.MAX_VALUE;
        
        while(left < m && right >= 0) {
            int sum = l1.get(left) + l2.get(right);
            
            diff = Math.min(diff, Math.abs(goal - sum));
            
            if(sum == goal) {
                return 0;
            }
            if(sum > goal) {
                right--;
            }
            else {
                left++;
            }
        }
        
        return diff;
    }
    
    private int binarySearch(int goal, int first, List<Integer> nums) {
        int n = nums.size();
        int start = 0, end = n-1;
        int res = Integer.MAX_VALUE;
        
        while(start <= end) {
            int mid = (start + end)/2;
            int second = nums.get(mid);
            
            int sum = first + second;
            int diff = Math.abs(goal - sum);
            res = Math.min(diff, res);
            
            if(sum > goal) {
                end--;    
            }
            else if(sum < goal) {
                start++;
            }
            else {
                return 0;
            }
        }
        
        return res;
    }
}
