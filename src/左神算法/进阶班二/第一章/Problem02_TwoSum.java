package 左神算法.进阶班二.第一章;

import java.util.Arrays;
import java.util.HashMap;

/*
   给定一个数组arr,和一个整数aim，请返回哪两个位置的数可以加出aim来。
 */
public class Problem02_TwoSum {

     public static int[] twoSum1(int[] arr,int aim){
         HashMap<Integer,Integer> map=new HashMap<>();
         for(int i=0;i<arr.length;i++){
             map.put(arr[i],i);
         }
         Arrays.sort(arr);
         int left=0;
         int right=arr.length-1;
         while(left<right){
             if(arr[left]+arr[right]<aim){
                 left++;
             }else if(arr[left]+arr[right]>aim){
                 right--;
             }else{
                 return new int[]{map.get(arr[left]),map.get(arr[right])};

             }
         }
         return new int[]{-1,-1};
     }
     //方法二：自定义堆排序的方式，然后左右指针移动
     public static int[] twoSum2(int[] arr,int aim){
         int [] indices=new int[arr.length];//用来记录数组中元素在数组中原来的位置，作用类似于上面方法的map
         for(int i=0;i<arr.length;i++){
             indices[i]=i;
         }
         sort(arr,indices);
         int left=0;
         int right=arr.length-1;
         int sum=0;
         while(left<right){
             sum=arr[left]+arr[right];
             if(sum<aim){
                 left++;
             }else if(sum>aim){
                 right--;
             }else {
                 return new int[]{indices[left],indices[right]};
             }
         }
         return new int[]{-1,-1};
     }

     public static void sort(int[] arr,int[] indices){
       for(int i=0;i<arr.length;i++){
           heapInsert(arr,indices,i);
       }
       int len=arr.length-1;
       while(len>0){
           swap(arr,indices,0,len);
           heapify(arr,indices,--len);
       }
     }
     //构造大根堆，
     public static void heapInsert(int[] arr,int[] indices,int i){
         while(i>0){
             int p=(i-1)/2;
             if(arr[p]<arr[i]){
                 swap(arr,indices,i,p);
                 i=p;
             }else{
                 break;
             }
         }
     }
     public static void heapify(int[] arr,int[] indices,int size){
         int index=0;
         int largest=1;
         while(largest<size){
             largest=(largest+1<size && arr[largest+1]>arr[largest])? largest+1:largest;
             if(arr[index]>=arr[largest]){
                 break;
             }else{
                 swap(arr,indices,index,largest);
                 index=largest;
                 largest=index*2+1;
             }
         }
     }
     //同时交换arr与indices相关联的元素
     public static void swap(int[] arr,int[] indices,int i,int j){
         int temp=arr[i];
         arr[i]=arr[j];
         arr[j]=temp;
         temp=indices[i];
         indices[i]=indices[j];
         indices[j]=temp;
     }

    public static void main(String[] args) {
        int[] arr=new int[]{1,24,3,4,5,8,10};
        int[] res= twoSum2(arr, 8);
        int[] arr1=new int[]{1,24,3,4,5,8,10};

        int[] res2 = twoSum1(arr1, 8);
        System.out.println(res[0]+" "+res[1]);
        System.out.println(res2[0]+" "+res2[1]);

    }
}
