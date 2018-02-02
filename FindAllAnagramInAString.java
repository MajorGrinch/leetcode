class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<Integer>();
        if(s.length() < p.length()){
            return ans;
        }
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        
        int[] cntS = new int[256];
        int[] cntP = new int[256];
        int[] det = new int[256];
        int absSum = 0;
        for(int i = 0; i < p.length(); i++){
            cntS[sc[i]]++;
            cntP[pc[i]]++;
        }
        for(int i = 97; i < 123; i++){
            det[i] = cntS[i] - cntP[i];
            absSum += Math.abs(det[i]);
        }
        if(absSum == 0){
            ans.add(0);
        }
        for(int i = 1; i < s.length() - p.length()+1; i++){
            int r = sc[i+p.length()-1];
            int l = sc[i-1];
            absSum -= (Math.abs(det[r]) + Math.abs(det[l]));
            det[r]++;
            det[l]--;
            absSum += (Math.abs(det[r]) + Math.abs(det[l]));
            if(absSum == 0){
                ans.add(i);
            }
        }
        return ans;
    }
}