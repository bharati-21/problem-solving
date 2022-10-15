class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position == null || position.length == 0) {
			return 0;
		}
		if(speed == null || speed.length == 0){
			return 0;
		}
     		
        int n = position.length;
        double[][] sortedPair = new double[n][2];
        
        for(int i = 0; i<n; i++) {
            sortedPair[i] = new double[] {
                position[i],
                (double)(target-position[i])/speed[i]
            };
        }

		Arrays.sort(sortedPair, (a,b) -> Double.compare(a[0], b[0]));
        
        int fleets = 0;
        double prevFleet = 0;
		for(int i = n-1; i>=0; i--) {
            double currentTime = sortedPair[i][1];
            
            if(prevFleet < currentTime) {
                prevFleet = currentTime;
                fleets++;
            }
            
        }
            
        return fleets;
	
    }
}

