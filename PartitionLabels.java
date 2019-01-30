class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] lastOccr = new int[26];
        for(int i = 0; i < S.length(); i++){
            lastOccr[S.charAt(i)-'a'] = i;
        }
        int st = 0, ed = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < S.length(); i++){
            ed = Math.max(ed, lastOccr[S.charAt(i) - 'a']);
            if(i == ed){
                ans.add(ed - st + 1);
                st = ed + 1;
            }
        }
        return ans;
    }
}