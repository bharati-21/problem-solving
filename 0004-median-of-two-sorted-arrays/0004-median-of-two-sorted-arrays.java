class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)) {
            return (double)0;
        }
        int m = nums1.length, n = nums2.length;
        int len = m+n;
        int[] ans = new int[len];
        int i = 0, j = 0, index = 0;
        
        while(i < m && j < n) {
            if(nums1[i] <= nums2[j]) {
                ans[index++] = nums1[i++];
            }
            else {
                ans[index++] = nums2[j++];
            }
        }
        
        while(i < m) {
            ans[index++] = nums1[i++];
        }
        while(j < n) {
            ans[index++] = nums2[j++];
        }
        
        double median = 0;
        if(len % 2 == 0) {
            double first = ans[(len/2)-1];
            double second = ans[len/2];
            
            median = (first + second)/2;
        }
        else {
            median = (double) ans[len/2];
        }
        
        return median;
    }
}