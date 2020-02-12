package 左神算法.进阶班一.树相关;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zbl
 * @version 1.0
 * @content:判断一颗树是否是完全二叉树
 * @date 2020/1/9 14:05
 */
public class IsCBT {


    public static class Node{
        public int value;
        public Node right;
        public Node left;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isCBT(Node node){
           if(node==null)
               return true;
        Queue<Node> queue=new LinkedList<>();
        boolean leaf=false; //是否开启剩下的结点需要全部是叶子结点的阶段
        Node left=null;
        Node right=null;
        queue.add(node);
        while(!queue.isEmpty()){
            Node head=queue.poll();
            left=head.left;
            right=head.right;
            if((leaf && (left!=null || right!=null)) || (left==null && right!=null)){
                return false;
            }
            if(left!=null)
                queue.add(left);
            if(right!=null)
                queue.add(right);
            if(right==null || left==null)
                leaf=true;
        }
        return true;
    }
}
