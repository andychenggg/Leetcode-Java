import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int []> res = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(e -> e[0]));
        
        for (int i = 0; i < intervals.length; i++) {
            int [] cur = intervals[i];
            while(++i < intervals.length){
                if (intervals[i][0] <= cur[1]){
                    cur[1] = Math.max(intervals[i][1], cur[1]);
                }
                else {
                    
                    i--;
                    break;
                }
            }
            res.add(cur);
        }
        int [][] resArr = new int[res.size()][];
        for (int i = 0; i < resArr.length; i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }
}