class Solution {
    
    Map<String, List<String>> splited = new HashMap<>();
    List<String> dict;
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        dict = wordDict;
        splited.put("", new ArrayList());
        splited.get("").add("");
        
        return splitStr(s);
    }
    List<String> splitStr(String s){
        if(splited.containsKey(s)){
            return splited.get(s);
        }
        List<String> s_split = new ArrayList<>();
        for(String word: dict){
            if(s.startsWith(word)){
                List<String> s2_split = splitStr(s.substring(word.length));
                for(String str : s2_split){
                    if(str == ""){
                        s_split.add(word);
                    }else{
                        s_split.add(word+ " " + str);
                    }
                }
            }
        }
        splited.put(s, s_split);
        return s_split;
    }
}