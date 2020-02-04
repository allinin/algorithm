package ZUOSHEN.进阶班一.BFPRT;

/**
 * @author zbl
 * @version 1.0
 * @content: bfprt算法的实现，主要用来求：找出一个数组中前k小，或者前k大的数字，返回的是一个长度为k的数组。
 * @date 2019/12/28 13:50
 */
public class BFPRT {

    // O(N*logK),找出数组中最小的k个数
    public static int[] getMinKNumsByHeap(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            return arr;
        }
        int[] kHeap = new int[k];
        for (int i = 0; i != k; i++) {
            heapInsert(kHeap, arr[i], i);
        }
        for (int i = k; i != arr.length; i++) {
            if (arr[i] < kHeap[0]) {
                kHeap[0] = arr[i];
                heapify(kHeap, 0, k);
            }
        }
        return kHeap;
    }

    public static void heapInsert(int[] arr, int value, int index) {
        arr[index] = value;
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (arr[parent] < arr[index]) {
                swap(arr, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        while (left < heapSize) {
            if (arr[left] > arr[index]) {
                largest = left;
            }
            if (right < heapSize && arr[right] > arr[largest]) {
                largest = right;
            }
            if (largest != index) {
                swap(arr, largest, index);
            } else {
                break;
            }
            index = largest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }
    //自己实现
    public static int[] getKNumsByHeap(int[] arr,int k){
        if(arr==null || arr.length<k)
            return null;
        int[] res=new int[k];
        for(int i=0;i<k;i++)
        {
            heapInsert(res,arr[i],i);
        }
        for(int i=k;i<arr.length;i++)
        {
            if(arr[i]<res[0])
            {
                res[0]=arr[i];
                heapify(res,0,k);
            }
        }
        return res;

    }
    public static void heapInsert2(int[] arr,int value,int index){

        arr[index]=value;
        int parent=(index-1)/2;
        while(arr[parent]<arr[index])
        {  swap(arr,index,parent);
           index=parent;
           parent=(index-1)/2;
        }

    }
    public static void heapify2(int[] arr,int index,int heapSize){
        int left=index*2+1;
        while(left<heapSize){
            int largest=(left+1<heapSize) && (arr[left] <arr[left+1])? left+1:left;
            if(arr[index]<arr[largest])
            {
                swap(arr,index,largest);
                index=largest;
                left=index*2+1;
            }else{
                break;
            }
        }

    }


    //O(N) BFPRT的方式找出数组中最小的k个数
    public static int[] getMinKNumsByBFPRT(int[] arr,int k){

        if(k<1 || k>arr.length)
        {
            return null;
        }
        int minKthByBFPRT = getMinKthByBFPRT(arr, k);
        int[] res=new int[k];
        int index=0;
        for(int i=0;i!=arr.length;i++){
            if(arr[i]<minKthByBFPRT) //这里不能是<=，因为可能有多个相同的minKthByBFPRT
            {
                res[index++]=arr[i];
            }
        }
        //如果有多个相同的minKthByBFPRT，这里来补充
        for (; index != res.length; index++) {
            res[index] = minKthByBFPRT;
        }
        return res;
    }
    public static int getMinKthByBFPRT(int[] arr,int k){
        int[] copyArr=copyArray(arr);
        return select(copyArr,0,copyArr.length-1,k-1);
    }
    public static int[] copyArray(int[] arr){
        int[] copyArr=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            copyArr[i]=arr[i];
        }
        return copyArr;
    }
    /**
    *@param ：i表示第i小的数
    *@return
    */

    public static int select(int[] arr, int begin, int end, int i) {
        if (begin == end) {
            return arr[begin];
        }
        int pivot = medianOfMedians(arr, begin, end);
        int[] pivotRange = partition(arr, begin, end, pivot);
        if (i >= pivotRange[0] && i <= pivotRange[1]) {
            return arr[i];
        } else if (i < pivotRange[0]) {
            return select(arr, begin, pivotRange[0] - 1, i);
        } else {
            return select(arr, pivotRange[1] + 1, end, i);
        }
    }

   public static int[] partition(int[] arr,int begin,int end,int num)
   {
      int small=begin-1;
      int cur=begin;
      int big=end+1;
      while(cur!=big)
      {
          if(arr[cur]<num)
          {
              swap(arr,++small,cur++);
          }else if(arr[cur]>num)
          {
              swap(arr,--big,cur);
          }else{
              cur++;
          }
      }
      int[] pivotRange=new int[2];
      pivotRange[0]=small+1;
      pivotRange[1]=big-1;
      return pivotRange;
   }
//    public static int medianOfMedians(int[] arr,int begin,int end)
//    {
//        int num=end-begin+1;
//        int offset=num % 5==0 ? 0:1;
//        int[] mArr=new int[num/5+offset];
//        for(int i=0;i<mArr.length;i++)
//        {
//            int beginI=begin+i*5;
//            int endI=beginI+4;
//            mArr[i]=getMedian(arr,beginI,Math.min(end,endI));
//        }
//        return select(arr,0,mArr.length-1,mArr.length/2);
//    }
public static int medianOfMedians(int[] arr, int begin, int end) {
    int num = end - begin + 1;
    int offset = num % 5 == 0 ? 0 : 1;
    int[] mArr = new int[num / 5 + offset];
    for (int i = 0; i < mArr.length; i++) {
        int beginI = begin + i * 5;
        int endI = beginI + 4;
        mArr[i] = getMedian(arr, beginI, Math.min(end, endI));
    }
    return select(mArr, 0, mArr.length - 1, mArr.length/2);
}

    //求中位数
    public static int getMedian(int[] arr,int begin,int end){
        insertSort(arr,begin,end);
        int sum=(begin+end);
        int mid=sum/2+(sum%2);
        return arr[mid];
    }
    public static void insertSort(int[] arr,int begin,int end){
        for(int i=begin+1;i!=end+1;i++){
            for(int j=i;j!=begin;j--){
                if(arr[j-1]>arr[j]){
                    swap(arr,j-1,j);
                }else{
                    break;
                    }
            }
        }
    }

    public static void swap(int[]arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 6, 9, 1, 3, 1, 2, 2, 5, 6, 5, 5, 5, 9, 7, 2, 5, 6, 1, 9 };
        // sorted : { 1, 1, 1, 1, 2, 2, 2, 3, 3, 5, 5, 5, 6, 6, 6, 7, 9, 9, 9 }
        printArray(getMinKNumsByHeap(arr, 10));
        printArray(getMinKNumsByBFPRT(arr, 10));
        printArray(getKNumsByHeap(arr,10));

    }

}
