class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        
        if(nums == null || nums.length == 0) {
            return list;
        }
        
        int n = nums.length;
        Arrays.sort(nums);
        
        for(int i = 0; i<n-2; i++) {
            if(i == 0 || nums[i] != nums[i-1]) {
                int num = nums[i];
                int j = i+1, k = n-1;
                int target = 0-num;
                
                while(j < k) {
                    int sum = nums[j] + nums[k];
                    if(sum == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while(j < k && nums[j] == nums[j+1]) {
                            j++;
                        }
                        while(k > j && nums[k] == nums[k-1]) {
                            k--;
                        }
                        j++;
                        k--;
                    }
                    else if(sum < target) {
                        j++;
                    }
                    else {
                        k--;
                    }
                }
            }
        }
        
        return list;
    }
}


/*
0 -> 1
1 -> 2
2 -> 3
-1 -> 4
-4 -> 5
*/
// Brute force says: keep three loops and search for every triplet and check if they equal 0. => O(n^3)
// For every element in i, check for two numbers that sum up to 0-i (n^2)
// Sort the array and use two pointers with i, j, and k