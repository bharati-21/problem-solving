class Solution {
    public int maximumPopulation(int[][] logs) {
        HashMap<Integer, Integer> population = new HashMap();
        
        for(int[] log: logs) {
            int birth = log[0], death = log[1];
            int year = birth;
            
            while(year < death) {
                if(population.containsKey(year)) {
                    population.put(year, population.get(year) + 1);
                }
                else {
                    population.put(year, 1);
                }
                year++;
            }
            
        }
        
        int maxPopulationYear = 0, maxPopulation = 0;
        
        for(int year: population.keySet()) {
            int count = population.get(year);
            if(count > maxPopulation) {
                maxPopulation = count;
                maxPopulationYear = year;
            }
            else if(count == maxPopulation && year < maxPopulationYear) {
                maxPopulation = count;
                maxPopulationYear = year;
            }
        }
        
        return maxPopulationYear;
    }
}
