package 公司真题;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author zbl
 * @version 1.0
 * @content:链接：https://www.nowcoder.com/questionTerminal/3da4aeb1c76042f2bc70dbcb94513338
来源：牛客网

设计一个数据结构，实现LRU Cache的功能(Least Recently Used – 最近最少使用缓存)。它支持如下2个操作： get 和 put。

int get(int key) – 如果key已存在，则返回key对应的值value（始终大于0）；如果key不存在，则返回-1。
void put(int key, int value) – 如果key不存在，将value插入；如果key已存在，则使用value替换原先已经存在的值。如果容量达到了限制，LRU Cache需要在插入新元素之前，将最近最少使用的元素删除。

请特别注意“使用”的定义：新插入或获取key视为被使用一次；而将已经存在的值替换更新，不算被使用。

限制：请在O(1)的时间复杂度内完成上述2个操作。
 * @date 2020/4/1 10:55
 */
public class Test2 {
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
                this.tail=node;

            }else{
                this.tail.next=node;
                node.pre=tail;
                tail=node;
            }

        }

        public Node removeHead(){
            if(head==null)
                return null;
            Node res=this.head;
            if(head==tail){
                this.head=null;
                this.tail=null;
                return res;
            }
            head=head.next;
            head.pre=null;
            return res;
        }

        public void removeToTail(Node node){
            if(head==null || head==tail || tail==node)
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
                //linkedList.removeToTail(node);
            }else {
                if(capacity==0)
                    return;
                if(len==capacity){
                    Node node = linkedList.removeHead();
                    map.remove(node.key);
                    len--;
                }
                Node node=new Node(key,value);
                map.put(key,node);
                linkedList.add(node);
                len++;

            }
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Cache cache=new Cache(n);
        while(sc.hasNext()){
            String[] sts=sc.nextLine().trim().split(" ");
            if(sts[0].equals("p")){
                int key=Integer.valueOf(sts[1]);
                int val=Integer.valueOf(sts[2]);
                cache.put(key,val);
            }
            if(sts[0].equals("g")){
                System.out.println(cache.get(Integer.valueOf(sts[1])));
            }
        }
    }
}
