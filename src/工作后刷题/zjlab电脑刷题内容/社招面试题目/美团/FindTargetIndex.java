package 工作后刷题.zjlab电脑刷题内容.社招面试题目.美团;

/**
 *
 * 给定一个数字数组d和数字a，其中数组d中数字顺序先下降后递增，找到数字a在数组d中的下标（如果没有则返回-1）
 * @author: ZBL
 * @date: 2024-10-12  09:12
 */
public class FindTargetIndex {

    //二分的做法,题目说先下降后递增说明了没有重复元素
    public static int findTargetIndex(int[] arr,int num) {
        if(arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0,right = arr.length - 1;
        while(left < right) {
            int mid = left +(right - left) / 2;
            //(mid,right]有序，为升序
            if(arr[mid] < arr[right]) {
                if(arr[mid] < num && arr[right] >= num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                // [left,mid]有序,为降序
                if(arr[left] >= num && arr[mid] <= num) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return arr[left] == num ? left : -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,4,1,2,3};
        int num = 0;
        System.out.println(findTargetIndex(arr,num));
    }

}
