class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] count = new int[101];  
        
        for(int[] log: logs) {
            int birth = log[0], death = log[1];
            count[birth - 1950]++;
            count[death - 1950]--;
        }
        
        
        int maxPopulationYear = 1950, maxPopulation = count[0];
       
        for(int i = 1; i<=100; i++) {
            count[i] += count[i-1];
            
            if(count[i] > maxPopulation) {
                maxPopulationYear = i + 1950;
                maxPopulation = count[i];
            }
        }
        return maxPopulationYear;
    }
}