package 工作后刷题.丑数类似题;


/**
 * @Author:zbl
 * @Date:2024/1/15 21:13
 * 第K个数
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。
 * 注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 * <p>
 * 示例 1:
 * <p>
 * 输入: k = 5
 * <p>
 * 输出: 9
 */
public class Face1709 {

    //dp动态规划
    public int getKthMagicNumber(int k) {
        if (k == 1) {
            return 1;
        }
        int[] arr = new int[k];
        arr[0] = 1;
        int multi3 = 0, multi5 = 0, multi7 = 0; //当前乘3，乘5，乘7位置的索引
        for (int i = 1; i < k; i++) {
            //下一个数一定是当前索引计算值的最小值
            int min = Math.min(arr[multi3] * 3, Math.min(arr[multi5] * 5, arr[multi7] * 7));
            //如果相应的索引计算达到了最小值，则索引位置置为下一个
            if (min == arr[multi3] * 3) {
                multi3++;
            }
            if (min == arr[multi5] * 5) {
                multi5++;
            }
            if (min == arr[multi7] * 7) {
                multi7++;
            }
            arr[i] = min;
        }
        return arr[k - 1];

    }

    public static void main(String[] args) {
        System.out.println(new Face1709().getKthMagicNumber(7));
    }

}
