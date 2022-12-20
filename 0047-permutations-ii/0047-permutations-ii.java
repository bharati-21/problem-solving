class Solution {
    List<List<Integer>> perms;
    private Map<Integer, Integer> count;
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList();

        perms = new ArrayList();
        count = new HashMap();
        
        for(int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        permuteUniqueHelper(nums, new ArrayList());
        return perms;
    }

    private void permuteUniqueHelper(int[] nums, List<Integer> perm) {
        if(perm.size() == nums.length) {
            perms.add(new ArrayList(perm));
            return;
        }
        
        for(int num: count.keySet()) {
            int c = count.get(num);
            if(c == 0) continue;
            
            perm.add(num);
            count.put(num, c-1);
            permuteUniqueHelper(nums, perm);
            perm.remove(perm.size()-1);
            count.put(num, c);
        }
    }
}
