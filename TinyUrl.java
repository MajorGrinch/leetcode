import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Codec {
    Map<Integer, String> urlMap = new HashMap<>();
    int i = 0;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        urlMap.put(i, longUrl);
        return "http://tinyurl.com/" + i++;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return urlMap.get(Integer.parseInt(shortUrl.substring(19)));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));

class Codec2{
    Map<String, String> urlMap = new HashMap<>();
    String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random rand = new Random();
    String key = getKey();

    public String getKey(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 6; i++){
            sb.append(alphabet.charAt(rand.nextInt(62)));
        }
        return sb.toString();
    }
    public String encode(String longUrl) {
        while(urlMap.containsKey(key)){
            key = getKey();
        }
        urlMap.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return urlMap.get(shortUrl.substring(19));
    }
}