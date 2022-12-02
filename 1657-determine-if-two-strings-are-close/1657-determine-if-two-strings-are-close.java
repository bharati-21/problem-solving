class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        
        int n = word1.length();
        
        int[] frequencyWordOne = new int[26];
        int[] frequencyWordTwo = new int[26];
        
        for(int i = 0; i<n; i++) {
            char ch = word1.charAt(i);
            frequencyWordOne[ch - 'a']++;
        }
        
        for(int i = 0; i<n; i++) {
            char ch = word2.charAt(i);
            if(frequencyWordOne[ch - 'a'] == 0) {
                return false;
            }
            frequencyWordTwo[ch - 'a']++;
        }
        
        Arrays.sort(frequencyWordOne);
        Arrays.sort(frequencyWordTwo);
        
        for(int i = 0; i<26; i++) {
            if(frequencyWordOne[i] != frequencyWordTwo[i]) return false;
        }
        
        return true;
    }
}
/*
aaaabcczp
a = 4
b = 1
c = 2
z = 1
p = 1
aabaacczp
bbzbbaacp
b = 4
z = 1
a = 2
p = 1
c = 1
*/


/*
abc bca
cba
abc

cabbba
acbbbc
abcccb
abbccc
abbccc


0 -> b
1 -> c
2 -> a

in word1, index 0 has a
and in word2, index 1 has b

so swap in word1, index 0 with index
abbbcc

cabbba
aabbba

*/