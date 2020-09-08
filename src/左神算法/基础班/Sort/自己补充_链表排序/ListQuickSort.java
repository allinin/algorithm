package 左神算法.基础班.Sort.自己补充_链表排序;

/**
 * @author zbl
 * @version 1.0
 * @content:v 链表实现快排：也就是leetcode 第148题
 * @date 2020/8/6 15:23
 */
public class ListQuickSort {

    public static class Node{
        int val;
        Node next;
        public Node(){}
    }

    /**
     *
     * 用三个指针来控制，模仿数组快排，数组中的交换结点在这里成了---》交换结点的值
     */
    public static Node sortList(Node head){
        quickSort(head,null);
        return head;
    }
    public static void quickSort(Node head,Node end){
        if(head!=end){
            Node node=partation(head,end);
            quickSort(head,node);
            quickSort(node.next,end);
        }
    }

    private static Node partation(Node head,Node end){
        Node left=head,right=head.next;//right用来遍历
        //left左边是小于head值的结点，left-right之间是大于等于head值的点
        while(right!=end){
            if(right.val<head.val){//以head作为partation的base结点，当结
                left=left.next;
                int tmp=left.val;
                left.val=right.val;
                right.val=tmp;
            }
            right=right.next;
        }
        if(left!=head){
            int tmp=left.val;
            left.val=head.val;
            head.val=tmp;
        }
        return left;//返回的是第一个等于head值的结点
    }



}
