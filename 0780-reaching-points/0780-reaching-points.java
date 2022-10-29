class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(sx <= tx && sy <= ty) {
            if(sx == tx) {
                // ty = (sy + n * sx)
                // (ty - sy) = (n * sx)
                if((ty - sy) % sx == 0) {
                    return true;
                }
                else {
                    return false;
                }
            }
            if(sy == ty) {
                // tx = (sx + n * sy)
                // (tx - sx) % sy
                if((tx - sx) % sy == 0) {
                    return true;
                }
                else {
                    return false;
                }
            }
            if(tx < ty) {
                ty %= tx;
            }
            else {
                tx %= ty;
            }
        }
        
        return false;
    }
}

/*
(1,1) -> (1, 2) or (2,1)
(1,2) -> (1,3) or (3,1)
(2,1) -> (2,3) or (3,1)


(1,1) -> (1,2) or (2,1)
         (1,2) -> (1,3) or (3,2)
                  (1,3) -> (1,4) or (4,3)
                           (1,4) -> (1,5) or (5,4)
                                    (1,5) -> (1,6) or (6,5) => false
                                    (5,4) -> false
                           (4,3) -> 4 > 3 => false
                  (3,2) -> (3,5) or (5,2)
                           (5,2) -> false
         (2,1) -> (3,1) or (2,3)
                  (3,4) -> ()
                  
                  if(sx == tx && sy == ty) {
            return true;
        }
        
        if(sx > tx || sy > ty) {
            return false;
        }
        
        int sum = sx + sy;
        boolean increaseX = reachingPoints(sum, sy, tx, ty);
        boolean increaseY = reachingPoints(sx, sum, tx, ty);
        
        return increaseX || increaseY;
                  
*/