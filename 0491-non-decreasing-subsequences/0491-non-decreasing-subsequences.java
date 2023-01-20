class Solution {
    Set<List<Integer>> list;
    private int n;
    public List<List<Integer>> findSubsequences(int[] nums) {
        list = new HashSet();
        
        n = nums.length;
        
        findSubsequencesHelper(nums, new ArrayList(), 0);
        return new ArrayList(list);
    }
    
    private void findSubsequencesHelper(int[] nums, List<Integer> subList, int i) {
        if(i == n) {
            if(subList.size() >= 2) list.add(new ArrayList(subList));
            return;
        }
        
        int m = subList.size();
        
        if(m == 0 ||
          subList.get(m-1) <= nums[i]) {
            subList.add(nums[i]);
            findSubsequencesHelper(nums, subList, i+1);
            m = subList.size();
            if(m != 0) subList.remove(m-1);
        }
        
        
        findSubsequencesHelper(nums, subList, i+1);
    }
}