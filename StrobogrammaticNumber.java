class Solution {
    public boolean isStrobogrammatic(String num) {
        int[] numMap = new int[256];
        numMap['0'] = '0';
        numMap['1'] = '1';
        numMap['6'] = '9';
        numMap['9'] = '6';
        numMap['8'] = '8';
        char[] sc = num.toCharArray();
        for(int i = 0; i < sc.length; i++){
            if(numMap[sc[i]] != sc[sc.length-1-i]){
                return false;
            }
        }
        return true;
    }
}