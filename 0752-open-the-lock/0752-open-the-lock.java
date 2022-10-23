class Pair {
    String position;
    int move;
    Pair(String position, int move) {
        this.position = position;
        this.move = move;
    }
}

class Solution {
    public int openLock(String[] deadends, String target) {
        if(inDeadends(deadends, "0000")) {
            return -1;
        }
        
        
        Queue<Pair> queue = new LinkedList();
        queue.add(new Pair("0000", 0));
        Set<String> visited = new HashSet();
        visited.add("0000");
        
        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            
            String position = p.position;
            int move = p.move;
            
            if(position.equals(target)) {
                return move;
            }
            
            List<String> children = getChildren(position);
            
            for(String child: children) {
                if(visited.contains(child) || inDeadends(deadends, child)) {
                    continue;
                }
                
                Pair childPair = new Pair(child, move+1);
                queue.add(childPair);
                visited.add(child);
            }
        }
        
        
        return -1;
    }
    
    private List<String> getChildren(String position) {
        List<String> list = new ArrayList();
        for(int i = 0; i<4; i++) {
            StringBuilder b = new StringBuilder(position);
            int pos = (int)(b.charAt(i) - '0');
            pos = (pos + 1) % 10;
            b.setCharAt(i, (char)(pos + '0'));
            list.add(b.toString());
        }
        
        for(int i = 0; i<4; i++) {
            StringBuilder b = new StringBuilder(position);
            int pos = (int)(b.charAt(i) - '0');
            pos = ((pos - 1) + 10) % 10;
            b.setCharAt(i, (char)(pos + '0'));
            list.add(b.toString());
        }
        
        return list;
    }
    
    private boolean inDeadends(String[] deadends, String position) {
        for(String end: deadends) {
            if(end.equals(position)) {
                return true;
            }
        }
        
        return false;
    }
}