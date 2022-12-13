//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N) {
        return inversionCountHelper(arr, 0l, N-1);
    }
    
    private static long inversionCountHelper(long[] arr, long start, long end) {
        if(start >= end) return 0;
        
        long mid = start + (end - start)/2;
        long c1 = inversionCountHelper(arr, start, mid);
        long c2 = inversionCountHelper(arr, mid+1, end);
        
        return c1 + c2 + crossInversionCount(arr, start, mid, end);
    }
    
    private static long crossInversionCount(long[] arr, long start, long mid, long end) {
        int size = (int) (end - start) + 1;
        int i = (int) start, j = (int) mid+1;
        long[] temp = new long[size];
        int index = 0;
        
        long count = 0;
        while(i <= mid && j <= end) {
            if(arr[j] < arr[i]) {
                count += (mid - i + 1);
                temp[index++] = arr[j++];
            }
            else {
                temp[index++] = arr[i++];
            }
        }
        
        while(i <= mid) {
            temp[index++] = arr[i++];
        }
        while(j <= end) {
            temp[index++] = arr[j++];
        }
        
        i = (int) start; 
        index = 0;
        while(i <= end) {
            arr[i++] = temp[index++];
        }
        
        return count;
    }
}

/*
Brute force: compare every i with i+1 to n element. If a[i] > a[i+1..n] then calculate inversion
Sort the array and then difference of current position of an element and the sorted position 
*/