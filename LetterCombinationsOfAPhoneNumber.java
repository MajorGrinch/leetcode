class Solution {
    List<String> ans = new ArrayList<>();
    String[] panel = {"", "", "abc", "def", "ghi", 
        "jkl", "mno", "pqrs", "tuv", "wxyz"};
    String digits;
    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        int maxD = digits.length();
        if(maxD == 0){
            return ans;
        }
        dfs("", 0, maxD);
        return ans;  
    }
    void dfs(String str, int d, int maxD){
        if(d == maxD){
            ans.add(str);
            return;
        }
        int idx = digits.charAt(d) - '0';
        for(char c : panel[idx].toCharArray()){
            dfs(str+c, d+1, maxD);
        }
    }
}