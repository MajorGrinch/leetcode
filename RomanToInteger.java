class Solution {
    public int romanToInt(String s) {
        // write your code here
        char[] sc = s.toCharArray();
        if(sc.length == 1){
            return toInt(sc[0]);
        }
        int sum = 0;
        for(int i = sc.length-1; i > 0; i--){
            sum += toInt(sc[i]);
            if(toInt(sc[i-1]) < toInt(sc[i])){
                sum -= toInt(sc[i-1]);
                i--;
            }
        }
        if(toInt(sc[0]) >= toInt(sc[1])){
            sum += toInt(sc[0]);
        }
        return sum;
    }
    public int toInt(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}