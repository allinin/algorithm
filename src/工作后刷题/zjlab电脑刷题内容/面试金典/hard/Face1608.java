package 工作后刷题.zjlab电脑刷题内容.面试金典.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZBL
 * @Date: 2024-01-11  14:56
 * 给定一个整数，打印该整数的英文描述。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: "One Hundred Twenty Three"
 * 示例 2:
 * <p>
 * 输入: 12345
 * 输出: "Twelve Thousand Three Hundred Forty Five"
 * 示例 3:
 * <p>
 * 输入: 1234567
 * 输出: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 示例 4:
 * <p>
 * 输入: 1234567891
 * 输出: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 */
public class Face1608 {

    int[] nums = new int[]{100, 1000, 1000000, 1000000000};
    String[] words = new String[]{"Hundred", "Thousand", "Million", "Billion"};

    private String[] num0_19 = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] num0_90 = new String[]{"Zero", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    //万亿已经超过了int可以表示的范围，所以不可能是万亿
    public String numberToWords(int num) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if(num == 0) {
            return "Zero";
        }
        for (int i = 3; i >= 0; i--) {
            if (num >= nums[i]) {
                int idx = num / nums[i];
                list.add(numberToWords(idx));
                list.add(words[i]);
                num %= nums[i];
            }
        }
        //num已经小于100
        while (num > 0) {
            if (num >= 20) {
                list.add(num0_90[num / 10]);
                num %= 10;
            } else {
               list.add(num0_19[num]);
                break;
            }
        }
        return String.join(" ",list);
    }

    public static void main(String[] args) {
        System.out.println(new Face1608().numberToWords(1234567));
    }
}
