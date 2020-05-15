package 公司真题;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author zbl
 * @version 1.0
 * @content: 给你一个01字符串，定义答案=该串中最长的连续1的长度，现在你有至多K次机会，
 * 每次机会可以将串中的某个0改成1，现在问最大的可能答案
 * @date 2020/3/30 20:23
 */
public class Exercise2 {

    public static int process(int[] arr,int n,int k){
        if(arr==null || arr.length<0)
            return 0;
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]==1)
                count++;
        }
        if(count<=k)
            return n;
        return 0;
    }

    public static class Node{
        public int value;
        public int key;
        public Node pre;
        public Node next;

        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }

    public static class DoubleLinkedList{
        public Node head;
        public Node tail;

        public DoubleLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void add(Node node){
            if(node==null)
                return;
            if(head==null){
                this.head=node;
                this.tail=tail;

            }else{
                this.tail.next=node;
                node.pre=tail;
                tail=node;
            }

        }

        public void removeHead(){
            if(head==null)
                return;
            if(head==tail){
                this.head=null;
                this.tail=null;
            }
            head=head.next;
            head.pre=null;
        }

        public void removeToTail(Node node){
            if(head==null || head==tail || tail==head)
                return;
            if(this.head==node){
                head=head.next;
                head.pre=null;
            }else{
                node.pre.next=node.next;
                node.next.pre=node.pre;
            }

            tail.next=node;
            node.pre=tail;
            node.next=null;
            tail=node;
        }

        public static class Cache{
            public DoubleLinkedList linkedList;
            public HashMap<Integer,Node> map;
            public int capacity;
            public int len;

            public Cache(int capacity) {
                this.capacity = capacity;
                this.len=0;
                this.map=new HashMap<>();
                this.linkedList=new DoubleLinkedList();
            }

            public Integer get(Integer key){
                Integer res=-1;
                if(map.containsKey(key)){
                    Node node=map.get(key);
                    linkedList.removeToTail(node);
                    return node.value;

                }

                return res;
            }

            public void put(Integer key,Integer value){
                if(map.containsKey(key)){
                    Node node = map.get(key);
                    node.value=value;
                    linkedList.removeToTail(node);
                }else {
                    if(len==capacity){
                        linkedList.removeHead();
                        len--;
                    }
                    Node node=new Node(key,value);
                    map.put(key,node);
                    linkedList.add(node);
                    len++;

                }



            }
        }
    }





    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int dest=sc.nextInt();
        int[][] arr=new int[n][3];
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();

            arr[i][2]=sc.nextInt();
            if(arr[i][1]<=dest && dest<=arr[i][2]);
            list.add(arr[i][0]);

        }
        if(list.isEmpty())
            System.out.println("null");
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }
}
