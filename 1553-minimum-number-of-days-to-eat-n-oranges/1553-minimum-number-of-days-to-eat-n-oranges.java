class Solution {
    public int minDays(int n) {
        if(n == 0) return 0;
        
        Set<Integer> visited = new HashSet();
        Queue<Integer> nodes = new LinkedList<>();
        
        visited.add(n);
        nodes.add(n);
        int days = 0;
        
        while(!nodes.isEmpty()) {
            int size = nodes.size();
            while(size != 0) {
                int currNode = nodes.poll();
                if(currNode == 0) return days;
                
                if(currNode % 2 == 0) {
                    int nextNode = currNode / 2;
                    if(!visited.contains(nextNode)) {
                        nodes.add(nextNode);
                        visited.add(nextNode);
                    }
                }
                if(currNode % 3 == 0) {
                    int nextNode = (currNode / 3);
                    if(!visited.contains(nextNode)) {
                        nodes.add(nextNode);
                        visited.add(nextNode);
                    }
                }
                if(!visited.contains(currNode - 1)) {
                    int nextNode = currNode - 1;
                    visited.add(nextNode);
                    nodes.add(nextNode);
                }
                
                size--;
            }
            days++;
        }
        
        return -1;
    }
}

/*
1. 10 -> 9
    2. 9 -> 8
    2. 9 -> 3
        3. 3 -> 2
            4. 
        3. 3 -> 1
            4. 
1. 10 -> 5
    2. 5 -> 4
        3. 4 -> 2
        3. 4 -> 3
*/