class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        
        int n = citations.length;
        // If the citation at i is h, then we need h papers more that satisfy this
        // That h papers can be found by (n-i) (number of papers to the right of i)
        // So if h >= (n-i), that means we have at least h papers
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
0 1 3 5 6
0 >= (5-0)
1 >= (5-1)
3 >= (5-2)
1 1 3
1 1 2 4
*/
