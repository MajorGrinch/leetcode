class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskCnt = new int[26];
        for(char c : tasks){
            taskCnt[c-'A']++;
        }
        Arrays.sort(taskCnt);
        int maxTcnt = taskCnt[25], idleSlots = (maxTcnt-1) * n;
        for(int i = 24; i >= 0 && taskCnt[i] > 0; i--){
            idleSlots -= Math.min(maxTcnt-1, taskCnt[i]);
        }
        return idleSlots < 0 ?  tasks.length : idleSlots + tasks.length;
    }
}