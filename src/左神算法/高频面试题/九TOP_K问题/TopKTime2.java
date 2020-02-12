package 左神算法.高频面试题.九TOP_K问题;

import java.util.HashMap;

/**
 * @author zbl
 * @version 1.0
 * @content:设计并实现TopKRecord结构，可以不断地向其中加入字符串，并且可以根据字符串出现的情况随时打印加入次数最多前K个字符串，具体为：
 * 1.k在TopKRecord实例生成时随机指定，并且不再变化（k是构造函数的参数）
 * 2.含有add(String str)方法，即向TopKRecord中加入字符串
 * 3.含有printTopK()方法，即打印加入次数最多的前k个字符串，打印有哪些字符串和对应的次数即可，不要求严格按排名顺序打印
 * 要求：
 * 在任何时刻，add方法的时间复杂度不超过O(logk)
 * 在任何时刻，printTopk方法的时间复杂度不超过o(k)
 * @date 2020/1/16 16:29
 */
public class TopKTime2 {

    public static class Node{
        public String str;
        public int times;

        public Node(String str, int times) {
            this.str = str;
            this.times = times;
        }
    }

    public static class TopKRecord{
        public Node[] heap;
        public int index;
        public HashMap<String ,Node> strNodeMap;
        public HashMap<Node,Integer> nodeIndexMap;

        public TopKRecord(int size) {
            heap=new Node[size];
            index=0;
            strNodeMap=new HashMap<>();
            nodeIndexMap=new HashMap<>();
        }

        public void add(String str){
            Node cur=null;
            int preIndex=-1;//表示是否在堆中，如果不在堆中为-1，在堆中则是对应的下标
            if(!strNodeMap.containsKey(str)){
                cur=new Node(str,1);
                strNodeMap.put(str,cur);
                nodeIndexMap.put(cur,-1);
            }else{
                cur=strNodeMap.get(str);
                cur.times++;
                preIndex=nodeIndexMap.get(cur);
            }
            if(preIndex==-1){
                if(index==heap.length){
                    if(heap[0].times<cur.times){
                        nodeIndexMap.put(heap[0],-1);
                        nodeIndexMap.put(cur,0);
                        heap[0]=cur;
                        heapify(0,index);
                    }
                }else{
                    heap[index]=cur;
                    nodeIndexMap.put(cur,index);
                    heapInsert(index++);
                }
            }else{
                heapify(preIndex,index);
            }
        }

        public void printTopK(){
            System.out.println("Top: ");
            for(int i=0;i<heap.length;i++){
                if(heap[i]==null){
                    break;
                }
                System.out.println("Str: "+heap[i].str);
                System.out.println("Times: "+heap[i].times);
            }
        }

        public void heapInsert(int index){
            while(index!=0){
                int parent=(index-1)/2;
                if(heap[index].times<heap[parent].times){
                    swap(heap,index,parent);
                    index=parent;
                }else {
                    break;
                }
            }
        }

        public void swap(Node[] heap,int index1,int index2){
            //交换位置的同时，也交换在堆中的位置
            nodeIndexMap.put(heap[index1],index2);
            nodeIndexMap.put(heap[index2],index1);
            Node temp=heap[index1];
            heap[index1]=heap[index2];
            heap[index2]=temp;
        }

        public void heapify(int index,int heapsize){
            int left=index*2+1;
            while(left<heapsize){
                int longest=(left+1<heapsize) && heap[left].times<heap[left+1].times ? left+1:left;
                if(heap[longest].times<heap[index].times){
                    swap(heap,longest,index);
                }else {
                    break;
                }
                index=longest;
                left=index*2+1;
            }
        }
    }

    public static String[] generateRandomArray(int len, int max) {
        String[] res = new String[len];
        for (int i = 0; i != len; i++) {
            res[i] = String.valueOf((int) (Math.random() * (max + 1)));
        }
        return res;
    }

    public static void printArray(String[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TopKRecord record = new TopKRecord(2);
        record.add("zuo");
        record.printTopK();
        System.out.println("======");
        record.add("cheng");
        record.add("cheng");
        record.printTopK();
        System.out.println("0-----");
        record.add("Yun");
        record.add("Yun");
        record.printTopK();

    }

}
