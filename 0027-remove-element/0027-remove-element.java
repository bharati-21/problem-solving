class Solution {
    public int removeElement(int[] nums, int val) {
        int newIndex = 0, index = 0;
        int n = nums.length;
        
        while(index < n) {
            int num = nums[index];
            if(num != val) {
                nums[newIndex] = nums[index];
                newIndex++;
                index++;
            }
            else {
                index++;
            }
        }
        
        return newIndex;
    }
}