package ZUOSHEN.进阶班一.Manacher;

/**
 * manacher算法实现过程
 */
public class Manacher {

    //构造manacher 字符数组
    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];//即实现了在偶数下标位置插入#，奇数下标位置插入原来的字符数组的响
        }
        return res;
    }

    public static int maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length];//回文半径数组
        int index = -1;//回文中心
        int pR = -1;//最大回文右边界
        int max = Integer.MIN_VALUE;
        for (int i = 0; i != charArr.length; i++) {
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
                    pArr[i]++;
                else {
                    break;
                }
            }
            if (i + pArr[i] > pR) {
                pR = i + pArr[i];
                index = i;
            }
            max = Math.max(max, pArr[i]);//因为pArr[i]是manacher数组的回文半径，也就是原字符数组
            // 的回文直径+1了
        }
        return max - 1;//自己举个例子看看
    }
    public static void main(String[] args) {
        String str1 = "aqwqab";
        System.out.println(maxLcpsLength(str1));
    }
}
