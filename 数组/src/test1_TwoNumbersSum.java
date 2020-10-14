import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * @author wyd
 * @date 2020/8/31 - 21:43
 */
public class test1_TwoNumbersSum {


    //暴力解,时间复杂度是O(n²)
  /*
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
   */


    //使用HashMap，可以将时间复杂度降到O(1)。

    /**
     * HashMap是以键值对的形式进行存储的，一个key对应一个value。
     * 1.首先分析题目，这道题的目的是找出数组中两个数和为target的那两个值的索引，那首先肯定是要先找那两个值，
     *   然后将值以及对应的索引存储在HashMap中，key存储的就是数组中的那个数，value就是这个数对应的索引。
     *
     * 2.和为target，那就说明，target-num[i]就应该等于另外那个数。所以只需要判断这个数在不在HashMap中即可。
     *   如果存在，那说明在HashMap中找到了，将target-num[i]对应的索引以及num[i]对应的索引存储在一个新建的数组中，并返回。
     *   如果不存在，那就说明在HashMap中没找到，将num[i]以及对应的索引存储在HashMap中。然后进行下一次循环，直到找到为止。
     * 3.本题中，用到的HashMap的几个方法：
     *      <1> map.containKey(target-nums[i])： 判断这个HashMap中是否包含key为target-nums[i]的值。
     *      <2> map.get(target-nums[i])： 获取key等于target-nums[i]对应的value值。
     *      <3> map.put(nums[i], i)： 将key=nums[i], value=i 存储在HashMap中。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int target = 6;
        int[] nums = {1, 3, 5, 7, 9};
        test1_TwoNumbersSum tns = new test1_TwoNumbersSum();
        int[] result = tns.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}