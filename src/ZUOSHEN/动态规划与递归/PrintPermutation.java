package ZUOSHEN.动态规划与递归;

/**
 * 打印一个字符串的全部排列（可以出现重复的排列）
 */
public class PrintPermutation {

    public static void printAllPermutations1(String str){
        char[] chars = str.toCharArray();
        process1(chars,0);
    }

    public static void process1(char[] str,int i)
    {
        if(i==str.length-1)
        {
            System.out.println(String.valueOf(str));
            return;
        }
        for(int j=i;j<str.length;j++)
        {
            swap(str,i,j);
            process1(str,i+1);
            swap(str,i,j);
        }
    }

    public static void swap(char[] str,int i,int j)
    {
        char temp=str[i];
        str[i]=str[j];
        str[j]=temp;
    }

    public static void main(String[] args) {
        String test1 = "abc";
        printAllPermutations1(test1);
        System.out.println("======");
        //printAllPermutations2(test1);
        System.out.println("======");

        String test2 = "acc";
        printAllPermutations1(test2);
        System.out.println("======");
        //printAllPermutations2(test2);
        System.out.println("======");
    }
}
