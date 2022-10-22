class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }    
        
        int n = height.length;
        
        int leftMax = 0;
        int rightMax = 0;
        int blocks = 0;
        
        
        int left = 0, right = n-1;
        while(left < right) {
            int lHeight = height[left];
            int rHeight = height[right];
            
            int diff = 0;
            if(leftMax <= rightMax) {
                diff = leftMax - lHeight;
            }
            else {
                diff = rightMax - rHeight;
            }
            
            if(diff > 0) {
                blocks+=diff;
            }
        
            leftMax = Math.max(leftMax, lHeight);
            rightMax = Math.max(rightMax, rHeight);
            if(leftMax <= rightMax) {
                left++;
            }
            else { 
                right--;    
            }
        }
        
        return blocks;
    }
}