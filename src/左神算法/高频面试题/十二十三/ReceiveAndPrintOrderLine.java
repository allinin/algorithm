package 左神算法.高频面试题.十二十三;

import java.util.HashMap;

/**
 * @author zbl
 * @version 1.0
 * @content: 一种消息接收并打印的结构设计。
 * 已知一个消息流会不断的吐出整数1~N，但不一定按顺序吐出。如果上次打印的数为i,那么当i+1出现时，请打印i+1及
 * 其之后接受过的并且连续的所有数，知道1~N全部接受并打印完毕，请设计这种接受并打印的结构。
 *
 * @date 2020/2/6 18:11
 */
public class ReceiveAndPrintOrderLine {

     public static class Node{
         public int num;
         public Node next;

         public Node(int num){
             this.num=num;
         }
     }

     public static class MessageBox{

         public HashMap<Integer,Node> headMap;
         public HashMap<Integer,Node> tailMap;
         public int lastPrint;

         public MessageBox() {
             this.lastPrint =0;
             headMap=new HashMap<>();
             tailMap=new HashMap<>();
         }

         public  void receive(int num){
             if(num<1)
                 return;
             Node cur=new Node(num);
             headMap.put(num,cur);
             tailMap.put(num,cur);
             if(headMap.containsKey(num+1))
             {
                 cur.next=headMap.get(num+1);
                 headMap.remove(num+1);
                 tailMap.remove(num);
             }
             if(tailMap.containsKey(num-1))
             {
                 tailMap.get(num-1).next=cur;
                 tailMap.remove(num-1);
                 headMap.remove(num);
             }
             if(headMap.containsKey(lastPrint+1))
                 print();
         }

         public void print(){
             Node cur=headMap.get(++lastPrint);
             headMap.remove(lastPrint);
             while(cur!=null){
                 System.out.print(cur.num+" ");
                 cur=cur.next;
                 lastPrint++;
             }
             tailMap.remove(--lastPrint);
             System.out.println();

         }
     }

    public static void main(String[] args) {
        // MessageBox only receive 1~N
        MessageBox box = new MessageBox();

        box.receive(2); // - 2
        box.receive(1); // 1 2 -> print, trigger is 1

        box.receive(4); // - 4
        box.receive(5); // - 4 5
        box.receive(7); // - 4 5 - 7
        box.receive(8); // - 4 5 - 7 8
        box.receive(6); // - 4 5 6 7 8
        box.receive(3); // 3 4 5 6 7 8 -> print, trigger is 3

        box.receive(9); // 9 -> print, trigger is 9

        box.receive(10); // 10 -> print, trigger is 10

        box.receive(12); // - 12
        box.receive(13); // - 12 13
        box.receive(11); // 11 12 13 -> print, trigger is 11

    }

}
