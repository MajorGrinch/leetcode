class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        int block = 2 * numRows - 2;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < numRows; i++){
            for(int j = i; j < s.length();j += block){
                sb.append(s.charAt(j));
                if(i != 0 && i != numRows-1 && j+2*(numRows-1-i) < s.length()){
                    sb.append(s.charAt(j+2*(numRows-1-i)));
                }
            }
        }
        return sb.toString();
    }
}
public class ZigzagConversion{
    public static void main(String[] args) {
        String input = "PAYPALISHIRING";
        System.out.println(new Solution().convert(input, 3));
    }
}