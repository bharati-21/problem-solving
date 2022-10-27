class Solution {
    public List<Integer> spiralOrder(int[][] inputMatrix) {
        int m = inputMatrix.length, n = inputMatrix[0].length;
        int bottom = m-1, right = n-1;
        int top = 0, left = 0;

        int[] output = new int[m*n];
        int index = 0;

        while(top<=bottom && left<=right) {
            int i = left;

            while(i <= right) {
                output[index++] = inputMatrix[top][i];
                i++;
            }
            top++;

            i = top;
            while(i <= bottom) {
                output[index++] = inputMatrix[i][right];
                i++;
            }
            right--;

            i = right;
            while(i >= left && index < (m*n)) {
                output[index++] = inputMatrix[bottom][i];
                i--;
            }
            bottom--;

            i = bottom;
            while(i >= top && index < (m*n)) {
                output[index++] = inputMatrix[i][left];
                i--;
            }
            left++;
        }
        
        List<Integer> list = new ArrayList();
        for(int num: output) {
            list.add(num);
        }
        return list;
    }
}