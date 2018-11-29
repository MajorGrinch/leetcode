import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new LinkedList<>();
        ans.add(1);
        if(rowIndex == 0) return ans;
        for(int r = 1; r <= rowIndex; r++){
            int size = ans.size();
            ans.add(ans.get(0));
            for(int i = 0; i < size-1; i++){
                ans.add(ans.get(0) + ans.get(1));
                ans.remove(0);
            }
            ans.add(1);
            ans.remove(0);
        }
        return ans;
    }
}

public class PascalTriangle{
    public static void main(String[] args) {
        Solution s= new Solution();
        System.out.println(s.getRow(6));
    }
}