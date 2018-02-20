class Solution {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        if(m == 0){
            return 0;
        }
        int n = image[0].length;
        int top = findTop(image, 0, x);
        int bottom = findBottom(image, x, m-1);
        int left = findLeft(image, 0, y);
        int right = findRight(image, y, n-1);
        return (right-left+1) * (bottom-top+1);
    }
    int findLeft(char[][] image, int start, int end){
        while(end-start > 1){
            int mid = start + (end-start)/2;
            if(isEmptyCol(image, mid)){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(isEmptyCol(image, start)){
            return end;
        }
        return start;
    }
    
    int findRight(char[][] image, int start, int end){
        while(end-start > 1){
            int mid = start + (end-start)/2;
            if(isEmptyCol(image, mid)){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(isEmptyCol(image, end)){
            return start;
        }
        return end;
    }
    
    int findTop(char[][] image, int start, int end){
        while(end-start > 1){
            int mid = start + (end-start)/2;
            if(isEmptyRow(image, mid)){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(isEmptyRow(image, start)){
            return end;
        }
        return start;
    }
    
    int findBottom(char[][] image, int start, int end){
        while(end-start > 1){
            int mid = start + (end-start)/2;
            if(isEmptyRow(image, mid)){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(isEmptyRow(image, end)){
            return start;
        }
        return end;
    }
    
    boolean isEmptyCol(char[][] image, int col){
        for(int i = 0; i < image.length; i++){
            if(image[i][col] == '1'){
                return false;
            }
        }
        return true;
    }
    boolean isEmptyRow(char[][] image, int row){
        for(int j = 0; j < image[row].length; j++){
            if(image[row][j] == '1' ){
                return false;
            }
        }
        return true;
    }
}