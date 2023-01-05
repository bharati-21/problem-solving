Brute force:
- start from the root node
- choose every node in the tree as a good node
- Try to do a traversal from the root until that node and then check if it's a good node
- Doing this will be O(n^2)
​
- Start from root, iterate over the left and right subtree
- send the max value so far in the path, if in the path at every node, the node val >= greater val then increment good nodes.