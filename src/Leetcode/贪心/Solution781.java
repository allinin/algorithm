package Leetcode.贪心;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zbl
 * @version 1.0
 * @content:森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。

返回森林中兔子的最少数量。

示例:
输入: answers = [1, 1, 2]
输出: 5
解释:
两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
设回答了 "2" 的兔子为蓝色。
此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。

输入: answers = [10, 10, 10]
输出: 11

输入: answers = []
输出: 0
说明:

answers 的长度最大为1000。
answers[i] 是在 [0, 999] 范围内的整数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rabbits-in-forest
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/4 12:31
 */
public class Solution781 {

    /**
     * * O(nlogn),O(1)
     * @param answers
     * @return
     */
    public static int numRabbits(int[] answers) {
        if(answers == null || answers.length == 0){
            return 0;
        }
        int n = answers.length;
        Arrays.sort(answers);
        int index = 0;
        int res = 0;
        while(index < n && answers[index] == 0){
            res++;
            index++;
        }
        if(index == n){
            return res;
        }
        int num = answers[index];
        int start = index;
        while(index < n){
            if(answers[index] == num){
                index++;
            }else{
                int dist = index - start;
                int tmp = dist / (num + 1);
                int tmp2 =(dist % (num + 1)) == 0 ? 0 : 1;
                res += (tmp + tmp2) * (num + 1);
                //更新num及index,start
                num = answers[index];
                start = index;
                index++;
            }
        }
        int dist = index - start;
        int tmp = dist / (num + 1);
        int tmp2 =(dist % (num + 1)) == 0 ? 0 : 1;
        res += (tmp + tmp2) * (num + 1);
        return res;

    }

    /**
     * O(n),O(n)
     * @param answers
     * @return
     */
    public int numRabbits2(int[] answers) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int y : answers) {
            count.put(y, count.getOrDefault(y, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int y = entry.getKey(), x = entry.getValue();
            ans += (x + y) / (y + 1) * (y + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {0,2,0,2,1};
        System.out.println(numRabbits(arr));
    }

}
