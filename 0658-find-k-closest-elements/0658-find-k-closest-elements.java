class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList();
        if(arr == null || arr.length == 0) {
            return list;
        }
        int[] kClosest = new int[k];
        
        int n = arr.length;
        int start = 0, end = n-1;
        
        while(start < end) {
            int mid = (start + end) / 2;
            
            if(arr[mid] >= x) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        
        
        int right = start, left = start-1;
        while(k-- != 0) {
            if(right < n && left >= 0) {
                int distLeft = x - arr[left];
                int distRight = arr[right] - x;
                if(distLeft <= distRight) {
                    left--;
                }
                else {
                    right++;
                }
            }
            else if(right < n) {
                right++;
            }
            else {
                left--;
            }
        }
        
        left+=1;
        right-=1;
        while(left <= right) {
            list.add(arr[left]);
            left++;
        }
        
        return list;
    }
}