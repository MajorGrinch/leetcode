class Solution {
    public String reverseVowels(String s) {
        char[] sc = s.toCharArray();
        int i = 0, j = sc.length-1;
        while(i < j){
            while(i < j && !isVowel(sc[i])) i++;
            while(i < j && !isVowel(sc[j])) j--;
            // System.out.printf("i = %d, j = %d\n", i, j);
            // if(i >= j) break;
            char tmp = sc[i];
            sc[i] = sc[j];
            sc[j] = tmp;
            i++;
            j--;
        }
        return new String(sc);
    }

    private boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' 
           || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') return true;
        return false;
    }
}