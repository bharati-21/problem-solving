class Solution {
    public boolean canReach(int[] arr, int start) {
        if(arr == null || arr.length == 0) {
            return false;
        }
        int n = arr.length;
        // This holds all the future possibilities from one number
        Queue<Integer> queue = new LinkedList();
        Set<Integer> seen = new HashSet();
        queue.add(start);
        while(!queue.isEmpty()) {
            int index = queue.poll();
            int jump = arr[index];
            seen.add(index);
            if(jump == 0) {
                return true;
            }
            int nextJump = index + jump;
            int prevJump = index - jump;

            if(nextJump < n) {
                if(!seen.contains(nextJump))
                    queue.add(nextJump);
            }
            if(prevJump >= 0) {
                if(!seen.contains(prevJump))
                    queue.add(prevJump);
            }
        }
        
        return false;
    }
}
