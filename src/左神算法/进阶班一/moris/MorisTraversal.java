package 左神算法.进阶班一.moris;

/**
 * moris遍历的方式实现二叉树的前序，中序，后序遍历，空间复杂度可以控制在O(N)
 */
public class MorisTraversal {

    public static class Node{
        public int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void morisPre(Node head)
    {
      if(head==null)
          return;
      Node cur1=head;
      Node cur2=null;
      while(cur1!=null)
      {
          cur2=cur1.left;
          if(cur2!=null){
              while(cur2.right!=null && cur2.right!=cur1)
              {
                  cur2=cur2.right;
              }
              if(cur2.right==null) {
                  cur2.right = cur1;
                  System.out.print(cur1.value+" ");//有左子树的的结点，第一次到达时便打印
                  cur1 = cur1.left;
                  continue;
              }else{
                  cur2.right=null;
                  }
          }else{
              System.out.print(cur1.value+" ");//没有左子树的结点到到便打印
          }
          cur1=cur1.right;
      }
        System.out.println();
    }

    public static void morisIn(Node head)
    {
        if(head==null)
            return;
        Node cur1=head;
        Node cur2=null;
        while(cur1!=null)
        {
            cur2=cur1.left;
            if(cur2!=null)
            {
                while(cur2.right!=null && cur2.right!=cur1)
                {
                    cur2=cur2.right;
                }
                if(cur2.right==null)
                {
                    cur2.right=cur1;
                    cur1=cur1.left;
                    continue;
                }else {
                    cur2.right=null;
                }
            }
            System.out.print(cur1.value+" ");//没有加else实现了有左子树的结点第二次到达时打印，同时没有左子树的结点直接打印
            cur1=cur1.right;
        }
        System.out.println();
    }

    public static void morisPos(Node head)
    {
      if(head==null)
          return;
      Node cur1=head;
      Node cur2=null;
      while(cur1!=null)
      {
          cur2=cur1.left;
          if(cur2!=null)
          {
              while(cur2.right!=null && cur2.right!=cur1)
                  cur2=cur2.right;
              if(cur2.right==null)
              {
                  cur2.right=cur1;
                  cur1=cur1.left;
                  continue;
              }else{
                  cur2.right=null;
                  printEdge(cur1.left);
              }
          }
          cur1=cur1.right;
      }
      printEdge(head);
      System.out.println();
    }


   public static void printEdge(Node node)
   {
       Node tail=reverse(node);
       Node cur=tail;
       while(cur!=null)
       {
           System.out.println(cur.value+" ");
           cur=cur.right;
       }
       reverse(tail);//两次反转，不改变原来的结构
   }
    //反转右子树，---》在反转的时候通常需要两个额外的结点，一个用于保存下一个节点，一个用于表示上一个结点
    public static Node reverse(Node from)
    {
        Node pre=null;
        Node next=null;
        while(from!=null)
        {
            next=from.right;//保存右节点
            from.right=pre;
            pre=from;
            from=next;
        }
        return pre;
    }

}
