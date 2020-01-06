package ZUOSHEN.进阶班.树相关.高度套路题树形dp;

/**
 * @author zbl
 * @version 1.0
 * @content: 给定一棵二叉树的头结点，返回其中最大的搜索二叉树的[大小]。
 * @date 2020/1/5 13:17
 */
public class BiggestSubBSTInTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node biggestSubBST(Node head) {
        int[] record = new int[3]; // 0->size, 1->min, 2->max
        return posOrder(head, record);
    }

    public static class ReturnType{
        public int size;//最大搜索二叉树的大小
        public Node head;//头结点
        public int min;//子树上的最小值
        public int max;//子树上的最大值

        public ReturnType(int a, Node b,int c,int d) {
            this.size =a;
            this.head = b;
            this.min = c;
            this.max = d;
        }
    }

    public static ReturnType process(Node head){
        if(head == null) {
            return new ReturnType(0,null,Integer.MAX_VALUE, Integer.MIN_VALUE);//使他不影响做判断，最大值给Integer的最小值，最小值给Integer的最大值
        }
        Node left = head.left;
        ReturnType leftSubTressInfo = process(left);
        Node right = head.right;
        ReturnType rightSubTressInfo = process(right);

        int includeItSelf = 0; //第三种情况
        if(leftSubTressInfo.head == left
                &&rightSubTressInfo.head == right
                && head.value > leftSubTressInfo.max
                && head.value < rightSubTressInfo.min
                ) {
            includeItSelf = leftSubTressInfo.size + 1 + rightSubTressInfo.size;//满足条件的时候可以连起来，即：情况三
        }
        int p1 = leftSubTressInfo.size;//可能性1
        int p2 = rightSubTressInfo.size;//可能性2

        //以上类似于黑盒，下面的类似拆黑盒的过程。
        int maxSize = Math.max(Math.max(p1, p2), includeItSelf);

        Node maxHead = p1 > p2 ? leftSubTressInfo.head : rightSubTressInfo.head;
        if(maxSize == includeItSelf) {
            maxHead = head;
        }

        return new ReturnType(maxSize,
                maxHead,
                Math.min(Math.min(leftSubTressInfo.min,rightSubTressInfo.min),head.value),
                Math.max(Math.max(leftSubTressInfo.max,rightSubTressInfo.max),head.value));


    }


    public static Node posOrder(Node head, int[] record) {
        if (head == null) {
            record[0] = 0;
            record[1] = Integer.MAX_VALUE;
            record[2] = Integer.MIN_VALUE;
            return null;
        }
        int value = head.value;
        Node left = head.left;
        Node right = head.right;
        Node lBST = posOrder(left, record);
        int lSize = record[0];
        int lMin = record[1];
        int lMax = record[2];
        Node rBST = posOrder(right, record);
        int rSize = record[0];
        int rMin = record[1];
        int rMax = record[2];
        record[1] = Math.min(rMin, Math.min(lMin, value)); // lmin, value, rmin -> min
        record[2] =  Math.max(lMax, Math.max(rMax, value)); // lmax, value, rmax -> max
        if (left == lBST && right == rBST && lMax < value && value < rMin) {
            record[0] = lSize + rSize + 1;
            return head;
        }
        record[0] = Math.max(lSize, rSize);
        return lSize > rSize ? lBST : rBST;
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

        Node head = new Node(6);
        head.left = new Node(1);
        head.left.left = new Node(0);
        head.left.right = new Node(3);
        head.right = new Node(12);
        head.right.left = new Node(10);
        head.right.left.left = new Node(4);
        head.right.left.left.left = new Node(2);
        head.right.left.left.right = new Node(5);
        head.right.left.right = new Node(14);
        head.right.left.right.left = new Node(11);
        head.right.left.right.right = new Node(15);
        head.right.right = new Node(13);
        head.right.right.left = new Node(20);
        head.right.right.right = new Node(16);

        printTree(head);
        Node bst = biggestSubBST(head);
        printTree(bst);

    }

}
