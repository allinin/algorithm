package 左神算法.进阶班一.结构设计;

import java.util.HashMap;

/**
 * @author zbl
 * @version 1.0
 * @content: 设计可变更的缓存结构LRU
 * @date 2020/1/7 11:28
 */
public class LRU {

    public static class Node<k,v>{
        public k key;
        public v value;
        public Node last;
        public Node next;

        public Node(k key, v value) {
            this.key = key;
            this.value = value;
        }
    }

    public static class NodeDoubleLinkedList<k,v>{
        public Node<k,v>head;//头指针
        public Node<k,v>tail;//尾指针

        public NodeDoubleLinkedList() {
            this.head =null;
            this.tail =null;
        }


        public void addNode(Node node){
            if(node==null)
                return;
            if(head==null){
                this.head=node;
                this.tail=node;
            }else {
                this.tail.next=node;
                node.last=this.tail;
                this.tail=node;
            }
        }

        public  void moveNodeToTail(Node node){
            if(this.tail==node){//说明没有元素
                return;
            }
            if(this.head==node){
                this.head=node.next;
                this.head.last=null;
            }else{
                node.last.next=node.next;
                node.next.last=node.last;
            }
            node.last=this.tail;
            node.next=null;
            this.tail.next=node;
            this.tail=node;

        }

        public Node removeHead(){
            if(this.head==null)
                return null;
            Node res=this.head;
            if(this.head==this.tail){
                this.head=null;
                this.tail=null;
            }else{
                this.head=res.next;
                this.head.last=null;
                res.next=null;

            }
            return res;
        }
    }

    public static class MyCache<k,v>{
        private HashMap<k,Node<k,v>> keyNodeMap;
        private int capicity;
        private NodeDoubleLinkedList<k,v> nodeDoubleLinkedList;

        public MyCache(int capicity) {
            if(capicity<1){
                throw new RuntimeException("should be more than 0");
            }
            this.keyNodeMap=new HashMap<>();
            this.nodeDoubleLinkedList=new NodeDoubleLinkedList<>();
            this.capicity=capicity;
        }

        public v get( k key){
            if(this.keyNodeMap.containsKey(key))
            {
                Node<k, v> node= keyNodeMap.get(key);
                this.nodeDoubleLinkedList.moveNodeToTail(node);
                return node.value;
            }
            return null;
        }

        public void set(k k,v v){
            //Node node=new Node(k,v);
            if(this.keyNodeMap.containsKey(k))
            {
                Node<k, v> node = keyNodeMap.get(k);
                node.value=v;
                this.nodeDoubleLinkedList.moveNodeToTail(node);
            }else{
                Node node =new Node(k,v);
                this.keyNodeMap.put(k,node);
                this.nodeDoubleLinkedList.addNode(node);
                if(this.keyNodeMap.size()==capicity+1)
                {
                   this.removeMostUnusedCache();
                }
            }

        }

        public void removeMostUnusedCache(){
            Node node = this.nodeDoubleLinkedList.removeHead();
            keyNodeMap.remove(node.key);

        }
    }

    public static void main(String[] args) {
        MyCache<String, Integer> testCache = new MyCache<String, Integer>(3);
        testCache.set("A", 1);
        testCache.set("B", 2);
        testCache.set("C", 3);
        System.out.println(testCache.get("B"));
        System.out.println(testCache.get("A"));
        testCache.set("D", 4);
        System.out.println(testCache.get("D"));
        System.out.println(testCache.get("C"));

    }

}
