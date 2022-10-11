class Solution {
    public int[] diStringMatch(String s) {
        if(s == null || s.length() == 0) {
            return new int[0];
        }
        
        int n = s.length();
        int[] permutation = new int[n+1];
        char first = s.charAt(0);
        int increasing = 0;
        int decreasing = n;
        
        for(int i = 0; i<n; i++) {
            char ch = s.charAt(i);
            if(ch == 'I') {
                permutation[i] = increasing++;
            }
            else {
                permutation[i] = decreasing--;
            }
        }
        permutation[n] = decreasing;
        return permutation;
    }
}
/*
13420
1230
*/