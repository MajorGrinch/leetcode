import java.util.Arrays;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length(), maxL = 1, j = 0;
        if (len == 0 || len == 1) {
            return len;
        }
        int[] count = new int[256];
        char[] sc = s.toCharArray();
        for (int i = 0; i < len; i++) {
            while (j < len && count[sc[j]] == 0) {
                count[sc[j]] = 1;
                j++;
            }
            maxL = Math.max(maxL, j - i);
            count[sc[i]] = 0;
        }
        return maxL;
    }

    public int lengthOfLongestSubstring2(String s) {
        int[] idxMap = new int[256];
        Arrays.fill(idxMap, -1);
        int j = 0, maxL = 1;
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            if (idxMap[sc[i]] >= j) {
                j = idxMap[sc[i]] + 1;
            }
            idxMap[sc[i]] = i;
            maxL = Math.max(maxL, i - j + 1);
        }
        return maxL;
    }
}

public class LongestSubstrWithoutRepeatingChar {
    public static void main(String[] args) {
        String input = "abcadfga";
        System.out.println(new Solution().lengthOfLongestSubstring2(input));
    }
}