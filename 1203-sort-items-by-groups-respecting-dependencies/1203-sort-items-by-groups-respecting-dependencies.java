class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        HashMap<Integer, Integer> nodeToGroup = new HashMap();
        HashMap<Integer, ArrayList<Integer>> groupToNode = new HashMap();
        HashMap<Integer, ArrayList<Integer>> itemDependency = new HashMap();
        HashMap<Integer, ArrayList<Integer>> groupDependency = new HashMap();
        
        for(int item = 0; item < n; item++) {
            // Every isolated item in it's own group
            if(group[item] == -1) {
                group[item] = m++;
            }
            
            int g = group[item];
            nodeToGroup.put(item, g);
            
            if(!groupToNode.containsKey(g)) {
                groupToNode.put(g, new ArrayList());
            }
            groupToNode.get(g).add(item);
        }
        
        for(int item = 0; item < n; item++) {
            int g = group[item];
            // int g = nodeToGroup.get(item);
            
            List<Integer> beforeList = beforeItems.get(item);
            // before must appear before item, hence create an edge between the before item and 
            // item.
            for(int before: beforeList) {
                if(!itemDependency.containsKey(before)) {
                    itemDependency.put(before, new ArrayList());
                }
                itemDependency.get(before).add(item);
                int beforeGroup = group[before];
                // int beforeGroup = nodeToGroup.get(before);
                
                // Create an edge between the beforeGroup and g
                // If they are not equal, that is the node before and the item
                // are not part of the same group, don't create dependency
                if(beforeGroup != g) {
                    if(!groupDependency.containsKey(beforeGroup)) {
                        groupDependency.put(beforeGroup, new ArrayList());
                    }
                    groupDependency.get(beforeGroup).add(g);
                }
            }
        }
        
        List<Integer> groupTopoOrder = getTopologicalOrder(groupDependency, m);
        if(groupTopoOrder.isEmpty()) {
            return new int[0];
        }
        
        List<Integer> nodeTopoOrder = getTopologicalOrder(itemDependency, n);
        if(nodeTopoOrder.isEmpty()) {
            return new int[0];
        }
        
        // Topological order within group
        Map<Integer, List<Integer>> orderedGroupNodes = new HashMap();
        for(int node : nodeTopoOrder) {
            // int g = group[node]
            int g = nodeToGroup.get(node);
            
            orderedGroupNodes.putIfAbsent(g, new ArrayList());
            orderedGroupNodes.get(g).add(node);
        }
         
        int[] ans = new int[n];
        int index = 0;
        
        // Now traverse topological order of group and add all nodes within group.
        for (int g : groupTopoOrder) {
            if(orderedGroupNodes.containsKey(g)) {
                for (int u : orderedGroupNodes.get(g)) {
                    ans[index++] = u;
                }
            }
        }
        
        return ans;
    }
    
    private List<Integer> getTopologicalOrder(HashMap<Integer, ArrayList<Integer>> map, int n) {
        int[] indegree = new int[n];
        List<Integer> list = new ArrayList();
        
        for(int parent: map.keySet()) {
            for(int child: map.get(parent)) {
                indegree[child]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i<n; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        int count = 0;
        while(!queue.isEmpty()) {
            int front = queue.poll();
            count++;
            list.add(front);
            
            // If the current node has any children
            // i.e. if it appears before any other node
            if(map.containsKey(front)) {
                for(int next: map.get(front)) {
                    indegree[next]--;
                    if(indegree[next] == 0) {
                        queue.add(next);
                    }
                }
            }
        }
        
        return count == n ? list : new ArrayList();
    }
}

/*
    nodeToGroup
    0 -> 2
    1 -> 3
    2 -> 1
    3 -> 0
    4 -> 0
    5 -> 1
    6 -> 0
    7 -> 4

    groupToNode
    2 -> [0]
    3 -> [1]
    1 -> [2,5]
    0 -> [3,4,6]
    4 -> 7
    
    itemDependency
    6 -> [1,3,4]
    5 -> [2]
    3 -> [4]
    
    groupDependency
    0 -> [3]
    
    indegree group: [0,0,0,1,0]
    // order: 0, 1, 2, 4, 3
    
    // indegree item: [0,1,1,1,2,0,0]
    // order: 0, 5, 6, 2, 3, 5

*/