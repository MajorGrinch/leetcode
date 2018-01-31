/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    char[] buffer = new char[4];
    int head = 0, rear = 0;
    public int read(char[] buf, int n) {
        int i = 0;
        while(i < n){
            if(head == rear){
                head = 0;
                rear = read4(buffer);
                if(rear == 0){
                    return i;
                }
            }
    
            while(i < n && head < rear){
                buf[i++] = buffer[head++];
            }
        }
        return i;
    }
}