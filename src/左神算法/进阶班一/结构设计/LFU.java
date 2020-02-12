package 左神算法.进阶班一.结构设计;

import java.util.HashMap;

/**
 * @author zbl
 * @version 1.0
 * @content: LFU算分的get,set操作实现，并且时间复杂度为O（1）
 * @date 2020/1/8 12:28
 */
public class LFU {

    public static class Node{
        public Integer key;
        public Integer value;
        public Integer times;
        public Node up;//利用up属性与down属性从而可以构建一个双端队列
        public Node down;

        public Node(int key, int value, int times) {
            this.key = key;
            this.value = value;
            this.times = times;
        }
    }


    public static class LFUCache{

        //又一个双端队列，其中的每个元素又是一个双端对列，即上文中的Node
        public static class NodeList{
            public Node head;
            public Node tail;//head与tail的times是相同的
            public NodeList last;
            public NodeList next;

            public NodeList(Node node){
                this.head=node;
                this.tail=node;
            }

            //没对一个元素操作，将他对应的结点放在最前面
            public void addNodeFromHead(Node newNode){
                newNode.down=head;
                head.up=newNode;
                head=newNode;
            }

            public boolean isEmpty(){
                return head==null;
            }
            public void deleteNode(Node node){
                if(head==tail){
                    head=null;
                    tail=null;
                }else{
                    if(head==node){
                        head=node.down;
                        head.up=null;
                    }else if(tail==node){
                        tail=node.up;
                        tail.down=null;
                    }else{
                        node.up.down=node.down;
                        node.down.up=node.up;
                    }
                }
                //与原链表断开
                node.up=null;
                node.down=null;
            }
        }

        private int capacity;
        private int size;
        private HashMap<Integer,Node> records;
        private HashMap<Node,NodeList> heads;
        private NodeList headList;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.size=0;
            this.records=new HashMap<>();
            this.heads=new HashMap<>();
            headList=null;
        }


        public void set(int key,int value){
            if(records.containsKey(key)){
                Node node = records.get(key);
                node.times++;
                node.value=value;
                NodeList curList = heads.get(node);
                move(node,curList);

            }else{
                if(size==capacity){
                    Node node=headList.tail;
                    headList.deleteNode(node);
                    modifyHeadList(headList);
                    records.remove(node.key);
                    heads.remove(node);
                    size--;
                }
                Node node=new Node(key,value,1); //该node一定位于headlist
                if(headList==null){
                    headList=new NodeList(node);
                }else{
                    if(headList.head.times.equals(node.times)){
                        headList.addNodeFromHead(node);
                    }else{
                        NodeList newList=new NodeList(node);
                        newList.next=headList;
                        headList.last=newList;
                        headList=newList;
                    }
                }
                records.put(key,node);
                heads.put(node,headList);
                size++;
            }
        }

        public void move(Node node,NodeList oldNodeList){
            oldNodeList.deleteNode(node);//从当前nodelist删除该node
            NodeList preList=modifyHeadList(oldNodeList) ? oldNodeList.last:oldNodeList;
            NodeList nextList=oldNodeList.next;
            if(nextList==null){
                NodeList newList=new NodeList(node);
                if(preList!=null){
                    preList.next=nextList;
                }
                newList.last=preList;
                if(headList==null){
                    headList=newList;
                }
                heads.put(node,newList);

            }else{
                if(nextList.head.times.equals(node.times))
                {
                    nextList.addNodeFromHead(node);
                    heads.put(node,nextList);
                }else{
                    NodeList newList=new NodeList(node);
                    if(preList!=null){
                        preList.next=nextList;
                    }
                    newList.last=preList;
                    newList.next=nextList;
                    nextList.last=newList;
                    if(headList==nextList){
                        headList=newList;
                    }
                    heads.put(node,newList);
                }

            }

        }

        //return whether delete this nodelist.当nodelist为空的时候，删除，否则不删。
        private boolean modifyHeadList(NodeList nodeList){
            if(nodeList.isEmpty()){
                if(headList==nodeList)
                {
                    headList=headList.next;
                    if(headList!=null){
                        headList.last=null;
                    }
                }else{
                    nodeList.last.next=nodeList.next;
                    if(nodeList.next!=null){
                        nodeList.next.last=nodeList.last;
                    }
                }
                return true;

            }
            return false;
        }

        public int get(int key){
            if(!records.containsKey(key))
            {
                return -1;
            }
            Node node = records.get(key);
            node.times++;
            NodeList nodeList = heads.get(node);
            move(node,nodeList);
            return node.value;


        }



    }

}
