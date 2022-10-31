class ListNode {
    int key, val;
    ListNode prev, next;
    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    int capacity;
    HashMap<Integer, ListNode> map;
    ListNode root, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap();
        this.root = null;
        this.tail = null;
    }
    
    
    private void remove(ListNode node) {
        if(node == root) {
            root = root.next;
            if(root != null) root.prev = null;
        }
        else if(node == tail) {
            tail = tail.prev;
            tail.next = null;
        }
        else {
            ListNode prevNode = node.prev;
            ListNode nextNode = node.next;
            if(prevNode != null) prevNode.next = nextNode;
            if(nextNode != null) nextNode.prev = prevNode;
        }
    }
    
    private void insert(ListNode node) {
        if(root == null) {
            root = node;
            tail = node;
            return;
        }
        ListNode prevNode = tail;
        node.prev = prevNode;
        prevNode.next = node;
        tail = node;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        ListNode node = map.get(key);
        int val = node.val;
        remove(node);
        insert(node);
        return val;
    }
    
    public void put(int key, int value) {
        ListNode node = new ListNode(key, value);
        if(map.containsKey(key)) {
            node = map.get(key);
            remove(node);
        }
        
        node.val = value;
        map.put(key, node);
        insert(node);
        
        if(capacity < map.size()) {
            ListNode lru = root;
            remove(lru);
            map.remove(lru.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/*
[{1,1},{2,2}]
[{2,2},{1,1}]
*/