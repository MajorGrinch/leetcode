/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        int l = 1, r = n;
        while(r-l > 1){
            int mid = l + (r-l)/2;
            if(isBadVersion(mid)){
                r = mid;
            }else{
                l = mid;
            }
        }
        if(isBadVersion(l)){
            return l;
        }
        return r;    
    }
}