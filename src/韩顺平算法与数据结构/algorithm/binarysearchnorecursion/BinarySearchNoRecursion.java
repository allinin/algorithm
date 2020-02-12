package 韩顺平算法与数据结构.algorithm.binarysearchnorecursion;

public class BinarySearchNoRecursion {

    public static void main(String[] args) {

        int[] arr=new int[]{0,1,3,5,7,8,9,12};
        System.out.println(binarySearchRecursion(arr,4,0,arr.length-1));;
        System.out.println(binarySearch2(arr,3));
    }

    //非递归方式
     public static int  binarySearch1(int[] arr,int value)
     {   int left=0;
         int right=arr.length;
         int mid=0;
         while(left<right)
         {
             mid=(left+right)/2;
             if(arr[mid]==value)
             {
                 return mid;
             }else if(arr[mid]<value)
             {
                 left=mid+1;
             }else {
                 right=mid;
             }
         }
         return arr[left]==value? left:-1;//不存在，没有找到要求的值。
     }
    //非递归方式2
     public static int  binarySearch2(int[] arr,int value)
    {   int left=0;
        int right=arr.length-1;
        int mid=0;
        while(left<=right)
        {
            mid=(left+right)/2;
            if(arr[mid]==value)
            {
                return mid;
            }else if(arr[mid]<value)
            {
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return -1;//不存在，没有找到要求的值。
    }
     //递归实现二分查找
    public static int binarySearchRecursion(int[] arr,int value,int left,int right)
    {
        int mid=(left+right)/2;
        if(left>right)
        {
            return -1;
        }
        if(arr[mid]==value)
        {
            return mid;
        }else if(arr[mid]<value){
           return binarySearchRecursion(arr,value,mid+1,right);
        }else {
            return binarySearchRecursion(arr,value,left,mid-1);
        }


    }
}
