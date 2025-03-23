package hot100;

import java.net.InetAddress;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 矩阵置零
 */
public class SetZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        // 打印原始矩阵
        System.out.println("Before:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        // 调用方法
        SetZeroes solution = new SetZeroes();
        solution.setZeroes(matrix);

        // 打印结果
        System.out.println("After:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

    }
    public void setZeroes(int[][] matrix) {
        //定义两个set存储需要置零的行和列
        Set<Integer> row = new HashSet<>();
        Set<Integer> column = new HashSet<>();

        //遍历二维数组，找到0的坐标
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                   //收集坐标
                    row.add(j);
                    column.add(i);
                }
            }
        }
        //对收集到的元素置零
        for(Integer rowNum : row){
            for(int c = 0; c < matrix.length; c++){
                matrix[c][rowNum] = 0;
            }
        }
        for(Integer columnNum : column){
            Arrays.fill(matrix[columnNum], 0);
        }
    }
}
