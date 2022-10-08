class Pair {
    int key, value;
    Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class MyHashMap {
    private static final int BUCKETS = (int) 1e3;
    private static final int VALUE = (int) 1e3;
    ArrayList<Pair>[] myMap;
    
    public MyHashMap() {
        myMap = new ArrayList[BUCKETS];
    }
    
    public void put(int key, int value) {
        int mapIndex = getIndexFromHash(key);
        if(myMap[mapIndex] == null) {
            myMap[mapIndex] = new ArrayList<>();
        }
        
        int keyIndex = getKeyIndex(key, mapIndex);
        if(keyIndex != -1) {
            myMap[mapIndex].set(keyIndex, new Pair(key, value));
            return;
        }
        myMap[mapIndex].add(new Pair(key, value));
    }
    
    public int get(int key) {
        int mapIndex = getIndexFromHash(key);
        int keyIndex = getKeyIndex(key, mapIndex);
        if(keyIndex == -1) {
            return -1;
        }
        Pair p = myMap[mapIndex].get(keyIndex);
        return p.value;
    }
    
    public void remove(int key) {
        int mapIndex = getIndexFromHash(key);
        int keyIndex = getKeyIndex(key, mapIndex);
        if(keyIndex == -1) {
            return;
        }
        myMap[mapIndex].remove(keyIndex);
    }
    
    private int getIndexFromHash(int key) {
        return key % VALUE;
    }
    
    private int getKeyIndex(int key, int mapIndex) {
        ArrayList<Pair> list = myMap[mapIndex];
        if(list == null) {
            return -1;
        }
        for(int i = 0; i<list.size(); i++) {
            Pair p = list.get(i);
            if(p.key == key) {
                return i;
            }
        }
        
        return -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */