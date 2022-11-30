class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double min = 1e9;
        
        Worker[] workers = new Worker[n];
        for(int i = 0; i<n; i++) {
            int currWage = wage[i];
            int currQuality = quality[i];
            workers[i] = new Worker(currWage, currQuality);
        }
        
        // sort workers according to their ratio (wage / quality)
        Arrays.sort(workers, new Comparator<Worker>() {
            public int compare(Worker w1, Worker w2) {
                if(w2.ratio < w1.ratio) {
                    return 1;
                }
                return -1;
            } 
        });
        
        PriorityQueue<Worker> pq = new PriorityQueue(new Comparator<Worker>() {
            public int compare(Worker w1, Worker w2) {
                if(w2.quality < w1.quality) {
                    return -1;
                }
                return 1;
            }
        });
        
        // build heap to find qualities of smallest k workers
        double sumQuality = 0;
        for(int i = 0; i<n; i++) {
            Worker current = workers[i];
            pq.add(current);
            sumQuality += current.quality;
            if(pq.size() > k) {
                sumQuality -= pq.poll().quality;
            }
            if(pq.size() == k) {
                double currTotal = current.ratio * sumQuality;
                min = Math.min(currTotal, min);
            }
        }
        
        // workers can be chosen such that there are atleast k-1 workers before them        
        return min;
    }
}

class Worker {
    double ratio;
    int wage, quality;
    
    Worker(int wage, int quality) {
        this.wage = wage;
        this.quality = quality;
        this.ratio = (double) wage / (double) quality;
    }
}

/*
2. Let's assume we decide to pay worker[1] == wage[1]
	- offer[0]/offer[1] = quality[0]/quaity[1]
	- offer[0] = (quality[0]/ quality[1]) * offer[1]
	- offer[0] = (10/20) * 50 = 0.5 * 50 = 25
	- But wage[0] = 70 > 25 => Hence, we cannot pay this person
--- 
    - offer[2]/offer[1] = quality[2]/quaity[1]
	- offer[2] = (quality[2]/ quality[1]) * offer[1]
	- offer[2] = (5/20) * 50 = 0.25 * 50 = 12.5
	- But wage[2] = 30 > 12.5 => Hence, we cannot pay this person
Cannot pay anyone if we try to pay minimum wage to worker[1]

2. Let's assume we decide to pay worker[0] == wage[0]
	- offer[1]/offer[0] = quality[1]/quaity[0]
	- offer[1] = (quality[1]/ quality[0]) * offer[0]
	- offer[1] = (20/10) * 70 = 2 * 70 = 140
	- But wage[1] = 50 < 140 => Hence, we can pay this person
--- 
    - offer[2]/offer[0] = quality[2]/quaity[0]
	- offer[2] = (quality[2]/ quality[0]) * offer[0]
	- offer[2] = (5/10) * 70 = 0.5 * 70 = 35
	- But wage[2] = 30 < 35 => Hence, we can pay this person
pay [70, 140, 35]
only choose the smallest two

*/

/*
    ratio = [7, 2.5, 6]
    sortedRatio = [2.5, 6, 7]
    We need at least k-1 people before worker
*/