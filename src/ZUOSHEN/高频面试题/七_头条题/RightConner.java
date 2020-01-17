package ZUOSHEN.高频面试题.七_头条题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author zbl
 * @version 1.0
 * @content:  p为给定的二维平面整数点集。定义p中某点x,如果x满足p中任意点都不在x的右上方区域内（横纵坐标都大于x）,则称其为最大的。求出所有最大点的集合。（所有点的横纵坐标都不重复）
 * @date 2020/1/12 13:34
 */
public class RightConner {

    //用一个类来封装x,y坐标
    public static class Node{
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    //横纵坐标都不重复的情况
    public static class MyComparator1 implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.x-o2.x;
        }
    }
    //存在纵坐标相同的情况下，在横坐标相同的情况下，纵坐标按照从大到小排
    public static class MyComparator2 implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            if(o1.x!=o2.x){
                return o1.x-o2.x;
            }else{
                return o2.y-o1.y;
            }

        }
    }
    //在横坐标存在相同元素的情况下，只需要将比较器换成MyCompartor2
    public static LinkedList<Node> getRightCornerNodes1(int[] x,int[] y){
        int len=x.length;
        Node[] nodes=new Node[len];
        for(int i=0;i<len;i++){
            nodes[i]=new Node(x[i],y[i]);
        }
        Arrays.sort(nodes,new MyComparator2());
        LinkedList<Node>res=new LinkedList<>();
        res.add(nodes[len-1]);
        int temp=nodes[len-1].y;
        for(int i=len-2;i>-1;i--){
            if(nodes[i].y>=temp){
                //temp=nodes[i].y;
                res.addFirst(nodes[i]);
            }
            temp=Math.max(temp,nodes[i].y);
        }

        return res;
    }
    //暴力解
    public static LinkedList<Node> getRightCornerNodes2(int[] x, int[] y) {
        int size = x.length;
        LinkedList<Node> res = new LinkedList<Node>();
        Node[] nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(x[i], y[i]);
        }
        Arrays.sort(nodes, new MyComparator2());
        for (int i = 0; i < size; i++) {
            boolean insert = true;
            for (int j = 0; j < size; j++) {
                if ((nodes[i].x < nodes[j].x) && (nodes[i].y < nodes[j].y)) {
                    insert = false;
                }
            }
            if (insert) {
                res.add(nodes[i]);
            }
        }
        return res;
    }




    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        return arr;
    }

    public static boolean isEqual(LinkedList<Node> list1, LinkedList<Node> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        while (!list1.isEmpty()) {
            Node node1 = list1.pollFirst();
            Node node2 = list2.pollFirst();
            if (node1.x != node2.x || node1.y != node2.y) {
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] x, int[] y) {
        for (int i = 0; i < x.length; i++) {
            System.out.print("(" + x[i] + "," + y[i] + ") ");
        }
        System.out.println();
    }

    public static void printLinkedList(LinkedList<Node> list) {
        for (Node node : list) {
            System.out.print("(" + node.x + "," + node.y + ") ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTime = 3000000;
        for (int i = 0; i < testTime; i++) {
            int size = 3;
            int[] x = generateRandomArray(size);
            int[] y = generateRandomArray(size);
            LinkedList<Node> res1 = getRightCornerNodes1(x, y);
            LinkedList<Node> res2 = getRightCornerNodes2(x, y);
            if (!isEqual(res1, res2)) {
                printArray(x, y);
                printLinkedList(res1);
                printLinkedList(res2);
                break;
            }
        }
    }


}
