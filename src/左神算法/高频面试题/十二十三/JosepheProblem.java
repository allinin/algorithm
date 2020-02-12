package 左神算法.高频面试题.十二十三;

/**
 * @author zbl
 * @version 1.0
 * @content: 约瑟夫环形链表问题。
 * @date 2020/2/5 16:20
 */
public class JosepheProblem {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node josephusKill1(Node head, int m) {
        if (head == null || head.next == head || m < 1) {
            return head;
        }
        Node last = head;
        while (last.next != head) {
            last = last.next;
        }
        int count = 0;
        while (head != last) {
            if (++count == m) {
                last.next = head.next;
                count = 0;
            } else {
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }
    //O(n)
    public static Node josephusKill2(Node head,int m){
        if(head==null || head.next==head || m<1){
            return head;
        }
        Node cur=head;
        int temp=1; //记录总个数
        while(cur.next!=head){
            temp++;
            cur=cur.next;
        }
        int live = getLive(temp, m);//存活下来的人最开始的编号
        while(--live!=0){
            head=head.next;

        }
        head.next=head;
        return head;
    }
     //得到活下来的人的最初的编号
    public static int getLive(int i,int m){ //i表示所有中最后一个人的编号，m:报数为m的人杀死
        if(i==1)
            return 1;
        return (getLive(i-1,m)+m-1)%i+1;
    }

    public static void printCircularList(Node head) {
        if (head == null) {
            return;
        }
        System.out.print("Circular List: " + head.value + " ");
        Node cur = head.next;
        while (cur != head) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println("-> " + head.value);
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = head1;
        printCircularList(head1);
        head1 = josephusKill1(head1, 3);
        printCircularList(head1);

        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(5);
        head2.next.next.next.next.next = head2;
        printCircularList(head2);
        head2 = josephusKill2(head2, 3);
        printCircularList(head2);

    }
}
