class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(g == null || g.length == 0 || s == null || s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length;
        int m = s.length;
        int i = 0, j = 0;
        int contentChildren = 0;
        while(i < n && j < m) {
            int greed = g[i], size = s[j];
            if(greed <= size) {
                contentChildren++;
                i++;
            }
            j++;
        }
        
        return contentChildren;
    }
}

/*
g = [3, 5, 1, 6, 4]
s = [3,2,6,7]
*/

// [2,3,5,5,6]
// [1,2,3,3,5]
