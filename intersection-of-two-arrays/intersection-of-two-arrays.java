class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        
        List<Integer> list = new ArrayList();
        
        if(n < m) {
            Arrays.sort(nums1);
            for(int num: nums2) {
                if(list.contains(num)) {
                    continue;
                }
                binarySearch(nums1, num, list);
            }
        }
        else {
            Arrays.sort(nums2);
            for(int num: nums1) {
                if(list.contains(num)) {
                    continue;
                }
                binarySearch(nums2, num, list);
            }
        }
        
        int[] ans = new int[list.size()];
        int index = 0;
        for(int num: list) {
            ans[index++] = num;
        }
        
        return ans;
    }
    
    private void binarySearch(int[] nums, int target, List<Integer> list) {
        int start = 0, end = nums.length-1;
        while(start <= end) {
            int mid = (start + end)/2;
            if(nums[mid] == target) {
                list.add(nums[mid]);
                return;
            }
            else if(nums[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        
        return;
    }
}