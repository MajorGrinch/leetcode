class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<Character>();
        for(char c : s.toCharArray()){
            if(set.contains(c))
                set.remove(c);
            else set.add(c);
        }
        if(set.size() == 0 || set.size() == 1){
            return true;
        }
        return false;
    }
}