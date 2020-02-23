package 左神算法.进阶班二.第三章;

/**
 * @author zbl
 * @version 1将整数字符串转成整数值
【题目】
给定一个字符串str，如果str符合日常书写的整数形式，并且属于32
位整数的范围，返回str所代表的整数值，否则返回0。
【举例】
str="123"，返回123。
str="023"，因为"023"不符合日常的书写习惯，所以返回0。
str="A13"，返回0。
str="0"，返回0。
str="2147483647"，返回2147483647。
str="2147483648"，因为溢出了，所以返回0。
str="-123"，返回-123。.0
 * @content:
 * @date 2020/2/19 15:01
 */
public class Code_03_ConvertStringToInteger {


    public static int convert(String str){
        if(str==null || str.length()==0)
            return 0;
        char[] chars = str.toCharArray();
        if(!isValid(chars))
            return 0;
        boolean flag=chars[0]=='-' ?false:true;
        int qmin=Integer.MIN_VALUE%10;
        int qmax=Integer.MIN_VALUE/10;
        int res=0;
        int cur=0;
        for(int i=flag ? 0:1;i<chars.length;i++){ //注意不能使用Integer.valueOf()方法
            cur='0'-chars[i];//全部转变成负数
            if(res<qmax) return 0;
            if(res==qmax && cur<qmin)return 0;
            res=res*10+cur;
        }
        if(flag && res==Integer.MIN_VALUE){
            return 0;
        }
        return flag ? -res:res;
    }

    //判断一个是否是有效字符串
    private static boolean isValid(char[] chars){

        if(chars[0]!='-' && (chars[0]<'1'|| chars[0]>'9'))
            return false;
        if(chars[0]=='-' && (chars[1]==0 || chars.length==1))
            return false;

        for(int i=1;i<chars.length;i++){
            if(chars[i]<'0' || chars[i]>'9')
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String test1 = "2147483647"; // max in java
        System.out.println(convert(test1));

        String test2 = "-2147483648"; // min in java
        System.out.println(convert(test2));

        String test3 = "2147483648"; // overflow
        System.out.println(convert(test3));

        String test4 = "-2147483649"; // overflow
        System.out.println(convert(test4));

        String test5 = "-123";
        System.out.println(convert(test5));

    }
}
