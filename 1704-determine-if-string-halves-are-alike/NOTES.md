- n = even length
- don't have to worry about odd length
- split it into 2 halves:
- Naive way of doing this is:
- iterate a (1st half) from 0 to n/2 --- keep count
- iterate b (2nd half) from n/2 to n --- keep count
- If both are same, then return true, else false
- We can also do this in one go using two pointers