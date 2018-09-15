import java.util.*;
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for(int key : map.keySet()){
            if(map.get(key) == 1){
                ans = key;
            }
        }
        return ans;
    }
}
class ASolution{
    public int singleNumber(int[] A) {
        int ones = 0, twos = 0;
        for(int i = 0; i < A.length; i++){
            ones = (ones ^ A[i]) & ~twos;
            twos = (twos ^ A[i]) & ~ones;
            System.out.println("i: " + i + " ones: " + ones + " twos: " + twos);
        }
        return ones;
    }
}

class Solution3{
    public int singleNumber(int[] nums){
        int ones = 0, twos = 0, threes = 0;
        for(int num : nums){
            twos |= ones & num;
            ones ^= num;
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }
}

public class SingleNumber2{
    public static void main(String[] args) {
        int[] a = {2,7, 5,22,2, 5,5,2, 7,22,22, 8, 7};
        System.out.println(new ASolution().singleNumber(a));
    }
}