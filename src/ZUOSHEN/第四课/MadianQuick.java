package ZUOSHEN.第四课;

import Gof.command.Command;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MadianQuick {

    public static class MedianHolder{
        private PriorityQueue<Integer>maxheap=new PriorityQueue<>(new MaxHeapComparator());
        private PriorityQueue<Integer>minheap=new PriorityQueue<>(new MinHeapComparator());

        public void modifyTwoHeapSize(){
            if(this.maxheap.size()==this.minheap.size()+2)
            {
                this.minheap.add(this.maxheap.poll());
            }
            if(this.minheap.size()==this.maxheap.size()+2)
            {
                this.maxheap.add(this.minheap.poll());
            }
        }

        public void addNumber(int num)
        {
            if(this.maxheap.isEmpty())
            {
                this.maxheap.add(num);
                return;

            }
            if(this.maxheap.peek()>=num)
            {
                this.maxheap.add(num);
            }else{
                if(this.minheap.isEmpty())
                {
                    this.minheap.add(num);
                    return;
                }
                if(this.minheap.peek()>=num)
                    this.maxheap.add(num);
                else{
                    this.minheap.add(num);
                }
            }
            modifyTwoHeapSize();
        }

        public Integer getMedian()
        {
            int maxHeapSize=maxheap.size();
            int minHeapSize=minheap.size();

            if(maxHeapSize+minHeapSize==0)
                return null;
            Integer maxHeapHead=this.maxheap.peek();
            Integer minHeapHead=this.minheap.peek();
            if(((maxHeapSize+minHeapSize)&1)==0)
            {
                return (maxHeapHead+minHeapHead)/2;
            }
            return maxHeapSize>minHeapSize ? maxHeapHead:minHeapHead;

        }
    }


    public static class MaxHeapComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return -(o1-o2);
        }
    }

    public static class MinHeapComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return (o1-o2);
        }
    }

    // for test
    public static int[] getRandomArray(int maxLen, int maxValue) {
        int[] res = new int[(int) (Math.random() * maxLen) + 1];
        for (int i = 0; i != res.length; i++) {
            res[i] = (int) (Math.random() * maxValue);
        }
        return res;
    }

    // for test, this method is ineffective but absolutely right
    public static int getMedianOfArray(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(newArr);
        int mid = (newArr.length - 1) / 2;
        if ((newArr.length & 1) == 0) {
            return (newArr[mid] + newArr[mid + 1]) / 2;
        } else {
            return newArr[mid];
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        boolean err = false;
        int testTimes = 200000;
        for (int i = 0; i != testTimes; i++) {
            int len = 30;
            int maxValue = 1000;
            int[] arr = getRandomArray(len, maxValue);
            MedianHolder medianHold = new MedianHolder();
            for (int j = 0; j != arr.length; j++) {
                medianHold.addNumber(arr[j]);
            }
            if (medianHold.getMedian() != getMedianOfArray(arr)) {
                err = true;
                printArray(arr);
                break;
            }
        }
        System.out.println(err ? "Oops..what a fuck!" : "today is a beautiful day^_^");

    }
}
