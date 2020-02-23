package 左神算法.进阶班二.第三章;

/**
 * @author zbl
 * @version 1.0
 * @content:通过有序数组生成平衡搜索二叉树
 * 给定一个有序数组sortArr，已知其中没有重复值，用这个有序
数组生成一棵平衡搜索二叉树，并且该搜索二叉树中序遍历的
结果与sortArr一致。

 * @date 2020/2/19 15:00
 */
public class Code_01_SortedArrayToBalancedBST {

    public static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node sortedArrayToBalancedBST(int[] arr){
        if(arr==null || arr.length==0)
            return null;
        Node[] nodes=new Node[arr.length];
        for(int i=0;i<arr.length;i++){
            nodes[i]=new Node(arr[i]);
        }
        return process(nodes,0,nodes.length-1);
    }

    private static Node process(Node[] arr,int start,int end){

        if(start<=end){
            int mid=(start+end)/2;
            Node head=arr[mid];
            head.left=process(arr,start,mid-1);
            head.right=process(arr,mid+1,end);
            return head;
        }
        return null;
    }
    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        printTree(sortedArrayToBalancedBST(arr));

    }
}
