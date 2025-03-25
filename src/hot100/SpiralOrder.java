package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author edward
 * @description 螺旋矩阵
 * @date 2025/3/25
 */

public class SpiralOrder {
    public static void main(String[] args) {
        //定义一个二维数组 [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        SpiralOrder spiralOrder = new SpiralOrder();
        List<Integer> list = spiralOrder.spiralOrder(matrix);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> retList = new ArrayList<>();
        //定义四个边界
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int left = 0;

        //循环遍历所有元素
        while(top <= bottom && right >= left){
            //遍历top
            for(int i = left;i <= right; i++){
                retList.add(matrix[top][i]);
            }
            top++;
            //后续遍历之前先检查一下是否已经越界！
            if(top <= bottom){
                //遍历right
                for(int i = top; i <= bottom; i++){
                    retList.add(matrix[i][right]);
                }
                right--;
            }
            if(bottom >= top){
                //遍历bottom
                for(int i = right; i >= left; i--){
                    retList.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if(left <= right){
                //遍历left
                for(int i = bottom; i >= top; i--){
                    retList.add(matrix[i][left]);
                }
                left++;
            }

        }
        return retList;
    }
}
