class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n+1];
        
        for(int citation: citations) {
            if(citation >= n) {
                count[n]++;
            }
            else {
                count[citation]++;
            }
        }
        
        int total = 0;
        for(int i = n; i>=0; i--) {
            total += count[i];
            if(total >= i) return i;
        }
        
        return 0;
    }
}

/*
Number of papers having 0 citations: 1
Number of papers having 1 citations: 1
Number of papers having 2 citations: 0
Number of papers having 3 citations: 1
Number of papers having 4 citations: 0
Number of papers having 5 or greater citations: 2
1 1 3
1 1 2 4
*/