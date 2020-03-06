package 左神算法.进阶班二.第七章;

/**
 * @author zbl
 * @version 1.0
 * @content:给定一棵二叉树的头节点head，判断该树是否是平衡二叉树
 * @date 2020/2/29 16:40
 */
public class Code_02_IsBalancedTree {


    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value=value;
        }
    }

    public static class ReturnData{
        public int height;
        public boolean isB;
        public ReturnData(int height,boolean isB){
            this.height=height;
            this.isB=isB;
        }
    }

    public static boolean isB(Node head){
        return isBalance(head,1).isB;
    }


    public static ReturnData isBalance(Node head,int level){
        if(head==null){
            return new ReturnData(0,true);
        }
        ReturnData left = isBalance(head.left, level + 1);
        if(!left.isB)
            return new ReturnData(level,false);
        ReturnData right=isBalance(head.right,level+1);
        if(!right.isB)
            return new ReturnData(level,false);
        if(Math.abs(left.height-right.height)>1)
            return new ReturnData(level,false);
        return new ReturnData(Math.max(left.height,right.height),true);

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(isB(head));

    }

}
