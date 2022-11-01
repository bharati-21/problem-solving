class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int len = m + n; // (4 + 8) => 12
        int half = len / 2; // 6 elements
        
        if(m > n) {
            return binarySearch(nums2, nums1);
        }
        return binarySearch(nums1, nums2);
    }
    
    private double binarySearch(int[] a, int[] b) {
        int m = a.length;
        int l = 0, r = m-1;
        int n = b.length;
        
        int len = m + n; // (4 + 8) => 12
        int half = len / 2; // 6 elements
        
        double median = 0;
        // len = 1
        // half = 0
        // l = 0, r = -1
        // aMid = -1
        // bMid = 0-(-1)-2 = -1
        // aLeft = MIN
        // aRight = MAX
        // bLeft = MIN
        // bRight = 0
        
        while(true) {
            int aMid = (r < l) ? -1 : (l + r)/2; // (0+3)/2 = 1
            
            int bMid = half - aMid - 2; // 6 - 1 = 5-2 = 3 [0,1,2,3];
            
            double aLeft = (aMid < 0) ? Integer.MIN_VALUE : a[aMid];
            double aRight = ((aMid+1) >= m) ? Integer.MAX_VALUE : a[aMid+1];
            
            double bLeft = (bMid < 0) ? Integer.MIN_VALUE : b[bMid];
            double bRight = ((bMid + 1) >= n) ? Integer.MAX_VALUE : b[bMid+1];
            
            
            if(aLeft <= bRight && bLeft <= aRight) {
                if(len % 2 != 0) {
                    median = Math.min(aRight, bRight);
                }
                else {
                    median = (Math.max(aLeft, bLeft) + Math.min(aRight, bRight))/2;
                }
                
                break;
            }
            
            else if(aLeft > bRight) {
                r = aMid - 1;
            }
            else {
                l = aMid + 1;
            }
        }
        
        return median;
    }
}

// [1,3] m = 2
// [2] n = 1