/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Pair {
    TreeNode node;
    int distance;
    
    Pair(TreeNode node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    private Map<TreeNode, TreeNode> parentNodes;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root == null) return new ArrayList();
    
        List<Integer> nodesAtDistanceK = new ArrayList();
        parentNodes = new HashMap();
        traverseTree(root, null);
        
        Queue<Pair> queue = new LinkedList();
        Set<TreeNode> visited = new HashSet();
        visited.add(target);
        queue.add(new Pair(target, 0));
        
        while(!queue.isEmpty()) {
            Pair currPair = queue.poll();
            TreeNode currNode = currPair.node;
            int currDistance = currPair.distance;
            
            if(currDistance == k) {
                nodesAtDistanceK.add(currNode.val);
            }
            
            TreeNode left = currNode.left, right = currNode.right;
            TreeNode parent = parentNodes.get(currNode);
            
            if(left != null && !visited.contains(left)) {
                queue.add(new Pair(left, currDistance + 1));
                visited.add(left);
            }
            if(right != null && !visited.contains(right)) {
                queue.add(new Pair(right, currDistance + 1));
                visited.add(right);
            }
            if(parent != null && !visited.contains(parent)) {
                queue.add(new Pair(parent, currDistance + 1));
                visited.add(parent);
            }
        }
        
        return nodesAtDistanceK;
    }
    
    private void traverseTree(TreeNode root, TreeNode parent) {
        if(root == null) {
            return;
        }
        
        parentNodes.put(root, parent);
        traverseTree(root.left, root);
        traverseTree(root.right, root);
    }
}