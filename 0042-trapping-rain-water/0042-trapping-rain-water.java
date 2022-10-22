class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }    
        
        int n = height.length;
        
        int[] leftMax = new int[n];
        for(int i = 1; i<n; i++) {
            leftMax[i] = Math.max(height[i-1], leftMax[i-1]);
        }
        
        int[] rightMax = new int[n];
        for(int i = n-2; i>=0; i--) {
            rightMax[i] = Math.max(height[i+1], rightMax[i+1]);
        }
        
        int blocks = 0;
        for(int i = 0; i<n; i++) {
            int diff = Math.min(leftMax[i], rightMax[i]) - height[i]; 
            if(diff > 0) {
                blocks+=diff;
            }
        }
        
        return blocks;
    }
}