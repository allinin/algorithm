package 左神算法.进阶班二.第三章;

/**
 * @author zbl
 * @version 1.0
 * @content:跳跃游戏
【题目】
给定数组arr，arr[i]==k代表可以从位置i向右跳1~k个距离。
比如，arr[2]==3，代表从位置2可以跳到位置3、位置4或位置5。
如果从位置0出发，返回最少跳几次能跳到arr最后的位置上。
【举例】
arr=[3,2,3,1,1,4]。
arr[0]==3，选择跳到位置2；arr[2]==3，可以跳到最后的位置。
所以返回2。
【要求】
如果arr长度为N，要求实现时间复杂度为O(N)、额外空间复杂
度为O(1)的方法。
 * @date 2020/2/19 15:01
 */
public class Code_04_JumpGame {


    public static int jump(int[] arr){
        if(arr==null || arr.length==0)
            return 0;
        int k=0;
        int cur=0;//表示走了k步最大能做的距离
        int next=0;//表示走第k+1后后能到的最大距离
        for(int i=0;i<arr.length;i++){
            if(cur<i){
                k++;
                cur=next;
                //下面的if可以写也可以不写
//                if(cur>=arr.length-1)
//                    break;
            }
            next=Math.max(next,i+arr[i]);
        }
        return k;
    }
    public static void main(String[] args) {
        int[] arr = { 3, 2, 3, 1, 1, 4 };
        System.out.println(jump(arr));
    }
}
