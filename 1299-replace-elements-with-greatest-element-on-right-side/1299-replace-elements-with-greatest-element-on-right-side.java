class Solution {
    public int[] replaceElements(int[] arr) {
        int greatestSoFar = -1;
        
        int n = arr.length;
        int[] greatest = new int[n];
        
        for(int i = n-1; i>=0; i--) {
            greatest[i] = greatestSoFar;
            greatestSoFar = (arr[i] > greatestSoFar) ? arr[i] : greatestSoFar;
        }
        
        return greatest;
    }
}

/*
[17,18,5,4,6,1]


*/