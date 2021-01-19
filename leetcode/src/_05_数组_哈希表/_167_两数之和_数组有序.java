package _05_数组_哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * @author guizy
 * @date 2021/1/14 23:09
 */
@SuppressWarnings("all")
public class _167_两数之和_数组有序 {
    public static void main(String[] args) {
        int[] nums = twoSum3(new int[]{2, 7, 11, 15}, 9);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /*
        使用双指针 :
            因为是输入的是升序数组, 所以可以使用双指针解法
            两个指针, low指向最小元素, high指向最大元素
                当nums[low] + nums[high] == target, 此时就找到了[low, high]
                如果 nums[low] + nums[high] < target, 此时low++, 增大值
                如果 nums[low] + nums[high] > target, 此时high--, 减小值
     */
    public static int[] twoSum3(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                ++low;
            } else {
                --high;
            }
        }
        return new int[]{-1, -1};
    }

    /*
        使用哈希表的方式
     */
    public int[] twoSum2(int[] numbers, int target) {
        int len = numbers.length;
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (hashtable.containsKey(target - numbers[i])) {
                return new int[]{hashtable.get(target - numbers[i]) + 1, i + 1};
            }
            hashtable.put(numbers[i], i);
        }
        throw new IllegalArgumentException("数组中没有组成和为target的和数!");
    }

    /*
        暴力枚举的解法: 效率很低
     */
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{++i, ++j};
                }
            }
        }
        throw new IllegalArgumentException("数组中没有组成和为target的和数!");
    }
}
