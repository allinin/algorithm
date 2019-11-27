package ZUOSHEN.MaxABSBetweenLeftAndRight.Sort;

public class MergeSort {

    public static void mergerSort(int[] arr)
    {
        if(arr==null || arr.length==0)
            return;
        mergerSort(arr,0,arr.length-1);
    }

    public static void mergerSort(int[] arr,int start ,int end)
    {
        int mid=start+((end-start)>>1);
        mergerSort(arr,start,mid);
        mergerSort(arr,mid+1,end);
        merger(arr,start,mid,end);

    }

    public static void merger(int[] arr,int start,int mid,int end)
    {
        int[] help=new int[end-start+1];
        int i=0;
        int p1=start;
        int p2=mid+1;
        while(p1<=mid && p2<=end)
        {
            help[i++]=(arr[p1]<=arr[p2])? arr[p1++]:arr[p2++];
        }
        while(p1<=mid)
        {
            help[i++]=arr[p1++];
        }
        while(p2<=end)
        {
            help[i++]=arr[p2++];
        }
        for(int j=0;j<help.length;j++)
        {
            arr[start+j]=help[j];
        }
    }
}
