import java.util.PriorityQueue;
import java.util.Collections;
import java.util.List;;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskCnt = new int[26];
        for (char c : tasks) {
            taskCnt[c - 'A']++;
        }
        Arrays.sort(taskCnt);
        int maxTcnt = taskCnt[25], idleSlots = (maxTcnt - 1) * n;
        for (int i = 24; i >= 0 && taskCnt[i] > 0; i--) {
            idleSlots -= Math.min(maxTcnt - 1, taskCnt[i]);
        }
        return idleSlots < 0 ? tasks.length : idleSlots + tasks.length;
    }
}

class Solution2 {
    public int leastInterval(char[] tasks, int n) {
        int[] taskCnt = new int[26];
        for (char c : tasks) {
            taskCnt[c - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(26, Collections.reverseOrder());
        for (int cnt : taskCnt) {
            if (cnt > 0) {
                pq.offer(cnt);
            }
        }
        int time = 0;
        while (!pq.isEmpty()) {
            int i = 0;
            List<Integer> exec = new ArrayList<>();
            while (i <= n) {
                if(!pq.isEmpty()){
                    exec.add(pq.poll() - 1);
                }
                time++;
                if(pq.isEmpty() && exec.get(0) == 0) break;
                i++;
            }
            for(int cnt : exec){
                if(cnt > 0)
                    pq.offer(cnt);
            }
        }
        return time;
    }
}