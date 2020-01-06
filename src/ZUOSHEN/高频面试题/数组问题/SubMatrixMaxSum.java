package ZUOSHEN.高频面试题.数组问题;

/**
 * @author zbl
 * @version 1.0
 * @content: 求一个矩阵中最大子矩阵的和。具体要求见笔记：左神高频面试题 ---》三
 * @date 2020/1/2 10:12
 */
public class SubMatrixMaxSum {


     //该实现没有判断矩阵的行与列哪个更小，可以判断一下
    public static int maxSum(int[][] arr){
        if(arr==null || arr.length==0 || arr[0]==null || arr[0].length==0)
            return 0;
        int max=Integer.MIN_VALUE;
        int cur=0;
        int[] s=null;//累加数组
        for(int i=0;i<arr.length;i++){
            s=new int[arr[0].length];
            for(int j=i;j<arr.length;j++)
            {    cur=0;
                for(int k=0;k<s.length;k++){
                    s[k]+=arr[j][k];
                    cur+=s[k];
                    max=Math.max(max,cur);
                    cur=cur<0 ? 0:cur;
                }

            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[][] matrix = { { -90, 48, 78 }, { 64, -40, 64 }, { -81, -7, 66 } };
        System.out.println(maxSum(matrix));


    }

}
