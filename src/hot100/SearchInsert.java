package hot100;

import java.io.Serializable;

/**
 * @author edward
 * @description 二分查找+插入
 * @date 2025/4/2
 */

public class SearchInsert {
    public static void main(String[] args){
        int[] nums = {1,3,5,6};
        int target = 2;
        SearchInsert searchInsert = new SearchInsert();
        System.out.println(searchInsert.searchInsert(nums, 2));

    }

    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2; // 每次循环重新计算 mid 通过计算偏移量的方式
            if (nums[mid] == target) {
                return mid; // 找到目标值，直接返回
            } else if (nums[mid] < target) {
                l = mid + 1; // 目标值在右半部分
            } else {
                r = mid - 1; // 目标值在左半部分
            }
        }

        return l; // l 指向插入位置
    }
}
