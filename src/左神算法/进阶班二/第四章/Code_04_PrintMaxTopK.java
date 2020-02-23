package 左神算法.进阶班二.第四章;

import java.util.Arrays;

/**
 * @author zbl
 * @version 1.0
 * @content:题目四
打印N个数组整体最大的Top K
【题目】
有N个长度不一的数组，所有的数组都是有序的，请从大到小打
印这N个数组整体最大的前K个数。
例如，输入含有N行元素的二维数组可以代表N个一维数组。
219,405,538,845,971
148,558
52,99,348,691
再输入整数k=5，则打印：
Top 5: 971,845,691,558,538
【要求】
1．如果所有数组的元素个数小于K，则从大到小打印所有的数。
2．要求时间复杂度为O(KlogN)。
 * @date 2020/2/21 16:36
 */
public class Code_04_PrintMaxTopK {

    public static class Node{
        private int value;
        private int arrNum;
        private int index;

        public Node(int value, int arrNum, int index) {
            this.value = value;
            this.arrNum = arrNum;
            this.index = index;
        }
    }

    public static void printTopK(int[][] arr,int k){
        Node[] heap=new Node[arr.length];
        int heapSize=arr.length;
        for(int i=0;i<arr.length;i++){
            heap[i]=new Node(arr[i][arr[i].length-1],i,arr[i].length-1);
            heapInsert(heap,i);
        }
        System.out.println("Top "+k+": ");
        for(int i=0;i!=k;i++){
            if(heapSize==0)
                break;
            System.out.print(heap[0].value+" ");
            if(heap[0].index!=0){
                heap[0].value=arr[heap[0].arrNum][--heap[0].index];
            }else{
                swap(heap,0,--heapSize);
            }
            heapify(heap,0,heapSize);

        }


    }
    //heapInsert是从下往上调整，只要当前调整的坐标不是0，便进入判断调整
    public static void heapInsert(Node[] heap,int index){
        while(index!=0){
            int pre=(index-1)/2;

            if(heap[pre].value<heap[index].value){
                swap(heap,pre,index);
                index=pre;

            }else
                break;
        }
    }
     //heapfify是从上往下调整，可以设置调整的范围
    public static void heapify(Node[] heap,int index,int heapsize){
        int left=index*2+1;
        while(left<heapsize){
            int largest=(left+1)<heapsize && (heap[left].value<heap[left+1].value) ?left+1:left;
            if(heap[largest].value<=heap[index].value)
                break;
            else
            {
                swap(heap,largest,index);
                index=largest;
                left=2*index+1;
            }
        }
    }

    public static void swap(Node[] heap,int index,int pre){
        Node temp=heap[index];
        heap[index]=heap[pre];
        heap[pre]=temp;
    }

    //注意这种生成长度不同的数组的方式
    public static int[][] generateRandomMatrix(int maxRow, int maxCol,
                                               int maxValue) {
        if (maxRow < 0 || maxCol < 0) {
            return null;
        }
        int[][] matrix = new int[(int) (Math.random() * maxRow) + 1][];
        for (int i = 0; i != matrix.length; i++) {
            matrix[i] = new int[(int) (Math.random() * maxCol) + 1];
            for (int j = 0; j != matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * maxValue);
            }
            Arrays.sort(matrix[i]);
        }
        return matrix;
    }

    //自己手写一遍上面的实现方法
    public static int[][] generateRandomMatrix2(int maxrow,int maxcol,int maxValue){
        if(maxcol==0 || maxrow==0)
            return null;
        int[][] matrix=new int[(int)(Math.random()*maxrow)+1][];
        for(int i=0;i<matrix.length;i++){
            matrix[i]=new int[(int)(Math.random()*maxcol)+1];
            for(int j=0;j<matrix[i].length;j++){
                matrix[i][j]=(int)(Math.random()*maxValue);
            }
            Arrays.sort(matrix[i]);
        }

        return matrix;

    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = generateRandomMatrix(5, 10, 1000);
        printMatrix(matrix);
        System.out.println("===========================");
        printTopK(matrix, 10);
    }

}
