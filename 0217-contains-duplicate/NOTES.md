Thoughts:
- Sorting:
- If adjacent numbers are equal, then that number appears twice, return true
- O(log n) - space, O(n logn) - time
- Can use a set
- If the set already contains the said value, then return true
- Can use a map to store <value, count>
- If the count of any value >= 2 return true, else false
- O(n) - space, O(n) - time
- Can use XOR?
- Maybe, if at any point XORing with a number becomes 0, that means some number appeared twice
- This doesn't work
​