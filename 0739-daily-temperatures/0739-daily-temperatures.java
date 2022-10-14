class Pair {
    int temp, index;
    Pair(int temp, int index) {
        this.temp = temp;
        this.index = index;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0) {
            return new int[0];
        }
        
        int n = temperatures.length;
        Deque<Pair> stack = new ArrayDeque();
        
        int[] result = new int[n];
        for(int i = 0; i<n; i++) {
            int temp = temperatures[i];
            while(!stack.isEmpty()) {
                if(stack.peek().temp < temp) {
                    Pair top = stack.pop();
                    result[top.index] = i-top.index;
                }
                else {
                    break;
                }
            }
            
            stack.push(new Pair(temp, i));
        }
        
        return result;
    }
}