package Leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zbl
 * @version 1.0
 * @content:通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1。

相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。

例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。

另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。

实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。

 

示例 1：

输入：4
输出：7
解释：7 = 4 * 3 / 2 + 1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/clumsy-factorial
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/1 19:17
 */
public class Solution1006 {

    public  static int clumsy(int N) {
        if(N == 1 || N == 2){
            return N;
        }
        int res = N * (N - 1) / (N - 2);
        N -= 3;
        if(N > 0){
            res += N;
            N--;
        }
        while(N >= 3){
            int tmp = 0;
            tmp += N * (N - 1) / (N - 2);
            res -= tmp;
            res += (N - 3);
            N -= 4;
        }
        if(N >= 0){
            res -= N;
        }

        return res;
    }

         public static int clumsy1(int N) {
         Deque<Integer> stack = new LinkedList<Integer>();
         stack.push(N);
         N--;

         int index = 0; // 用于控制乘、除、加、减
         while (N > 0) {
             if (index % 4 == 0) {
                 stack.push(stack.pop() * N);
             } else if (index % 4 == 1) {
                 stack.push(stack.pop() / N);
             } else if (index % 4 == 2) {
                 stack.push(N);
             } else {
                 stack.push(-N);
             }
             index++;
             N--;
         }

         // 把栈中所有的数字依次弹出求和
         int sum = 0;
         while (!stack.isEmpty()) {
             sum += stack.pop();
         }
         return sum;
     }

    public static void main(String[] args) {
        System.out.println(clumsy(7));
        System.out.println(clumsy1(7));
    }
}
