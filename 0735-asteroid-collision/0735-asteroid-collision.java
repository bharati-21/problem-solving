class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids == null || asteroids.length == 0) {
            return new int[0];
        }
        
        int n = asteroids.length;
        Deque<Integer> stack = new ArrayDeque();
        
        int i = 0;
        
        while(i < n) {
            int asteroid = asteroids[i];
            int currAsteroidSize = Math.abs(asteroid);
            // traverse until the stack is empty
            // or the top of the stack is > 0 (right)
            // and the new asteroid is < 0 (left)
            boolean currAsteroidBlows = false;
            
            while(!stack.isEmpty() && asteroid < 0 && stack.peek() > 0 && !currAsteroidBlows) {
                if(currAsteroidSize < stack.peek()) {
                    currAsteroidBlows = true;
                }
                else if(stack.peek() < currAsteroidSize) {
                    stack.pop();
                }
                else if(stack.peek() == currAsteroidSize) {
                    stack.pop();
                    currAsteroidBlows = true;
                }
                
            }
            if(!currAsteroidBlows) {
                stack.push(asteroid);
            }
            i++;
            
        }
        
        int size = stack.size();
        int[] result = new int[size];
        while(!stack.isEmpty()) {
            result[--size] = stack.pop();
        }

        return result;
    }
}

// 7 -8 -5 -6 2
// 