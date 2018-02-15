class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if(len == 0){
            return 0;
        }
        int[] f = new int[len+1];
        char[] sc = s.toCharArray();
        f[0] = 1;
        for(int i = 1; i < f.length; i++){
            if(sc[i-1] != '0'){
                f[i] += f[i-1];
            }
            if(i >= 2){
                int temp = 10 * (sc[i-2] - '0') + sc[i-1] - '0';
                if(temp >= 10 && temp <= 26){
                    f[i] += f[i-2];
                }
            }
        }
        return f[len];
    }
}