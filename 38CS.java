class Solution {
    public String countAndSay(int n) {
        String num = "1";
        for(int i = 1; i < n; i++){
            num = getNext(num);
        }
        return num;
    }

    private String getNext(String num){
        StringBuilder nxtNumStr = new StringBuilder();
        char prev = num.charAt(0);
        int st = 0, ed = 0;
        for(ed = 0; ed <= num.length(); ed++){
            if(ed == num.length()){
                nxtNumStr.append(ed-st);
                nxtNumStr.append(prev);
            }else if(num.charAt(ed) != prev){
                nxtNumStr.append(ed-st);
                nxtNumStr.append(prev);
                prev = num.charAt(ed);
                st = ed;
            }
        }
        return nxtNumStr.toString();
    }
}