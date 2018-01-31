public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encodedStr = new StringBuilder();
        for(String str : strs){
            for(char c: str.toCharArray()){
                if(c == ':'){
                    encodedStr.append("::");
                }else{
                    encodedStr.append(c);
                }
            }
            encodedStr.append(":;");
        }
        return encodedStr.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> decodedStrs = new ArrayList<>();
        char[] sc = s.toCharArray();
        StringBuilder str = new StringBuilder();
        int i = 0; //index
        while(i < s.length()){
            if(sc[i] == ':'){
                if(sc[i+1] == ':'){
                    str.append(':');
                }else{
                    decodedStrs.add(str.toString());
                    str = new StringBuilder();
                }
                i += 2;
            }else{
                str.append(sc[i]);
                i++;
            }
        }
        return decodedStrs;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));