package 工作后刷题.zjlab电脑刷题内容.面试金典.easy;

/**
 * @Author: ZBL
 * @Date: 2024-01-11  09:03
 * <p>
 * 稀疏数组搜索。
 * 有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 * <p>
 * 示例1:
 * <p>
 * 输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 * 输出：-1
 * 说明: 不存在返回-1。
 * 示例2:
 * <p>
 * 输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 * 输出：4
 * 提示:
 * <p>
 * words的长度在[1, 1000000]之间
 */
public class Face1005 {

    public int findString(String[] words, String s) {
        int left = 0, right = words.length - 1;
        while (left < right) {
            while (left <= right && words[left].equals("")) left++;
            while (left <= right && words[right].equals("")) right--;
            if (left == right) {
                return words[left].equals(s) ? left : -1;
            }
            if (left < right) {
                int mid = left + (right - left) / 2;
                while (words[mid].equals("") && mid >= left) mid--;
                if (mid >= left && words[mid].compareTo(s) < 0) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return words[left].equals(s) ? left : -1;
    }
}
