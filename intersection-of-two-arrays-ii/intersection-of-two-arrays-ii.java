class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> list = new ArrayList();
        
        int m = nums1.length, n = nums2.length;
        
        int i = 0, j = 0;
        while(i < m && j < n) {
            if(nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j]) {
                i++;
            }
            else {
                j++;
            }
        }
        
        int[] ans = new int[list.size()];
        for(i = 0; i<list.size(); i++) {
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}

/*
nums1 = [4,5,9], nums2 = [4,4,8,8,9]
nums1 = [1,1,2,2] nums2 = [2,2]
*/