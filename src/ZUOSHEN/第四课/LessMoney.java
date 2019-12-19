package ZUOSHEN.第四课;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LessMoney {

    public static int lessMoney(int[] arr)
    {
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++)
        {
            queue.add(arr[i]);
        }
        int sum=0;
        int cur=0;
        while(queue.size()>1)
        {
            cur=queue.poll()+queue.poll();
            sum+=cur;
            queue.add(cur);
        }
        return sum;

    }



    public static class MinheapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }

    }

    public static class MaxheapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }

    }
    public static void main(String[] args) {
        // solution
        int[] arr = { 6, 7, 8, 9 };
        System.out.println(lessMoney(arr));

        int[] arrForHeap = { 3, 5, 2, 7, 0, 1, 6, 4 };

        // min heap
        PriorityQueue<Integer> minQ1 = new PriorityQueue<>();
        for (int i = 0; i < arrForHeap.length; i++) {
            minQ1.add(arrForHeap[i]);
        }
        while (!minQ1.isEmpty()) {
            System.out.print(minQ1.poll() + " ");
        }
        System.out.println();

        // min heap use Comparator
        PriorityQueue<Integer> minQ2 = new PriorityQueue<>(new MinheapComparator());
        for (int i = 0; i < arrForHeap.length; i++) {
            minQ2.add(arrForHeap[i]);
        }
        while (!minQ2.isEmpty()) {
            System.out.print(minQ2.poll() + " ");
        }
        System.out.println();

        // max heap use Comparator
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(new MaxheapComparator());
        for (int i = 0; i < arrForHeap.length; i++) {
            maxQ.add(arrForHeap[i]);
        }
        while (!maxQ.isEmpty()) {
            System.out.print(maxQ.poll() + " ");
        }

    }
}
