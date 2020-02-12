package 韩顺平算法与数据结构.datastructure.search;

import com.google.zxing.common.detector.WhiteRectangleDetector;

public class InsertValueSearch {
    public static void main(String[] args) {

    }

    public static int insertValueSearch(int[] arr,int low,int high,int findVal)
    {
        if(findVal<arr[0] || findVal>arr[high] || low > high)
        {
            return -1;
        }
        int mid=low+(high-low)*(findVal-arr[low])/(arr[high]-arr[low]);
        if(findVal>arr[mid])
        {
            return insertValueSearch(arr,mid+1,high,findVal);

        }else if(findVal<arr[mid])
        {
            return insertValueSearch(arr,low,mid-1,findVal);
        }else {
            return mid;
        }
    }
}
