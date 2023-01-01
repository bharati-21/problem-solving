//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair {
    int steps, num;
    
    Pair(int num, int steps) {
        this.steps = steps;
        this.num = num;
    }
}

class Solution {
    int mod = 100000;
    int minimumMultiplications(int[] arr, int start, int end) {
        Set<Integer> visited = new HashSet();
        Queue<Pair> numbers = new LinkedList();
        numbers.add(new Pair(start, 0));
        visited.add(start);

        while(!numbers.isEmpty()) {
            Pair currPair = numbers.poll();
            int currNum = currPair.num;
            int currSteps = currPair.steps;
            
            for(int num: arr) {
                long nextNum = num * currNum;
                nextNum = (nextNum) % mod;
                
                int next = (int) nextNum;
                
                if(next == end) {
                    return currSteps+1;
                }
                if(visited.contains(next)) {
                    continue;
                }
                
                visited.add(next);
                numbers.add(new Pair(next, currSteps+1));
            }
        }
        
        return -1;
    }
}


/*
3*2 = 6 % 1e5 => 6
6*5 = 30 % 1e5 => 30
30*7 = 210 % 1e5 => 210
210*2 = 420 % 1e5 => 420

*/