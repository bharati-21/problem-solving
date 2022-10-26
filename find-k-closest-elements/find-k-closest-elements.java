class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList();
        if(arr == null || arr.length == 0 || k > arr.length) {
            return list;
        }
        
        int n = arr.length;
        int start = 0, end = n-k;
        
        while(start < end) {
            int mid = (start + end)/2;
            int distLeft = Math.abs(x - arr[mid]);
            int distRight = Math.abs(x - arr[mid+k]);
            
            if(arr[mid] == arr[mid+k]) {
                if(arr[mid] < x) {
                    start = mid + 1;
                }
                else {
                    end = mid;
                }
            }
            else if(distLeft <= distRight) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        
        int i = start;
        while(i < start + k) {
            list.add(arr[i]);
            i++;
        }
        
        return list;
    }
}