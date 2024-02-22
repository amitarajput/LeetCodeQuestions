import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution{
    public int[][] merge(int[][] intervals){
        List<int[]> res = new ArrayList<>();
        if(intervals==null || intervals.length==0)
            return res.toArray(new int[0][]);
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);// sorting done TC O(nlogn)n = number of intervals
//subtract b[0] - a[0] sort interval ascending order
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int[] i : intervals){
            if(i[0] <= end){
                end = Math.max(end,i[1]);
            }else{
                res.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }

        }
        res.add(new int[]{start, end});
        return res.toArray(new int[0][]);
    }
}

public class MergeIntervals56 {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
            Solution s1 = new Solution();
            int[][] mergedIntervals = s1.merge(intervals);
            System.out.println(Arrays.deepToString(mergedIntervals));
        }

    }
