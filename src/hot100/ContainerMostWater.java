package hot100;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * @author edward
 * @date 2025/3/19
 */

public class ContainerMostWater {
    public static void main(String[] args) {
        // 创建一个ContainerMostWater对象
        ContainerMostWater containerMostWater = new ContainerMostWater();
        // 定义一个数组，存储容器的高度
        int[] height = {1,8,6,2,5,4,8,3,7};
        // 输出容器中水的最大面积
        System.out.println(containerMostWater.maxArea(height));
    }
    public int maxArea(int[] height) {
        // 定义右指针
        int r = height.length - 1;
        // 定义左指针
        int l = 0;
        int high = Math.min(height[r], height[l]);//取比较短的高度
        int res = (r - l) * high;

        while(l < r){
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
            int tempRes = (r - l) * (Math.min(height[r], height[l]));
            // 更新最大面积
            if(tempRes > res){
                res = tempRes;
            }
        }
        return res;
    }
}
