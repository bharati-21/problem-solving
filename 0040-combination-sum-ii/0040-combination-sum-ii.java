class Solution {
    private Set<List<Integer>> set;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) return new ArrayList();
        
        Arrays.sort(candidates);
        
        List<List<Integer>> list = new ArrayList();
        set = new HashSet();
        
        combinationSum2Helper(candidates, target, 0, new ArrayList());
        
        list.addAll(set);
        return list;
    }
    
    private void combinationSum2Helper(int[] candidates, int target, int index, List<Integer> subList) {
        int n = candidates.length;
        
        if(target == 0) {
            set.add(new ArrayList(subList));
            return;
        }
        
        if(target < 0 || index == candidates.length) return;
        
        for(int j = index; j<n; j++) {
            if(j > index && candidates[j] == candidates[j-1]) {
                continue;
            }
            subList.add(candidates[j]);
            combinationSum2Helper(candidates, target - candidates[j], j+1, subList);
            subList.remove(subList.size() - 1);
        }
        
    }
}