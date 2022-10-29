class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        return subsetsHelper(n-1,  nums, new ArrayList()); 
    }
    
    private List<List<Integer>> subsetsHelper(int i, int[] nums, List<Integer> l) {
        List<List<Integer>> list = new ArrayList();
        if(i < 0) {
            list.add(new ArrayList(l));
            return list;
        }
        
        l.add(nums[i]);
        List<List<Integer>> includeCurrList = subsetsHelper(i-1, nums, l);
        l.remove(l.size()-1);
        List<List<Integer>> excludeCurrList = subsetsHelper(i-1, nums,l);
        
        list.addAll(includeCurrList);
        list.addAll(excludeCurrList);
        
        return list;
    }
}