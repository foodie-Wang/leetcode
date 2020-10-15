import java.util.HashMap;

/**
 * @author wyd
 * @date 2020/10/15 - 16:08
 */
public class test35_searchInsertIndex {
    public int searchInsert(int[] nums, int target, int left, int right) {

        /**
         * 最简单的单层循环遍历（可以这样做，但是效率会低于二分查找），这个的时间复杂度是O(n)，二分查找的时间复杂度是O(log n)
         */
//        for (int i=0; i<nums.length; i++){
//            if(nums[i]>=target) {
//                return i;
//            }
//        }
//        return nums.length;


        /**
         * 二分查找----递归调用(如果数组中无重复元素)
         */

        //如果left>right了，说明数组中没有要查找的元素，那此时返回的left的值就是
        //把这个数放到这个排序数组中，真实的索引位置。
        //例如nums = [1,3,5,7,9], target = 4,那二分查找找不到4个数，但是如果把4真实放到这个数组中，其索引位置就是2。
        //所以left就是2
        if (left > right){
            return left;
        }
        //mid是数组的中间位
        int mid = (left + right) / 2;
        //如果target<nums[mid],说明要查的这个数在左半部分，也就是mid的左边。所以此时right的位置就要挪到mid-1处。
        if (target < nums[mid]){
            return searchInsert(nums, target, left, mid-1);
        }
        //如果target>nums[mid],说明要查的这个数在右半部分，也就是mid的右边。所以此时left的位置就要挪到mid+1处。
        else if(target > nums[mid]){
            return searchInsert(nums, target, mid+1, right);
        }
        //如果target==nums[mid],那说明找到了这个数，直接返回mid即为该数索引位置。
        else {
            return mid;
        }
    }



    //二分查找（在循环体内部查找元素）
    public int searchInsert2(int[] nums, int target) {
        int left = 0, right = nums.length-1;

        //循环终止条件是left>right
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            }else if (target < nums[mid]) {
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        int nums[] = {1,3,5,6,7,8};
        test35_searchInsertIndex searchInsertIndex = new test35_searchInsertIndex();
        //int index = searchInsertIndex.searchInsert(nums, 4, 0, nums.length-1);

        int index2 = searchInsertIndex.searchInsert2(nums, 5);
        //System.out.println(index);

        System.out.println(index2);
    }
}

