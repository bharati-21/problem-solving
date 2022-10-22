class Solution {
    public int maxArea(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }
        
        int n = height.length;
        
        int maxWater = 0;
        
        int left = 0, right = n-1;
        
        while(left < right) {
            int lHeight = height[left];
            int rHeight = height[right];
            
            int minHeight = Math.min(lHeight, rHeight);            
            int area = (right-left) * minHeight;
            
            maxWater = Math.max(area, maxWater);
            if(lHeight < rHeight) {
                left++;
            }
            else if(rHeight < lHeight) {
                right--;
            }
            else {
                right--;
                left++;
            }
        }
        
        return maxWater;
    }
}

