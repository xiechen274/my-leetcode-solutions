package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并区间
 *
 * @author edawrd
 * @version 1.0
 * @date 2025-04-27
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        //以第一个元素进行升序排序
        Arrays.sort(intervals,(a, b) -> a[0] - b[0]);
        int len = intervals.length;
        List<int[]> ret = new ArrayList<>();
        //定义初始区间
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 0; i < len; i++){
            //如果重叠就更新区间，直到不重叠的时候添加到list中
            if(intervals[i][0] <= end){
                end = Math.max(end,intervals[i][1]);//如果当前区间的开始小于等于end，说明有重叠，更新end
            }else {
                ret.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        //添加最后一个元素
        ret.add(new int[]{start,end});
        return ret.toArray(new int[ret.size()][]);
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[][] merge1 = merge.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        System.out.println(merge1);

    }
}
