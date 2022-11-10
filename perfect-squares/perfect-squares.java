class Solution {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList();
        queue.add(n);
        Set<Integer> visited = new HashSet();
        
        int num = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            num++;
            
            for(int i = 0; i<size; i++) {
                int number = queue.poll();
                
                for(int j = 1; j<=Math.sqrt(number); j++) {
                    int val = number - (j*j);
                    if(val == 0) return num;
                    if(!visited.contains(val)) {
                        queue.add(val);
                        visited.add(val);
                    }
                }
            }
        }
        
        return num;
    }
}