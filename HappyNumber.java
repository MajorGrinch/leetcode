class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hset = new HashSet<>();
        while(n != 1){
            if(hset.contains(n)){
                return false;
            }
            hset.add(n);
            n = getNextNum(n);
        }
        return true;
    }
    int getNextNum(int x){
        int sum = 0;
        while(x > 0){
            sum += (x%10) * (x%10);
            x /= 10;
        }
        return sum;
    }
}