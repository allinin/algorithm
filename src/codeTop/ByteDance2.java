package codeTop;

public class ByteDance2 {

    /**
     * num1 与 num2 是从小到大排好序的数组，找出num1,num2合并后的第k(k>0)大的元素 时间复杂度O(log(m +n))
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public static int getKthNum(int[] nums1,int[] nums2,int k){
        int len1 = nums1.length;
        int len2 = nums2.length;
        int idx1 = 0,idx2 = 0;
        while(true) {
            if (idx1 == len1) {
                return nums2[idx2 + k - 1];
            }
            if (idx2 == len2) {
                return nums1[idx1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[idx1], nums2[idx2]);
            }
            int half = k / 2;
            int newIdx1 = Math.min(idx1 + half, len1) - 1;
            int newIdx2 = Math.min(idx2 + half, len2) - 1;
            int pivot1 = nums1[newIdx1], pivot2 = nums2[newIdx2];
            if (pivot1 <= pivot2) {
                k -= (newIdx1 - idx1 + 1);
                idx1 = newIdx1 + 1;
            } else {
                k -= (newIdx2 - idx2 + 1);
                idx2 = newIdx2 + 1;
            }
        }
    }
}
