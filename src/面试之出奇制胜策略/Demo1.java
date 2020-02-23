package 面试之出奇制胜策略;

import java.util.Objects;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2020/2/15 9:18
 */
public class Demo1 {

    public static void main(String[] args) {
        String str="abc";
        //判断str是否等于abc的写法
        System.out.println(str.equals("abc"));//最普遍的写法
        System.out.println("abc".equals(str));//建议写法一
        System.out.println(Objects.equals(str,"abc"));//建议写法二
    }
}
