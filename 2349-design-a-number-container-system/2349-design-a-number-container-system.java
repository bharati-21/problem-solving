class NumberContainers {
    Map<Integer, Integer> indexToNum;
    Map<Integer, TreeSet<Integer>> numToIndex;
    
    public NumberContainers() {
        indexToNum = new HashMap();
        numToIndex = new HashMap();
    }
    
    public void change(int index, int number) {
        if(indexToNum.containsKey(index)) {
            int num = indexToNum.get(index);
            numToIndex.get(num).remove(index);
        }
        indexToNum.put(index, number);
        if(!numToIndex.containsKey(number)) {
            numToIndex.put(number, new TreeSet());
        }
        numToIndex.get(number).add(index);
    }
    
    public int find(int number) {
        if(!numToIndex.containsKey(number)) return -1;
        TreeSet<Integer> indices = numToIndex.get(number);
        if(indices.isEmpty()) return -1;
        return indices.first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */

/*
index -> number

number -> index
10 -> 2
10 -> 1, 2
10 -> 1, 2, 3

*/