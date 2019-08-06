package datastructure.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9,9,9,9,9,9,9, 10 , 11, 12, 13,14,15,16,17,18,19,20 };
        System.out.println(binarySearch2(arr, 0,arr.length, 9));
    }

    public static int binarySearch(int[] arr,int left,int right,int findVal)
    {
        int mid=(left+right)/2;
        int midVal=arr[mid];
        if(left>right)
        {
            return -1;
        }
        if(midVal>findVal)
        {
            return binarySearch(arr,left,mid-1,findVal);

        }else if(midVal<findVal){
            return binarySearch(arr,mid+1,right,findVal);
        }else{
            return mid;
        }
    }

    //有多个相同的数值时，如何将所有的数值的位置都找到？
    /**
     * 思路分析：
     * 再找到mid索引值后，不要立马返回
     * 向mid索引的左边扫描，将所有满足元素的下标加入到集合ArrayList中
     * 向mid索引值的右边扫苗，将所有满足元素的下标加入到集合
     * 将ArrayList返回
     */

    public static List<Integer> binarySearch2(int[]arr,int left,int right,int findVal)
    {
        int mid=(left+right)/2;
        int midVal=arr[mid];
        if(left>right)
        {
            return new ArrayList<Integer>();
        }
        if(midVal>findVal)
        {
            return binarySearch2(arr,left,mid-1,findVal);

        }else if(midVal<findVal){
            return binarySearch2(arr,mid+1,right,findVal);
        }else{
            List<Integer> resIndexList=new ArrayList<>();
            int temp=mid-1;
            while(true)
            {
                if(temp<0 || arr[temp]!=findVal)
                {
                    break;
                }
                resIndexList.add(temp);
                temp--;
            }
            resIndexList.add(mid);
            temp=mid+1;
            while(true)
            {
                if(temp>arr.length-1 || arr[temp]!=findVal)
                {
                    break;
                }
                resIndexList.add(temp);
                temp++;
            }
            return resIndexList;
        }
    }
}
