package byc.imagewatcher.demo;

import java.util.HashMap;
import java.util.Map;

class 两数之和 {
    public int[] twoSum(int[] nums, int target) {
        int size = nums.length;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < size; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        throw new IllegalArgumentException("not found");
    }
}
