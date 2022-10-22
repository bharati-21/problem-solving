class Solution {
   public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];

        if(nums == null || nums.length == 0) {
            return ans;
        }

        int n = nums.length;

        for(int i = 0; i<n; i++) {
            int num = nums[i];
            int complement = target - nums[i];

            boolean found = binarySearch(i, num, n, nums, complement, ans);
            if(found) {
                break;
            }
        }

        return ans;
    }

    private boolean binarySearch(int index, int num, int n, int[] nums, int target, int[] ans) {
        int left = 0, right = n-1;
        while(left <= right) {
            int mid = left + (right-left)/2;
            
            int numMid = nums[mid];
            if(numMid == target && mid != index) {
                if(mid > index) {
                    ans[0] = index+1;
                    ans[1] = mid+1;
                }
                else {
                    ans[1] = index+1;
                    ans[0] = mid+1;
                }
                return true;
            }
            else if(numMid > target) {
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }

        return false;
    }

}