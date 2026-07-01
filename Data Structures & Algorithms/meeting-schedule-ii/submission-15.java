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
    public int minMeetingRooms(List<Interval> intervals) {
        SortedMap<Integer, Integer> map = new TreeMap<>();

        for(Interval x : intervals){
            map.put(x.start, map.getOrDefault(x.start, 0) + 1);
            map.put(x.end, map.getOrDefault(x.end, 0) - 1);
        }

        int overlaps = 0;
        int ans = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            overlaps += entry.getValue();
            if(overlaps > ans){
                ans = overlaps;
            }
        }
        return ans;

    }
}
