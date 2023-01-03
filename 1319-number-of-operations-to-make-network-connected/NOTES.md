}
}
components--;
}
}
class Solution {
public int makeConnected(int n, int[][] connections) {
UnionFind uf = new UnionFind(n);
for(int[] connection: connections) {
int u = connection[0], v = connection[1];
uf.union(u, v);
}
int components = uf.components;
int extraCables = uf.extraCables;
if((components-1) <= extraCables) {
return components-1;
}
return -1;
}
}
​
// if I have n disconnected components
// to connect them I need at least n-1 cables to make them connected