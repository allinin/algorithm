package ZUOSHEN.动态规划与递归;

/**
 * 打印一个字符串的去全部子序列，包括空字符串
 */
public class PrintSub {

    //i表示字符串中字符的位置
    public static void printAllSub(char[] str,int i,String res)
    {
        if(i==str.length)
        {
            System.out.println(res);
            return;
        }
        printAllSub(str,i+1,res+String.valueOf(str[i]));//包含当前字符
        printAllSub(str,i+1,res);//不包含当前字符，当前字符为空
    }
    //法二
    public static void process(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
            return;
        }
        process(chs, i + 1);//这里相当于上面的包含当前字符
        char tmp = chs[i];
        chs[i] = 0;//ascii中0表示空字符
        process(chs, i + 1);//这里相当于上面的不包含当前字符
        chs[i] = tmp;
    }

    public static void main(String[] args) {
        String s="abc";
        String res="";
        process(s.toCharArray(),0);
    }
}
