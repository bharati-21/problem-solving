class Solution {
    public int hIndex(int[] citations) {
        int h = -1;
        int n = citations.length;
        
        int start = 0, end = n-1;
        while(start <= end) {
            int mid = (start + end)/2;
            int citation = citations[mid];
            int papers = n-mid;
            if(citation == papers) {
                return citation;
            }
            else if(citation < papers) {
                start = mid + 1;
            }
            else {
                end = mid - 1;    
            }
        }
        return n - start;
    }
}