/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        int n = intervals.size();
        if(n <= 1){
            return true;
        }
        Collections.sort(intervals, (a, b) -> Integer.compare(a.end, b.end));
        int freeTime = intervals.get(0).end;
        for(int  i = 1; i < n; i++){
            if(!(freeTime <= intervals.get(i).start)){
                return false;
            }else{
                freeTime = intervals.get(i).end;
            }
        }
        return true;

    }
}
