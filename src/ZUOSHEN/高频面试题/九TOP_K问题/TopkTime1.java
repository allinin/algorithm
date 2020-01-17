package ZUOSHEN.高频面试题.九TOP_K问题;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @author zbl
 * @version 1.0
 * @content: 给出次数的top k问题
 * 给定String类型的数组strArr，再给定整数k,请严格按照排名顺序打印出次数前k名的字符串。要求：strArr长度为N，时间复杂度为O（Nlogk)
 * @date 2020/1/16 16:27
 */
public class TopkTime1 {

    public static class Node {
        public String str;
        public int times;

        public Node(String s, int t) {
            str = s;
            times = t;
        }
    }

    public static void printTopKAndRank(String[] arr, int topK) {
        if (arr == null || topK < 1) {
            return;
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i != arr.length; i++) {
            String cur = arr[i];
            if (!map.containsKey(cur)) {
                map.put(cur, 1);
            } else {
                map.put(cur, map.get(cur) + 1);
            }
        }
        Node[] heap = new Node[topK];
        int index = 0;
        for (Entry<String, Integer> entry : map.entrySet()) {
            String str = entry.getKey();
            int times = entry.getValue();
            Node node = new Node(str, times);
            if (index != topK) {
                heap[index] = node;
                heapInsert(heap, index++);
            } else {
                if (heap[0].times < node.times) {
                    heap[0] = node;
                    heapify(heap, 0, topK);
                }
            }
        }
        //实现严格按照次数的多少从大到小排序
        for (int i = index - 1; i != 0; i--) {
            swap(heap, 0, i);//最小的放在最后
            heapify(heap, 0, i);
        }
        for (int i = 0; i != heap.length; i++) {
            if (heap[i] == null) {
                break;
            } else {
                System.out.print("No." + (i + 1) + ": ");
                System.out.print(heap[i].str + ", times: ");
                System.out.println(heap[i].times);
            }
        }
    }

    public static void heapInsert(Node[] heap, int index) {
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (heap[index].times < heap[parent].times) {
                swap(heap, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    public static void heapify(Node[] heap, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int smallest = index;
        while (left < heapSize) {
            if (heap[left].times < heap[index].times) {
                smallest = left;
            }
            if (right < heapSize && heap[right].times < heap[smallest].times) {
                smallest = right;
            }
            if (smallest != index) {
                swap(heap, smallest, index);
            } else {
                break;
            }
            index = smallest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }

    public static void swap(Node[] heap, int index1, int index2) {
        Node tmp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = tmp;
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
        String[] arr = generateRandomArray(50, 10);
        int topK = 5;
        printArray(arr);
        printTopKAndRank(arr, topK);

    }
}
