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
        for(int i = 1; i <= s.length(); i++){
            String s1 = s.substring(0, i);
            String s2 = s.substring(i);
            if(dict.contains(s1)){
                List<String> s2_split = splitStr(s2);
                for(String str : s2_split){
                    if(str == ""){
                        s_split.add(s1);
                    }else{
                        s_split.add(s1+" "+str);
                    }
                }
            }
        }
        splited.put(s, s_split);
        return s_split;
    }
}