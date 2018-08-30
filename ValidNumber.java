class Solution {
    public boolean isNumber(String s) {
        int i = 0; //index
        int nPoint = 0, nDigit = 0;
        s = s.trim()+ " "; //remove the space
        char[] sc = s.toCharArray();
        int len = s.length()-1; //i == len if s is valid number
        
        if( sc[i] == '+' || sc[i] == '-'){
            i++;
        }
        while( Character.isDigit(sc[i]) || sc[i] == '.'){
            if(Character.isDigit(sc[i])){
                nDigit++;
            }
            if(sc[i] == '.'){
                nPoint++;
            }
            i++;
        }
        if( nDigit == 0 || nPoint > 1){
            return false;
        }
        if(sc[i] == 'e'){
            i++;
            if(sc[i] == '+' || sc[i] == '-'){
                i++;
            }
            if( i == len ){
                return false;
            }
            while( Character.isDigit(sc[i])){
                i++;
            }
        }
        return i == len;
    }
    public boolean isNumber2(String s){
        s = s.trim() + " ";
        char[] sc = s.toCharArray();
        int i = 0, len = sc.length - 1;
        int nPoints = 0, nDigits = 0;
        if(sc[i] == '+' || sc[i] == '-') i++;
        while(Character.isDigit(sc[i])){
            nDigits++;
            i++;
        }
        if(sc[i] == '.'){
            i++;
            while(Character.isDigit(sc[i])){
                i++;
                nDigits++;
            }
        }
        if(nDigits == 0) return false;
        if(sc[i] == 'e'){
            i++;
            if(sc[i] == '+' || sc[i] == '-') i++;
            if(i == len) return false;
            while(Character.isDigit(sc[i])) i++;
        }
        return i == len;
    }
}
public class ValidNumber{
    public static void main(String[] args) {
        String input = "-.7e10";
        System.out.println(new Solution().isNumber(input));
    }
}