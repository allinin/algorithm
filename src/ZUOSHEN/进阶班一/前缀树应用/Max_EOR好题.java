package ZUOSHEN.进阶班一.前缀树应用;

/**
 * @author zbl
 * @version 1.0
 * @content: 给定一个数组，求子数组的最大异或和。一个数组的异或和为，数组中所有的数异或起来的结果
 * @date 2020/1/14 10:49
 */
public class Max_EOR好题 {


    //暴力解，以每一个位置结尾分别求异或和，O（n^3)
    public static int getMaxE1(int [] arr){
       if(arr==null || arr.length==0)
       {
           return 0;
       }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int start=0;start<=i;start++){
                int res=0;
                for(int k=start;k<=i;k++)
                {
                    res^=arr[k];
                }
                max=Math.max(res,max);
            }
        }
        return max;
    }

    //使用一个数组记录0-i位置的异或和，使用到的结论：如果a^b=c，则：b=a^c,a=b^c.
    public static int getMaxE2(int [] arr){
        if(arr==null || arr.length==0)
        {
            return 0;
        }
        int max=Integer.MIN_VALUE;
        int[] dp=new int[arr.length];//dp[i]表示0-i的异或和
        int eor=0;
        for(int i=0;i<arr.length;i++){
            eor^=arr[i];//0...i的eor
            max=Math.max(eor,max);
            for(int start=1;start<=i;start++){
                int startToIEor=eor^dp[start-1];//使用到的结论：如果a^b=c，则：b=a^c,a=b^c.
                max=Math.max(max,startToIEor);
            }
            dp[i]=eor;
        }
        return max;
    }

    //使用trie Tree，将数组中的元素表示为二进制的形式.O(n)
    public static int maxXorSubarray(int[] arr){
        if(arr==null || arr.length==0)
            return 0;
        int max=Integer.MIN_VALUE;
        int eor=0;
        NumTrie numTrie=new NumTrie();
        numTrie.add(0);//一开始传入0值，在不影响结果的前提下，使maxXor算法运行下去
        for(int i=0;i<arr.length;i++){
            eor^=arr[i];
            max=Math.max(max,numTrie.maxXor(eor));//每次传入的是arr[0]-arr[i]的异或和，还是利用了a^b=c则a=b^c，b=a^c
            numTrie.add(eor);//将arr中0-i的异或和放入numTrie中，
        }
        return max;
    }


    public static class Node{
        public Node[] nexts=new Node[2];//只有0,1两条路走
    }

    public static class NumTrie{
        public Node head=new Node();

        //传入0-i的异或和
        public void add(int num){
            Node cur=head;
            for(int move=31;move>=0;move--){
                int path=(num>>move) & 1;//判断num每一位的值，0/1
                cur.nexts[path]=cur.nexts[path]==null ? new Node():cur.nexts[path];
                cur=cur.nexts[path];
            }
        }
           //传入的num是数组中arr[0]-arr[i]的异或和。
        public int maxXor(int num){
            Node cur=head;
            int res=0;
            for(int move=31;move>-1;move--){
                int path=(num>>move) & 1; //求对应为的值
                //best是指期望获得值，选择最优路径.move==31时，选择的是数子的符号位，此时希望选择路和符号位相同，不是符号位时，相反
                int best=move==31 ? path:(path ^ 1);
                //实际可以选择的值,看看有没有期望的值，best ^1相当于取反，相应的位置1变成0,0变成1
                best=cur.nexts[best]!=null ? best:(best ^ 1);
                res|=(path ^ best)<<move;//异或，设置答案的每一位
                cur=cur.nexts[best];
            }
            return res;
        }
    }
    // for test
    public static int comparator(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int eor = 0;
            for (int j = i; j < arr.length; j++) {
                eor ^= arr[j];
                max = Math.max(max, eor);
            }
        }
        return max;
    }
    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 30;
        int maxValue = 50;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int res = maxXorSubarray(arr);
            int comp = comparator(arr);
            if (res != comp) {
                succeed = false;
                printArray(arr);
                System.out.println(res);
                System.out.println(comp);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }




}
