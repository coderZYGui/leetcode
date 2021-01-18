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

    }

    /*
        使用双指针
     */
    public int[] twoSum3(int[] numbers, int target) {

        return null;
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
