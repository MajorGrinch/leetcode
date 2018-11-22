import java.util.ArrayList;
import java.util.Comparator;
import java.util.*;

class Solution {
    int[] zero = new int[]{0, 0};
    public int[][] reconstructQueue(int[][] people) {
        if(people.length == 0) return people;
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] man1, int[] man2){
                if(man1[0] != man2[0]){
                    return man2[0] - man1[0];
                }else{
                    return man1[1] - man2[1];
                }
            }
        } );
        int[][] ans = new int[people.length][people[0].length];
        for(int[] man : people){
            insert2Index(ans, man, man[1]);
        }
        return ans;
    }
    private void insert2Index(int[][] ans, int[] man, int index){
        if(isEmptyEntry(ans, index)){
            ans[index] = man;
            return;
        }
        int clusterEd = index;
        while(!isEmptyEntry(ans, ++clusterEd));
        for(int i = clusterEd; i > index; i--){
            ans[i] = ans[i-1];
        }
        ans[index] = man;
    }
    private boolean isEmptyEntry(int[][] ans, int index){
        if(ans[index][0] == 0 && ans[index][1] == 0){
            return true;
        }
        return false;
    }
}

public class QueueReconstructionByHeight{
    public static void main(String[] args) {
        int[] zero = new int[]{0,0};
        System.out.println(zero.equals(new int[]{0,0}));
    }
}