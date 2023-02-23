class Project implements Comparable<Project> {
    int cap, profit;
    Project(int cap, int profit) {
        this.cap = cap;
        this.profit = profit;
    }
    
    public int compareTo(Project p) {
        return this.cap - p.cap;
    }
}
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<Project> projects = new ArrayList<Project>();
        
        for(int i = 0; i<n; i++) {
            int profit = profits[i], cap = capital[i];
            
            Project curr = new Project(cap, profit);
            projects.add(curr);
        }
        
        Collections.sort(projects);
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> b-a);
        
        int available = 0;
        while(k-- > 0) {
            while(available < n && projects.get(available).cap <= w) {
                pq.add(projects.get(available).profit);
                available++;
            }
            if(pq.isEmpty()) break;
            
            w += pq.poll();
        }
        
        return w;
    }
}