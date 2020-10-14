import java.util.Arrays;

/**
 * 删除排序数组中的重复项
 *
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * @author wyd
 * @date 2020/10/13 - 10:30
 */
public class test26_removeSame {

    /*
        使用双指针i,j。让i在第一个元素上，j在第二个元素上，首先比较这两个元素，如果nums[i]==nums[j],那说明是重复元素,
        让j++，跳过重复元素，如果nums[i]!=nums[j]了，那说明，已经跳过了重复元素，此时把nums[j]赋值给nums[i+1]，然后让i++。
        但是在赋值前，还要判断一下j-i是否大于0，因为如果j-i=0的话，那相当于j这个指针指向的数据被赋到i+1，
        也就是j这个位置了，相当于重复赋值了。最后返回i+1的值，就是新数组长度。
    */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j=1; j<nums.length;j++){
            if (nums[i]!=nums[j]){
                if (j-i>0){
                    nums[i+1] = nums[j];
                }
                i++;
            }
        }
        //System.out.println(Arrays.toString(nums));
        return i+1;
    }


    public static void main(String[] args) {
        int nums[] = {1,1,2,2,3,3,4,4};
        test26_removeSame removeSame = new test26_removeSame();
        int length = removeSame.removeDuplicates(nums);
        System.out.println(length);
    }
}


