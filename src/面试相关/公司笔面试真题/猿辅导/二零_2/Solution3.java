package 面试相关.公司笔面试真题.猿辅导.二零_2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author zbl
 * @version 1.0
 * @content:猿辅导课堂上老师提供了一些角色，学生可以从中选择一个自己喜欢的角色扮演，每3个不同的角色就可以组成一个小组，进行分组对话。
当老师点击开始分组对话按钮的时候，服务器会为已经选择自己角色的同学分配对话小组，请问最多能组成多少个对话小组？

输入描述:
第一行为测试用例数量C(C<=100)，接下来的C行每行为一个测试用例

每个用例的第一个数字表示可供选择的角色数量T(T<=1000)，接下来的T个数字表示每个角色的选择人数Pi(Pi<=500)

输出描述:
一共C行，每行表示一个测试用例中的最大对话小组数量。

输入例子1:
3
3 1 1 1
3 2 2 3
4 0 2 3 99

输出例子1:
1
2
2

例子说明1:
对于用例1，正好3个不同角色，每个角色1个人选，于是构成且只能构成一个小组。

对于用例2，在构成两个小组之后，第3个角色单了1人无法构成任何小组，所以最大小组数量是2。

对于用例3，学生扎堆选择了最后一个角色，但是第二个角色只有2个人，所以还是只能构成2个对话小组。
 * @date 2020/7/25 20:26
 */
public class Solution3 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int c=sc.nextInt();
        for(int i=0;i<c;i++){
            int num=sc.nextInt();
            int[] arr=new int[num];
            for(int j=0;j<num;j++){
                arr[j]=sc.nextInt();
            }
            System.out.println(process(arr));
        }
    }

    public static int process(int[] arr){
        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for(int num:arr){
            if(num>0)
                pq.add(num);
        }
        int res=0;
        while(pq.size()>2){
            int first=pq.poll();
            int second=pq.poll();
            int third=pq.poll();
            if(--first>0)
                pq.add(first);
            if(--second>0)
                pq.add(second);
            if(--third>0)
                pq.add(third);
            res++;
        }
        return res;
    }

}
