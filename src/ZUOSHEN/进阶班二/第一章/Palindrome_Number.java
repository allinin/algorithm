package ZUOSHEN.进阶班二.第一章;

/*
  给定一个整数，判断该数是否是回文数
 */
public class Palindrome_Number {

    public static boolean isPalindrome(int num){
        if(num <0){
            return false;
        }
        int help=1;
        //下面的while如果写成如下可能会溢出
        //while(help<=n){
        //help*=10;
        //}
        //help/=10;
        while(num/help>=10){
            help*=10;
        }
        while(num>0){
            if(num/help!=num%10){
                return false;
            }
            num=(num%help)/10;//num%help去掉num的最高位，再/10去掉number的最低位
            help/=100;//因为number缩小了100倍，所以help缩小100倍
        }
        return true;

    }
}
