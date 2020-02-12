package 左神算法.基础班.树;

/**
 * 已知一颗完全二叉树，求其结点个数，要求时间复杂度低于O（N），N为树的结点的个数
 */
public class CompleteTreeNodeNumber {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    public static int nodeNum(Node head)
    {
        if(head==null)
            return 0;
        return bs(head,1,mostLeftLevel(head,1));
    }

    //返回以head为头结点的树的元素的个数
    //node是当前结点，l是node所在的层数，h是我不管你是第几层，h表示整个树的最大深度
    public static int bs(Node head,int level,int h)
    {
        if(level==h)
            return 1;
        if(mostLeftLevel(head.right,level+1)==h)
        {
            return (1<<(h-level))+bs(head.right,level+1,h);
        }else {
            return (1<<(h-level-1))+bs(head.left,level+1,h);
        }

    }

    //node为当前结点，level为当前节点在第几层.返回的是node结点最左边的结点所在整棵树中的深度
    public static int mostLeftLevel(Node node,int level)
    {
        Node cur=node ;
        while(cur!=null)
        {
            level++;
            cur=cur.left;
        }
        return level-1;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(nodeNum(head));
    }


}
