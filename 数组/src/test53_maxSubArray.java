/**
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @author wyd
 * @date 2020/10/16 - 21:03
 */


/**
 * 动态规划
 */
public class test53_maxSubArray {
    public int maxSubArray(int[] nums){
        int ans = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            if (sum>0){
                sum+=nums[i];
            }else {
                sum=nums[i];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {-2, 1};
        test53_maxSubArray array = new test53_maxSubArray();
        int max = array.maxSubArray(nums);
        System.out.println("最大子序和为：" + max);
    }
}
