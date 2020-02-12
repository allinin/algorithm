package 左神算法.进阶班一.KMP;

/**
 * @author zbl
 * @version 1.0
 * @content: 一棵树T1，另一个树T2,T1中是否存在与T2完全一致的子树，存在返回true,不存在返回false.
 * @date 2019/12/27 10:46
 */
public class T1SubtreeEqualsT2 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int value){
            this.value=value;
        }
    }

    public static boolean isSubtree(Node node1,Node node2){
        String s = serializeTree(node1);
        String s1 = serializeTree(node2);
        int indexOf = getIndexOf(s, s1);
        return indexOf!=-1;
    }

    //将树序列化，然后看一下t2是否t1的子串即可
    public static String serializeTree(Node head)
    {
        if(head==null)
            return "#!";
        String str=head.value+"!";
        str+=serializeTree(head.left);
        str+=serializeTree(head.right);
        return str;
    }
    //kmp算法
    public static int getIndexOf(String str1,String str2){
        if(str1==null || str2==null || str2.length()>str1.length()|| str2.length()<1)
            return -1;
        char[] str1Arr=str1.toCharArray();
        char[] str2Arr=str2.toCharArray();
        int[] next=getNextArray(str2);
        int index1=0;
        int index2=0;
        while(index1<str1Arr.length && index2<str2Arr.length){

            if(str1Arr[index1]==str2Arr[index2])
            {
                index1++;
                index2++;
            }else if(next[index2]==-1)//说明第一个字符都不一样
            {
                index1++;
            }else{
                index2=next[index2];
            }
        }

        return index2==str2Arr.length ? index1-index2:-1;
    }

    public static int[] getNextArray(String str){
        char[] chas=str.toCharArray();
        int[] next=new int[chas.length];
        next[0]=-1;
        next[1]=0;
        int pos=2;//初始化位置
        int cn=0;//下一条的位置，初始化为next[pos-1]的值
        while(pos<chas.length)
        {
            if(chas[pos-1]==chas[cn])
            {
                next[pos++]=++cn;
            }else if(cn>0)
            {
                cn=next[cn];
            }else {
                next[pos++]=0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        Node t1 = new Node(1);
        t1.left = new Node(2);
        t1.right = new Node(3);
        t1.left.left = new Node(4);
        t1.left.right = new Node(5);
        t1.right.left = new Node(6);
        t1.right.right = new Node(7);
        t1.left.left.right = new Node(8);
        t1.left.right.left = new Node(9);

        Node t2 = new Node(2);
        t2.left = new Node(4);
        t2.left.right = new Node(8);
        t2.right = new Node(5);
        t2.right.left = new Node(9);

        System.out.println(isSubtree(t1, t2));

    }
}
