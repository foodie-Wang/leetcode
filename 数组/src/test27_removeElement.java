import java.util.Arrays;

/**
 * 移除元素
 *
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * @author wyd
 * @date 2020/10/14 - 20:02
 */
public class test27_removeElement {

    public int removeElement(int[] nums, int val) {
        int t, counts=0;
        for (int i=0; i<nums.length; i++){
            for (int j = i+1; j<nums.length; j++){
                if (nums[i]==val){
                    if (nums[j]!=val){
                        t = nums[i];
                        nums[i] = nums[j];
                        nums[j] = t;
                        break;
                    }else {
                        continue;
                    }
                }else {
                    break;
                }

            }
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i<nums.length;i++){
            if(nums[i]!=val){
                counts++;
            }
        }
        return counts;

    }


    public static void main(String[] args) {
        int[] nums = {3,3,3,3,2,3,2,3,2};
        int val = 3;
        test27_removeElement r = new test27_removeElement();
        int length = r.removeElement(nums, val);
        System.out.println(length);
    }
}
