class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int iterations = (minutesToTest / minutesToDie) + 1;
        int n = 0;
        
        while((int) Math.pow(iterations,n) < buckets) {
            n++;
        }
        return n;
    }
}

/*
Observations:
- A pig can simulataneously feed on assigned buckets
- Once it feeds, wait for minutesToDie
- Ince minutesToDie has passed, continue until minutesToTest passes

The min pig required is 0
The max pig required is buckets

buckets = 5, and minutesToDie = 20, minutesToTest = 30
1 <= pigs <= 5

As minutesToTest / minutesToDie = (30/20) = 1 => we can only have one iteration to check if pigs die

suppose we choose 2 pigs, then:
    - we feed bucket 1,2 to P1
    - we feed bucket 2,3 to P2
    
    - if P1 dies, bucket 1 or 2 is poisonous
    - if P2 dies, bucket 4 or 5 is poisonous
    - if both P1 & P2 die, bucket 3 is poisonous
    
suppose we choose 3 pigs, then:
    - we feed bucket 1,2 to P1
    - we feed bucket 2,3 to P2
    - we feed bucket 4 to P3
    
    - If P1 dies, bucket 1 is poisonous
    - If P2 dies, bucket 3 is poisonous
    - If P3 dies, bucket 4 is poisonous
    - If both P1, P2 die, bucket 2 is poisonous
    - If no one dies, then bucket 

If tests = 1, and buckets = 5
2^1 >= 5 => F
2^2 >= 5 => F
2^3 >= 5 => T
*/