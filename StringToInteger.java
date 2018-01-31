class Solution {
    public int myAtoi(String str) {
        if( str.length() == 0){
            return 0;
        }
        str = str.trim() + " ";
        char[] sc = str.toCharArray();
        int len = sc.length;
        int nPoint = 0, nFlag = 0;
        for(int i = 0; i < len; i++){
            if(sc[i] == '.'){
                nPoint++;
            }
            if(sc[i] == '+' || sc[i] == '-'){
                nFlag++;
            }
        }
        if(nPoint > 1 || nFlag > 1){
            return 0;
        }
        char flag = '+';
        double sum = 0;
        int i = 0;
        if(sc[i] == '-'){
            flag = '-';
            i++;
        }
        if(sc[i] == '+'){
            i++;
        }
        while(i < len && Character.isDigit(sc[i])){
            sum = sum*10 + (sc[i] - '0');
            i++;
        }
        if(flag == '-'){
            sum = -sum;
        }
        if(sum > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(sum < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)sum;       
    }
}