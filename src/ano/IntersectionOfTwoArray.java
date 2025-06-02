package ano;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xlj
 * @date 2025-06-02
 * @description 数组差并集
 */

public class IntersectionOfTwoArray {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {1,2,3,4,5,6,7};

        IntersectionOfTwoArray intersectionOfTwoArray = new IntersectionOfTwoArray();
        int[] ints = intersectionOfTwoArray.intersectionOfTwoArray(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }

    public int[] intersectionOfTwoArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // 记录 arr1 中元素，频率初始化为 1
        for (int i : arr1) {
            if (map.get(i) == null) {
                map.put(i, 1); // 仅记录存在
            }
        }

        for (int i : arr2) {
            if (map.get(i) != null) {
                result.add(i);
                map.remove(i);
            }
        }
        int[] retArr = result.stream().mapToInt(Integer::intValue).toArray();
        return retArr;
    }

}
