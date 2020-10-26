import java.util.Arrays;

/**
 * @author wyd
 * @date 2020/10/26 - 19:53
 */
public class test88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n){
        int [] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        //System.out.println(Arrays.toString(num1_copy));

        int p1 = 0;
        int p2 = 0;

        int p = 0;

        while ((p1<m)&&(p2<n)){
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
        }

        if (p1<m){
            System.arraycopy(nums1_copy, p1, nums1, p1+p2, m+n-p1-p2);
        }

        if (p2<n){
            System.arraycopy(nums2, p2, nums1, p1+p2, m+n-p1-p2);
        }

    }


    public void merge1(int[] nums1, int m, int[] nums2, int n){
        int p = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while ((p1>-1)&&(p2>-1)) {
            if (nums1[p1] < nums2[p2]) {
                nums1[p] = nums2[p2];
                p2--;
            }else {
                nums1[p] = nums1[p1];
                p1--;
            }
            p--;
        }

        System.out.println(Arrays.toString(nums1));
    }


    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int n = nums2.length;
        int m = nums1.length - n;

        test88_MergeSortedArray sortedArray = new test88_MergeSortedArray();
        //sortedArray.merge(nums1, m, nums2, n);
        sortedArray.merge1(nums1, m, nums2, n);
    }

}
