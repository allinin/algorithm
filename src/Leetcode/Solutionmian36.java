package Leetcode;

/**
 * @author zbl
 * @version 1.0
 * @content:输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。



为了让您更好地理解问题，以下面的二叉搜索树为例：





我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。

下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。





特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/2 21:01
 */
public class Solutionmian36 {

    public static class Node {
        public int value;
        public Node right;
        public Node left;
        public Node(int value)
        {
            this.value=value;
        }
    }

    public static Node treeToDoublyList(Node root) {
        //递归写法
        if(root==null) return null;
        Node[] res=process(root);
        res[0].left=res[1];
        res[1].right=res[0];
        return res[0];
    }
    //返回以root作为根节点形成的双向链表的头结点以及最后一个结点
    private static Node[] process(Node root){
        Node[] res=new Node[2];
        if(root==null) return res;
        Node[] left=process(root.left);
        Node[] right=process(root.right);
        if(left[1]!=null)
            left[1].right=root;
        root.left=left[1];
        root.right=right[0];
        if(right[0]!=null)
            right[0].left=root;
        res[0]=left[0]!=null ? left[0]:root;//当子树返回的结果不为null的时候才能使res[0]=left[0]
        res[1]=right[1]!=null ? right[1] : root ;//与上面同理
        return res;
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        treeToDoublyList(head);

    }

}
