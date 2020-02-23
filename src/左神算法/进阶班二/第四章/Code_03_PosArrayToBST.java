package 左神算法.进阶班二.第四章;

/**
 * @author zbl
 * @version 1.0
 * @content:题目三
KMP算法扩展题目二
根据后序数组重建搜索二叉树
【题目】
给定一个整型数组arr，已知其中没有重复值，判断arr是否可能是节
点值类型为整型的搜索二叉树后序遍历的结果。
进阶：如果整型数组arr中没有重复值，且已知是一棵搜索二叉树的后
序遍历结果，通过数组arr重构二叉树。
 * @date 2020/2/21 16:35
 */
public class Code_03_PosArrayToBST {

    public static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isPostTree(int[] arr){
        if(arr==null || arr.length==0)
            return false;
        return isPost(arr,0,arr.length-1);

    }

    private static boolean isPost(int[] arr,int begin,int end){
        if(begin==end)
            return true;
        int less=-1;
        int more=end;
        for(int i=begin;i<end;i++)
        {
            if(arr[i]<arr[end]){
                less=i;
            }else{
                more=more==end ?i:more;
            }
        }

        if(more==end || less==-1){
            return isPost(arr,begin,end-1);
        }
        if(less!=more-1)
            return false;
        return isPost(arr,begin,less) && isPost(arr,more,end-1);
    }


    //重构二叉树
    public static Node posArrayToBST(int[] arr){
        if(arr==null || arr.length==0)
            return null;
        return process(arr,0,arr.length-1);
    }

    public static Node process(int[] arr,int begin,int end){

        if(begin>end)
            return null;
        Node head=new Node(arr[end]);
        int less=-1;
        int more=end;
        for(int i=begin;i<end;i++){
            if(arr[i]<arr[end])
                less=i;
            else{
                more=more==end ? i:more;
            }
        }
        if(less!=-1)
        head.left=process(arr,begin,less);
        if(more!=end)
        head.right=process(arr,more,end-1);
        return head;
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
        int[] arr = { 2, 1, 3, 6, 5, 7, 4 };
        System.out.println(isPost(arr, 0, arr.length - 1));
        printTree(posArrayToBST(arr));

    }

}
