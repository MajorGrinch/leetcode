import java.util.HashMap;
import java.util.*;

public class TwoSum3{
    public static void main(String[] args) {
        TwoSum test = new TwoSum();
        test.add(0);
        // test.add(-1);
        // test.add(1);
        // System.out.println(test.find(4));
        System.out.println(test.find(0));
    }
}
class TwoSum {
    private Map<Integer, Integer> cmap;
    /** Initialize your data structure here. */
    public TwoSum() {
        cmap = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        cmap.put(number, cmap.getOrDefault(number, 0)+1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(int key : cmap.keySet()){
            int remain = value - key;
            if(remain == key){
                if(cmap.get(key) >= 2){
                    return true;
                }
            }else if(cmap.containsKey(remain)){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */