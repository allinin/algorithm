package ZUOSHEN.基础班.第三课;

public class SmallerEqualBigger {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node listPartition1(Node head,int pivot)
    {
        if(head==null)
            return head;
        Node cur=head;
        int count=0;
        while(cur!=null)
        {
            count++;
            cur=cur.next;
        }
        Node[] nodeArr=new Node[count];
        cur=head;
        for(int i=0;i<count;i++)
        {
            nodeArr[i]=cur;
            cur=cur.next;
        }
        arrPartition(nodeArr,pivot);
        for(int i=1;i<count;i++)
        {
            nodeArr[i-1].next=nodeArr[i];
        }
        nodeArr[count-1].next=null;
        return nodeArr[0];
    }
    public static void arrPartition(Node[]arr,int pivot)
    {
        int small=-1;
        int big=arr.length;
        int index=0;
        while(index!=big)
        {
            if(arr[index].value<pivot)
            {
                swap(arr,index++,++small);
            }else if(arr[index].value>pivot)
            {
                swap(arr,--big,index);
            }else {
                index++;
            }
        }

    }
    public static void swap(Node[]arr,int a,int b)
    {
        Node temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    //定义6个Node,分别用来指向小于，等于，大于pivot的结点的头和尾
    public static Node listPartition2(Node head,int pivot)
    {
        if(head==null)
            return head;
        Node sh=null;
        Node st=null;
        Node eh=null;
        Node et=null;
        Node bh=null;
        Node bt=null;
        Node next=null;

        while(head!=null)
        {
            next=head.next;//保留下一个节点
            head.next=null;//将当前遍历的结点单独拿出来
            if(head.value<pivot)
            {
                if(sh==null)
                {
                    sh=head;
                    st=head;
                }else {
                    st.next=head;
                    st=st.next;
                }
            }else if(head.value==pivot){
                if(eh==null)
                {
                    eh=head;
                    et=head;
                }else {
                    et.next=head;
                    et=et.next;
                }
            }else {
                if(bh==null)
                {
                    bh=head;
                    bt=head;
                }else {
                    bt.next=head;
                    bt=head;
                }
            }
            head=next;
        }
        if(st!=null)
        {
            st.next=eh;
            et=et==null?st:et;
        }
        if(et!=null)
        {
            et.next=bh;

        }
        return sh!=null?sh:eh!=null?eh:bh;

    }
    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        // head1 = listPartition1(head1, 4);
        head1 = listPartition2(head1, 5);
        printLinkedList(head1);

    }

}
