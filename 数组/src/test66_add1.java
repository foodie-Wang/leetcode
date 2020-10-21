import java.util.Arrays;

/**
 * 加一
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * @author wyd
 * @date 2020/10/21 - 20:35
 */
public class test66_add1 {

    public int[] plusOne(int[] digits) {


        /**
         * 自己的解法
         */
        //原数组长度
        int len = digits.length;

        //因为加1操作，都是从个位加，所以将指针i放到数组的最后一个元素上。开始向前遍历。
        for (int i = len - 1; i > -1; i--) {
            //如果这个数是小于9的，那说明不用考虑进位的问题，直接将这个数+1，并且跳出循环。返回数组。
            if (digits[i] < 9) {
                digits[i] += 1;
                break;

            //因为每个位置只存放一个数，所以如果这个数是9，那就要考虑进位的问题。
            } else {
                //这里判断一下指针i是否已经指向第一个元素了，如果还没有指向第一个元素，
                //那直接将这个数赋值为0。（因为9+1后向前进一位，自己变成0）
                //然后continue进行下一次循环，直到i指向第一个元素。
                if (i != 0) {
                    digits[i] = 0;
                    continue;
                //else说明i已经指向第一个元素了，那说明已经将所有的9都变成了0，此时需要将数组长度扩大一位，让最高位变成1。
                //但是数组对象长度是不可改变的，所有我们采用复制为容量更大的新数组来替换原数组，实现变长操作。
                }else {
                    //Arrays.copyOf(原数组名, 新数组长度)
                    digits = Arrays.copyOf(digits, len+1);
                    //此时指针i指向索引为0的位置，也就是最高位，所以让最高位赋值为1。
                    digits[0]=1;
                }
            }
        }
        return digits;
    }


    /**
     * 官方精选解法
     * @param digits
     * @return
     */
    public int[] plusOne1(int[] digits) {
        int len = digits.length;
        for (int i=len-1; i>-1; i--){
            digits[i]++;
            //如果这个数+1后是10了（说明有进位），那10%10就是0。否则就是+1之后的这个数本身（说明没有进位）
            digits[i] = digits[i]%10;
            //如果余数不等于0，说明没有进位，直接返回digits
            if (digits[i]!=0)
                return digits;
        }
        //如果出现9，99，999这种到最高位都还有进位的话，那就要让数组长度增加一位。new一个新的int型数组，默认值是0。
        //最高位赋值为1即可。其余为均为0。最后返回digits。
        digits = new int[digits.length+1];
        digits[0]=1;
        return digits;

    }


    public static void main(String[] args) {
        int digits[] = {1,2,9};
        test66_add1 add1 = new test66_add1();
        //int result[] = add1.plusOne(digits);
        int result[] = add1.plusOne1(digits);
        System.out.println(Arrays.toString(result));
    }
}
