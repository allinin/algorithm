package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.hard;

/**
 * 寻找两个正有序数组的中位数
 * @author zbl
 * @create 2023-11-27 17:29
 */
public class Code4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        //总长度为奇数
        if(((len1 + len2) & 1) == 1) {
            return (double) getKthNum(nums1,nums2,(len1 + len2) / 2 + 1,0,len1 - 1,0,len2 - 1);
        }
        return  ((double) getKthNum(nums1,nums2,(len1 + len2) / 2 ,0,len1 - 1,0,len2 - 1) +
                (double) getKthNum(nums1,nums2,(len1 + len2) / 2 + 1,0,len1 - 1,0,len2 - 1)) / 2;
    }
    /**
     * 找出两个正有序数组合并后第k大的数字
     * log(m+N)
     *
     * @param nums1
     * @param nums2
     * @param k
     * @param start1:起始索引位置
     * @param end1:终点索引位置
     * @param start2
     * @param end2
     * @return
     */
    public static int getKthNum(int[] nums1, int[] nums2, int k, int start1, int end1, int start2, int end2) {
        if (start1 > end1) {
            return nums2[start2 + k - 1];
        }
        if (start2 > end2) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int mid = k / 2;
        //考虑可能的边界溢出问题，如果mid比计算长度大，则取最后一个值
        int nums1Mid = (end1 - start1 + 1 >= mid) ? nums1[start1 + mid - 1] : nums1[end1];
        int nums2Mid = (end2 - start2 + 1 >= mid) ? nums2[start2 + mid - 1] : nums2[end2];
        //说明num2数组中nums2Mid及以左的数字一定不符合要求，舍去，重新计算
        if (nums1Mid >= nums2Mid) {
            //需要舍去的数组长度
            int deleteLen = Math.min(end2 - start2 + 1,mid);
            //新的起始位置为原起始位置 + 舍去长度
            return getKthNum(nums1,nums2,k - deleteLen,start1,end1,start2 + deleteLen,end2);
        }
        int deleteLen = Math.min(end1 - start1 + 1,mid);
        return getKthNum(nums1,nums2,k - deleteLen,start1 + deleteLen,end1,start2,end2);

    }
}
