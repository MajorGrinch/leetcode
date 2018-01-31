class Solution {
    public int lengthLongestPath(String input) {
        if(input.length() == 0){
            return 0;
        }
        int ans = 0;
        int[] level_size = new int[input.length()+1];
        int lpath = 0;
        for(String line: input.split("\n")){
            int level = line.lastIndexOf('\t') + 2;
            
            if(line.lastIndexOf('.') != -1){
                level_size[level] = line.replace("\t", "").length();
                int tmp = 0;
                for(int i = 1; i <= level; i++){
                    tmp += level_size[i];
                }
                tmp += level - 1;
                if(lpath < tmp ){
                    lpath = tmp;
                }
            }else{
                level_size[level] = line.replace("\t", "").length();
            }
        }
        return lpath;   
    }
}