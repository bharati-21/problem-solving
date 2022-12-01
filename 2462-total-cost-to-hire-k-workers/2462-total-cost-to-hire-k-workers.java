





class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> left = new PriorityQueue<Integer>((a,b) -> a-b);
        PriorityQueue<Integer> right = new PriorityQueue<Integer>((a,b) -> a-b);
        
        int leftIndex = 0;
        int rightIndex = n-1;
        for(; leftIndex < candidates; leftIndex++) {
            int cost = costs[leftIndex];
            left.add(cost);
            costs[leftIndex] = 0;
        }
        for(; rightIndex >= (n-candidates); rightIndex--) {
            int cost = costs[rightIndex];
            if(cost != 0) right.add(cost);
            costs[rightIndex] = 0;
        }
        
        long totalCost = 0;
        while(k-- > 0) {
            int leftMin = left.isEmpty() ? Integer.MAX_VALUE : left.peek();
            int rightMin = right.isEmpty() ? Integer.MAX_VALUE :  right.peek();
            
            if(leftMin <= rightMin) {
                totalCost += (long) leftMin;
                left.poll();
                if(leftIndex < rightIndex) {
                    left.add(costs[leftIndex++]);
                }
            }
            else {
                totalCost += (long) rightMin;
                right.poll();
                if(rightIndex >= leftIndex) {
                   right.add(costs[rightIndex--]);
                }
            }
        }
        
        return totalCost;
    }
}


/*
Naive:
- For every k, iterate through first c candidates and last c candidates.
- Add them to a list, and then sort this list.
- Choose the smallest among them
- Mark it as 0 => indicating that they were chosen
*/
