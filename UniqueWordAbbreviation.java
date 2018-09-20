import java.util.HashMap;

class ValidWordAbbr {
    Map<String, Integer> cmap = new HashMap<>();
    Map<String, Integer> abmap = new HashMap<>();
    public ValidWordAbbr(String[] dictionary) {
        for(String word : dictionary){
            String abbr = getAbbr(word);
            cmap.put(word, cmap.getOrDefault(word, 0)+1);
            abmap.put(abbr, abmap.getOrDefault(abbr, 0)+1);
        }
    }
    
    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        return cmap.getOrDefault(word, 0) == abmap.getOrDefault(abbr, 0);
    }
    String getAbbr(String s){
        if(s.length() < 3){
            return s;
        }
        String res = s.substring(0, 1) + (s.length() - 2) + s.charAt(s.length()-1);
        return res;
    }
}

class ValidWordAbbr2 {
    HashMap<String, Integer> count_word = new HashMap<>();
    HashMap<String, Integer> count_abbr = new HashMap<>();
    public ValidWordAbbr2(String[] dictionary) {
        for(String word : dictionary){
            count_word.put(word, count_word.getOrDefault(word, 0)+1);
            String abbr = getAbbr(word);
            count_abbr.put(abbr, count_abbr.getOrDefault(abbr, 0)+1);
        }
    }
    
    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        return count_word.getOrDefault(word, 0) == count_abbr.getOrDefault(abbr, 0);
    }
    public String getAbbr(String s){
        if(s.length() < 3) return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        sb.append(s.length() - 2);
        sb.append(s.charAt(s.length()-1));
        return sb.toString();
    }
}

public class UniqueWordAbbreviation{
    public static void main(String[] args) {
        String[] dict = {"deer","door","cake","card"};
        ValidWordAbbr2 vwa = new ValidWordAbbr2(dict);
        String[] test = {"dear", "cart", "cane", "make"};
        for(String t : test){
            System.out.println(vwa.getAbbr(t));
            System.out.println(vwa.isUnique(t));
        }
    }
}