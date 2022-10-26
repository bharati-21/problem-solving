class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = queries.size();
        double[] result = new double[n];
        
        Map<String, Map<String, Double>> graph = buildGraph(equations, values); 
        
        for(int i = 0; i<n; i++) {
            List<String> query = queries.get(i);
            String u = query.get(0);
            String v = query.get(1);
            
            if(!graph.containsKey(u) || !graph.containsKey(v)) {
                result[i] = (double) -1;
                continue;
            }
            result[i] = dfs(u, v, graph, new HashSet());
        }
        
        return result;
    }
    
    private double dfs(String src, String dest, Map<String, Map<String, Double>> graph, Set<String> visited) {
        if(!graph.containsKey(src)) {
            return (double)-1;
        }
        
        if(graph.get(src).containsKey(dest)) {
            return graph.get(src).get(dest);
        }
        
        double result = 1;
        visited.add(src);
        Map<String, Double> neighbors = graph.get(src);
        
        for(String key: neighbors.keySet()) {
            if(visited.contains(key)) {
                continue;
            }
            
            double neighborResult = dfs(key, dest, graph, visited);
            if(neighborResult == -1) {
                continue;
            }
            return neighborResult * neighbors.get(key);
        }
            
        return -1;
    }
    
    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> map = new HashMap();
        for(int i = 0; i<equations.size(); i++) {
            List<String> equation = equations.get(i);
            String u = equation.get(0), v = equation.get(1);
            
            if(!map.containsKey(u)) {
                map.put(u, new HashMap());
            }
            map.get(u).put(v, values[i]);
            if(!map.containsKey(v)) {
                map.put(v, new HashMap());
            }
            
            map.get(v).put(u, 1/values[i]);
        }
        
        return map;
    }
}