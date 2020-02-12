package 左神算法.进阶班一.树相关.高度套路题树形dp;

/**
 * 判断一颗二叉树是否是平衡二叉树
 */
public class IsBalancedTree {

    public static class Node{
       public  int value;
       public Node left;
       public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class ReturnData{
        public boolean isBalanced;
        public int height;

        public ReturnData(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static boolean isBal(Node head)
    {
        return process(head).isBalanced;
    }
    public static ReturnData process(Node head)
    {
        if(head==null)
        {
            return new ReturnData(true,0);
        }
        ReturnData leftData = process(head.left);
        if(!leftData.isBalanced)
            return new ReturnData(false,0);
        ReturnData rightData = process(head.right);
        if(! rightData.isBalanced)
            return new ReturnData(false,0);
        if(Math.abs(leftData.height-rightData.height)>1)
            return new ReturnData(false,0);
        return new ReturnData(true,Math.max(leftData.height,rightData.height)+1);

    }

    //法二：
    public static int getHeight(Node head,int level,boolean[] res)
    {
        if(head==null)
            return level;
        int lH=getHeight(head.left,level+1,res);
        if(!res[0])
            return level;
        int rH=getHeight(head.right,level+1,res);
        if(!res[0])
            return level;
        if(Math.abs(lH-rH)>1)
            res[0]=false;
        return Math.max(lH,rH);
    }

    public static boolean  isBalance(Node head)
    {
        boolean[]res=new boolean[1];
        res[0]=true;
        getHeight(head,1,res);
        return res[0];
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(isBalance(head)==isBal(head));

    }
}
