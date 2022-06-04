package codeTop;

/**
 * 不使用乘法快速计算a * b的值
 */
public class QuickMulti {

    //模仿快速幂（LeetCode 50）的实现过程
    public static int quickMultiImpl(int a,int b){
        int ans = 0;
        while(a != 0){
            if((a & 1) != 0){
                ans += b;
            }
            b += b;
            a /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(quickMultiImpl(384,59));
    }
}
