package _05_数组_哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode-cn.com/problems/two-sum/
 *
 * @author guizy
 * @date 2021/1/14 21:56
 */
@SuppressWarnings("all")
public class _01_两数之和 {
    public static void main(String[] args) {
        /*
            暴力枚举过程: target = 26的情况

                        索引 : 0  1  2  3
                              2  7 11  15

                       当索引 i = 0, j = 1的情况
                       i = 2, j = 7     ==> 9
                       i = 2, j = 11    ==> 13
                       i = 2, j = 15    ==> 17

                      当索引 i = 1, j = 2的情况
                      i = 7, j = 11
                      i = 7, j = 15

                      当索引 i = 2, j = 3的情况
                      i = 11, j = 15    ===> 26, 返回下标为 2, 3

                      所以i=2即可, 所以第一层for循环只需要到len-1即可
         */
        int[] arr = twoSum2(new int[]{2, 7, 11, 15}, 26);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /**
     * 使用哈希表的方式来解决
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> hashtable = new HashMap<>();
        hashtable.put(nums[0], 0);
        for (int i = 1; i < len; i++) {
            /*
                因为target = nums[i] + nums[xxx]; 将数组元素都添加到哈希表了;
                此时通过target-nums[i]来看看是否存在一个nums[xxx], 如果存在则表明该nums[xxx] + nums[i] = target,
                说明数组中存在这样的元素
             */
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }

        // 这种做法效率偏低
        // 首先将数组中所有元素都添加到哈希表中, 哈希表的桶存储的是一个Map<Integer, Integer>, key为元素值 value为元素下标
        /*for (int i = 0; i < len; i++) {
            hashtable.put(nums[i], i);
        }
        for (int i = 0; i < len; i++) {
            if (hashtable.containsKey(target - nums[i]) && hashtable.get(target - nums[i]) != i) {
                return new int[]{i, hashtable.get(target - nums[i])};
            }
        }*/
        throw new IllegalArgumentException("数组中没有组成和为target的和数!");
    }

    /**
     * 方法一: 暴力枚举方式, 列举出所有的情况
     *
     * @param nums   无序数组
     * @param target 两数的和为target
     * @return 返回这两个数的索引
     */
    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        // 首先遍历出数组中所有的元素
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        throw new IllegalArgumentException("数组中没有组成和为target的和数!");
    }
}
