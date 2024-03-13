package 工作后刷题.zjlab电脑刷题内容.二分题目合集.二分答案;

/**
 * @Author:zbl
 * @Date:2024/1/10 21:33
 * <p>
 * 搜索旋转数组。
 * 给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。
 * 请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。
 * <p>
 * 示例1:
 * <p>
 * 输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
 * 输出: 8（元素5在该数组中的索引）
 * 示例2:
 * <p>
 * 输入：arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 11
 * 输出：-1 （没有找到）
 * 提示:
 * <p>
 * arr 长度范围在[1, 1000000]之间
 */
public class Face1003_必看题 {

    //本题解法
    public static int search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        //去除翻转后头尾元素相等的情况
        while (arr[left] == arr[right]) {
            if (arr[left] == target) {
                return left;
            }
            left++;
            right--;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            //[left ,mid]单调递增
            if (arr[left] < arr[mid]) {
                if (arr[left] <= target && arr[mid] >= target) {
                    right = mid;
                } else {
                    //arr[mid] < target,mid及mid左边的都不符合，舍掉
                    left = mid + 1;
                }
            } else if (arr[left] > arr[mid]) {
                //(mid,right]单调递增
                if (arr[mid] < target && arr[right] >= target) {
                    left = mid + 1;
                } else {
                    //arr[mid] >= target,mid右边的一定不符合要求，舍掉
                    right = mid;
                }
            } else {
                //left - mid相等的情况，如果==target,则直接返回left即可
                if (arr[left] == target) {
                    return left;
                } else {
                    //否则，舍弃掉left - mid范围的数
                    left = mid + 1;
                }
            }
        }
        return arr[left] == target ? left : -1;
    }


    //求最大索引的写法!!!!!!!!!!!!!!!!!!
    public static int search2(int[] arr, int target) {
        int n = arr.length;
        int left = 0, right = n - 1;
        while (arr[left] == arr[right]) {
            if (arr[left] == target) {
                return right;
            }
            left++;
            right--;
        }
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            //[mid,right]递增
            if (arr[mid] < arr[right]) {
                //最大索引一定不在mid左边，舍掉
                if (arr[mid] <= target && arr[right] >= target) {
                    left = mid;
                } else {
                    //mid > target,mid及右边的都不符合
                    right = mid - 1;
                }
            } else if (arr[mid] > arr[right]) {
                //[left,mid)递增
                //mid及右边的一定不符合
                if (arr[left] <= target && arr[mid] > target) {
                    right = mid - 1;
                } else {
                    //arr[mid] <= target,最大索引一定不在mid左边，所以mid左边的舍掉
                    left = mid;
                }
            } else {
                //[mid,right]相等
                if (arr[right] == target) {
                    return right;
                } else {
                    right = mid - 1;
                }
            }
        }
        return arr[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 6, 7,1, 2, 3, 4,};
        System.out.println(search2(arr, 6));
    }
}
