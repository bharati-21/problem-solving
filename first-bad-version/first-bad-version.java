/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        int lastBadVersion = n;
        while(start < end) {
            int mid = start + (end - start)/2;
            
            boolean isBad = isBadVersion(mid);
            if(isBad) {
                lastBadVersion = mid;
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        
        if(isBadVersion(start) && start < lastBadVersion) {
            lastBadVersion = start;
        }
        
        return lastBadVersion;
    }
}