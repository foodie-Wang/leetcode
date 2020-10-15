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

        /*
            自己的解法：
                给定两个指针i和j，让i指向第一个元素，j指向第二个元素，然后双层循环遍历，i从0开始，j从1开始
                第一种情况：
                    如果nums[i]==val，那说明第一个元素就是要删除的值，我们得把他想办法挪到最后去，然后让不等于val的值往前移动。
                    然后此时让j跑，判断nums[j]的值：
                        1.如果nums[j]是等于val的，那说明这个值不能跟num[i]交换的，所以直接continue跳出本次循环，执行下一次循环。
                          j往后跑，直到找到一个nums[j]是不等于val的。
                        2.nums[j]不等于val了，说明这个值可以与nums[i]交换了。执行交换操作。
                          交换完之后，要执行break操作，因为每次交换完，nums[i]肯定不是val了，所以指针i就需要后移一位。
                          进行下一次循环。
                第二种情况：
                    如果nums[i]的值不等于val，那说明这个数就是我们要留下来的，不用任何交换操作。只有跟val一样的数，
                    才进行交换放到数组的最后去。所以直接break，让i后移一位，继续循环。

                最后当i跑到数组的末位时，结束所有循环。此时数组中跟val不一样的就在前面，一样的都放在了后面。然后，
                遍历这个数组，用一个计数器counts来记录新数组的长度（也就是跟val不一样的部分的长度）。判断nums[i]是不是等于val,
                如果不等于val，就让计数器+1。最后返回counts即可。

         */
//        int t, counts=0;
//        for (int i=0; i<nums.length; i++){
//            for (int j = i+1; j<nums.length; j++){
//                if (nums[i]==val){
//                    if (nums[j]!=val){
//                        t = nums[i];
//                        nums[i] = nums[j];
//                        nums[j] = t;
//                        break;
//                    }else {
//                        continue;
//                    }
//                }else {
//                    break;
//                }
//
//            }
//        }
//        //System.out.println(Arrays.toString(nums));
//        for (int i = 0; i<nums.length;i++){
//            if(nums[i]!=val){
//                counts++;
//            }
//        }
//        return counts;


        /**
         * 官方解法：双指针法。
         *
         * 方法一：
         *      当 nums[j]与给定的值相等时，递增 j 以跳过该元素。
         *      只要 nums[j] != val,我们就复制 nums[j]到 nums[i],并同时递增两个索引。
         *      重复这一过程，直到 j 到达数组的末尾，该数组的新长度为 i。
         */
//        int i=0;
//        for (int j=0; j<nums.length; j++){
//            if (nums[j]!=val){
//                nums[i]=nums[j];
//                i++;
//            }
//        }
//        System.out.println(Arrays.toString(nums));
//        return i;

        /**
         * 方法二：
         *      考虑数组包含很少的要删除的元素的情况。比如num = [1,2,3,4,5],val=5。如果是这种情况，
         *      那按照方法一，会对前四个元素进行一次原地赋值，这显然是不必要的。
         *      再比如num = [5,4,3,2,1],val=5。如果是这种情况，那也完全没有必要把[4,3,2,1]这几个元素左移一位。
         *
         *      所以，改进一下方法一：
         *          当遇到num[i]==val,把最后一个元素与当前元素进行交换，并释放最后一个元素，使得数组长度减少1。
         *          这其实相当于倒着把不是val的数都放到前面来。
         *
         *          最后 n 的值就是新数组的长度。
         */
        int i=0;
        int n = nums.length;
        while (i < n){
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                //n--的目的是使数组长度减少1，循环终止条件是i < n
                n--;
            }else {
                i++;
            }
        }
        //System.out.println(Arrays.toString(nums));
        return n;
    }


    public static void main(String[] args) {
        int[] nums = {3,3,3,3,2,3,2,3,3};
        int val = 3;
        test27_removeElement r = new test27_removeElement();
        int length = r.removeElement(nums, val);
        System.out.println(length);
    }
}
