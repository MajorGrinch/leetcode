/**
 * optimized iterative
 */
class Solution {
    public int scheduleCourse(int[][] courses) {
        int currTime = 0, count = 0;
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        for(int i = 0; i < courses.length; i++){
            if(currTime + courses[i][0] <= courses[i][1]){
                currTime += courses[i][0];
                courses[count++] = courses[i];
            }else{
                int max_dur = i;
                for(int j = 0; j < count; j++){
                    if(courses[j][0] > courses[max_dur][0]){
                        max_dur = j;
                    }
                }
                if(courses[max_dur][0] > courses[i][0]){
                    currTime += courses[i][0] - courses[max_dur][0];
                    courses[max_dur] = courses[i];
                }
            }
        }
        return count;
    }
}
/**
 * priority queue
 */
class Solution {
    public int scheduleCourse(int[][] courses) {
        int currTime = 0, count = 0;
        Arrays.sort(courses, (a, b) -> a[1]-b[1] );
        PriorityQueue<Integer> pqc = new PriorityQueue<>((a,b) -> b-a);
        for(int[] course : courses){
            if(currTime + course[0] <= course[1]){
                currTime += course[0];
                pqc.offer(course[0]);
            }else{
                if(!pqc.isEmpty() && pqc.peek() > course[0]){
                    currTime += course[0] - pqc.poll();
                    pqc.offer(course[0]);
                }
            }
        }
        return pqc.size();
    }
}