package 左神算法.进阶班一.树相关.高度套路题树形dp;

/**
 * @author zbl
 * @version 1.0
 * @content:二叉树中，一个结点可以往上走和往下走，那么从结点A总能到达结点B。结点A到达结点B的距离为：A走到B的最短路径上的结点数
 *                   求一棵树上的最远距离
 * @date 2020/1/5 13:42
 */
public class MaxDistanceInTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class ReturnType{
       public int h;//树的高度
       public int maxDistance;//最远距离

        public ReturnType(int h, int maxDistance) {
            this.h = h;
            this.maxDistance = maxDistance;
        }
    }

    public static int maxDistance(Node head) {
        int[] record = new int[1];
        return posOrder(head, record);
    }
    //方法一：
    public static ReturnType process(Node head){
            if(head==null){
                return new ReturnType(0,0);
            }

            Node left=head.left;
            ReturnType leftReturn=process(left);
            Node right=head.right;
            ReturnType rightReturn=process(right);
            int includeItselves=leftReturn.h+1+rightReturn.h;//可能性3
            int p1=leftReturn.maxDistance;//可能性1
            int p2=rightReturn.maxDistance;//可能性2
            int resultDistance=Math.max(Math.max(p1,p2),includeItselves);//找出最终答案
            int hitselves=Math.max(leftReturn.h,rightReturn.h)+1;
            return new ReturnType(hitselves,resultDistance);

    }

    //方法二：
    public static int posOrder(Node head, int[] record) {
        if (head == null) {
            record[0] = 0;
            return 0;
        }
        int lMax = posOrder(head.left, record);//返回左子树的结果
        int maxfromLeft = record[0];//左子树树的高度
        int rMax = posOrder(head.right, record);
        int maxFromRight = record[0];//右子树的高度
        int curNodeMax = maxfromLeft + maxFromRight + 1;
        record[0] = Math.max(maxfromLeft, maxFromRight) + 1;//当前节点树的高度
        return Math.max(Math.max(lMax, rMax), curNodeMax);
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.left = new Node(2);
        head1.right = new Node(3);
        head1.left.left = new Node(4);
        head1.left.right = new Node(5);
        head1.right.left = new Node(6);
        head1.right.right = new Node(7);
        head1.left.left.left = new Node(8);
        head1.right.left.right = new Node(9);
        System.out.println(maxDistance(head1));
        System.out.println(process(head1).maxDistance);

        Node head2 = new Node(1);
        head2.left = new Node(2);
        head2.right = new Node(3);
        head2.right.left = new Node(4);
        head2.right.right = new Node(5);
        head2.right.left.left = new Node(6);
        head2.right.right.right = new Node(7);
        head2.right.left.left.left = new Node(8);
        head2.right.right.right.right = new Node(9);
        System.out.println(maxDistance(head2));
        System.out.println(process(head2).maxDistance);

    }


}
