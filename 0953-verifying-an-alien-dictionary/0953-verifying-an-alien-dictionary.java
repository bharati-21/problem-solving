class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] alphabetOrder = new int[26];
        for(int i = 0; i<26; i++) {
            char ch = order.charAt(i);
            // index of the alphabet in the string order
            alphabetOrder[ch - 'a'] = i+1;
        }
        
        int n = words.length;
        
        for(int i = 0; i<n-1; i++) {
            String curr = words[i], next = words[i+1];
            int currLen = curr.length();
            int nextLen = words[i+1].length();
            
            for(int index = 0; index < currLen; index++) {
                if(index >= nextLen) {
                    return false;
                }
                char currChar = curr.charAt(index);
                char nextChar = next.charAt(index);
                
                if(currChar != nextChar) {
                    int currOrder = alphabetOrder[currChar - 'a'];
                    int nextOrder = alphabetOrder[nextChar - 'a'];
                    
                    if(nextOrder < currOrder) {
                        return false;
                    }
                    else {
                        break;
                    }
                }
            }
        }
        
        return true;
    }
}

/*
- compare i and j in words[i] and word[j]
- if(word[0][0] < word[1][0]) continue with other words
- violation: when any word[i][k] > word[i+1][k]
or word[i]


*/