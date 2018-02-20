import java.util.*;

public class FindKClosestElements{
    public static void main(String[] args) {
       int[] arr = {0,0,0,1,3,5,6,7,8,8};
       Solution slu = new Solution();
       List ans = slu.findClosestElements(arr, 2, 2);
       System.out.println(ans.toString()); 
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int len = arr.length;
        List<Integer> ans = new ArrayList<>();
        if(x <= arr[0]){
            for(int i = 0; i < k; i++){
                ans.add(arr[i]);
            }
            return ans;
        }
        if(x >= arr[len-1]){
            for(int i = len-k; i < len; i++){
                ans.add(arr[i]);
            }
            return ans;
        }
        int l = 0, r = len-1;
        int idx = 0;
        while(r-l > 1){
            int mid = l + (r-l)/2;
            if(arr[mid] == x){
                idx = mid;
                break;
            }
            if(arr[mid] < x){
                l = mid;
            }else{
                r = mid;
            }
        }
        if(idx == 0){
            if(arr[l] >= x){
                idx = l;
            }else{
                idx = r;
            }
        }
        System.out.println(idx);
        int low = Math.max(0, idx-k), high = Math.min(len-1, idx+k-1);
        System.out.println(low + " " + high);
        while(high - low >= k){
            if(x - arr[low] > arr[high] - x){
                low++;
            }else{
                high--;
            }
        }
        for(int i = low; i <= high; i++){
            ans.add(arr[i]);
        }
        return ans;
    }
}