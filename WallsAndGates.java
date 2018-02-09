class Solution {
    public void wallsAndGates(int[][] rooms) {
        int inf = Integer.MAX_VALUE;
        int m = rooms.length; //rows
        if( m == 0){
            return;
        }
        int n = rooms[0].length;  //cols
        if(n == 0){
            return;
        }
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rooms[i][j] == 0){
                    qx.offer(i);
                    qy.offer(j);
                }
            }
        }
        while(!qx.isEmpty()){
            int x = qx.poll();
            int y = qy.poll();
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if( nx >= 0 && nx < m && ny >=0 && ny < n && rooms[nx][ny] == inf){
                    rooms[nx][ny] = rooms[x][y] + 1;
                    qx.offer(nx);
                    qy.offer(ny);
                }
            }
        }
    }
}