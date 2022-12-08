class Solution {
    public boolean search(int[] arr, int target) {
        if(arr == null || arr.length == 0) {
            return false;
        }
        
        int n = arr.length;
        
        int start = 0, end = n-1;
        
        while(start < end && arr[start] == arr[end]) {
            start++;
        }
        
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(arr[mid] == target) return true;
            
            // left half sorted
            if(arr[mid] >= arr[start]) {
                if(arr[start] <= target && arr[mid] > target) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            // right half is sorted
            else if(arr[mid] < arr[start]) {
                if(arr[start] > target && arr[mid] <= target) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }
        // [2,5,6,0,0,1,2]
        // 
        // 4,5,7,0,1,2,3
        // 4,5,6,7,0,1,2
        
        return false;
    }
}