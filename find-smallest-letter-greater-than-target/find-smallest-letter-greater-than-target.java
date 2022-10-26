class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int start = 0, end = n - 1;
        
        int pos = -1;
        while(start < end) {
            int mid = (start + end) / 2;
            
            if(letters[mid] > target) {
                end = mid;
            }
            else if(letters[mid] < target) {
                start = mid + 1;
            }
            else if(letters[mid] == target) {
                pos = mid;
                start = mid + 1;
            }
        }
        if(letters[start] <= target) {
            return letters[0];
        }
        return letters[start];
    }
}