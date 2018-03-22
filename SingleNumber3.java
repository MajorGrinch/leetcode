class Solution {
    public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int count = 0;
        for(int key : map.keySet()){
            if(map.get(key) == 1){
                if(count == 0){
                    ans[0] = key;
                    count++;
                }else{
                    ans[1] = key;
                    break;
                }
            }
        }
        return ans;
    }
}
class ASolution{
    public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        int temp = 0;
        for(int num : nums){
            temp ^= num;
        }
        temp &= -temp; // get the rightmost set bit
        for(int num : nums){
            if((num & temp) == 0){
                ans[0] ^= num;
            }else{
                ans[1] ^= num; 
            }
        }
        return ans;
    }
}