class Solution {
    public int maxLength(List<String> arr) {
        if(arr == null || arr.size() == 0){
            return 0;
        }
        return maxLengthHelper(arr, 0, new int[26]);
    }
    
    private int maxLengthHelper(List<String> arr, int index, int[] seen) {
        if(index == arr.size()) {
            return 0;
        }
        
        int[] currSeen = seen.clone();
        String sequence = arr.get(index);
        boolean hasUnique = true;
        
        for(char ch: sequence.toCharArray()) {
            if(currSeen[ch - 'a'] == 1) {
                hasUnique = false;
                break;
            }
            else {
                currSeen[ch - 'a']+=1;
            }
        }
        
        int includeCurr = 0;
        if(hasUnique) {
           includeCurr =  sequence.length() +  maxLengthHelper(arr, index+1, currSeen);
        }
        
        int excludeCurr = 0 + maxLengthHelper(arr, index+1, seen);
        
        return Math.max(includeCurr, excludeCurr);
    }
}