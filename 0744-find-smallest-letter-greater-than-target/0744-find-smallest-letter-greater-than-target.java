class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        
        int start = 0, end = n-1;
        char answer = 'a';
        
        while(start <= end) {
            int mid = start + (end - start)/2;
            
            if(letters[mid] <= target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        
        if(start == n) return letters[0];
        
        return letters[start];
    }
}