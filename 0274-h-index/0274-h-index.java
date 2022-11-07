class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        
        int n = citations.length;
        for(int i = 0; i<n; i++) {
            int citation = citations[i];
            if(citation >= (n-i)) {
                return n-i;
            }
        }
        
        return 0;
    }
}

/*
Number of papers having 0 citations: 1
Number of papers having 1 citations: 1
Number of papers having 2 citations: 
Number of papers having 3 citations: 1
Number of papers having 4 citations: 0
Number of papers having 5 citations: 
1 1 3
1 1 2 4
*/