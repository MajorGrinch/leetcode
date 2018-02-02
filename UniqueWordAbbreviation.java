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

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */