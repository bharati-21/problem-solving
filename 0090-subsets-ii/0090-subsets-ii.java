class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList();
        
        subsetsWithDupHelper(nums, new ArrayList(), list, 0);
        return list;
    }
    
    private void subsetsWithDupHelper(int[] nums, List<Integer> subList, List<List<Integer>> list, int index) {
        int n = nums.length;
        if(index == n) {
            list.add(new ArrayList(subList));
            return;
        }
        
                
        subList.add(nums[index]);
        subsetsWithDupHelper(nums, subList, list, index+1);
        subList.remove(subList.size() - 1);
        
        int nextIndex = index;
        while(nextIndex < n-1 && nums[nextIndex] == nums[nextIndex+1]) {
            nextIndex++;
        } 
        subsetsWithDupHelper(nums, subList, list, nextIndex+1);
    }
}