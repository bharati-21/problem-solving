[10,16],[2,8],[1,6],[7,12]
[1,6],[2,8],[7,12],[10,16]
[2,6],[10,12]
​
[[1,2],[3,4],[5,6],[7,8]]
​
​
[[1,2],[2,3],[3,4],[4,5]]
​
// Sort all the points by their start
// Then check if points overlap
// If they overlap, then merge such that: [max(x1,x2), min(y1,y2)]
// This is to ensure that we cover only the overlapping area and know the common coorindates to drop arrow
// use Integer.compare() to avoid overflow issues