package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xlj 2024-12-13
 */
public class addTwoNum {
    //¹þÏ£±í
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++){
                int subSum = target - nums[i];
                if(map.containsKey(subSum)){
                    return new int[]{map.get(subSum),i};
                }
                else map.put(nums[i],i);
            }
            return null;
        }
    }
    //±©Á¦µÝ¹é
    class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return null;
        }
    }

}
