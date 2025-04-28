package hot100;

/**
 * 除自身成外的乘积数组
 *
 * @author edawrd
 * @version 1.0
 * @date 2025-04-28
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums){
        //ans = 前缀积 * 后缀积
        int[] ans = new int[nums.length];
        //先计算前缀积
        ans[0] = 1; //第一个数前缀积为1
        for(int i = 1; i < nums.length; i++){
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        //后缀积直接和前缀积相乘
        int right = 1; //最后一个元素的后缀积为1
        for(int i = nums.length - 1; i >= 0; i--){
            ans[i] = ans[i] * right;
            right = right * nums[i]; //更新后缀积
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {-1,1,0,-3,3};
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();
        int[] ans = productExceptSelf.productExceptSelf(nums);
        for(int i = 0; i < ans.length; i++){
            //每个元素逗号间隔打印
            System.out.print(ans[i] + ",");

        }
    }

}
