package 左神算法.进阶班一.KMP;

/**
 * @author zbl
 * @version 1.0
 * @content:有一个字符串str，请在字符串末尾添加相应的字符，使得形成的新字符串包含连个原来的字符串，并且要求包含的两个原来的字符串的开始位置不同，求
 *                   最短的新字符串。(京东)
 * @date 2019/12/25 14:33
 */
public class ShortestHaveTwice {


    public static String answer(String str)
    {
        if(str==null || str.length()==0)
            return null;
        char[] chas=str.toCharArray();
        if(chas.length==1)
            return str+str;
        if(chas.length==2)
        {
            return chas[0]==chas[1]?(str+String.valueOf(chas[0])):str+str;
        }

        int endNext=endNextLength(chas);
        return str+str.substring(endNext);
    }
     //next数组多算一位
    public static int endNextLength(char[] chas){

      int[] next=new int[chas.length+1];
      next[0]=-1;
      next[1]=0;
      int pos=2;
      int cn=0;//下一跳的位置
      while(pos<next.length){
          if(chas[pos-1]==chas[cn])
          {
              next[pos++]=++cn;
          }else if(cn>0){
              cn=next[cn];
          }else{
              next[pos++]=0;
          }
      }
      return next[next.length-1];
    }

    public static void main(String[] args) {
        String test1 = "a";
        System.out.println(answer(test1));

        String test2 = "aa";
        System.out.println(answer(test2));

        String test3 = "ab";
        System.out.println(answer(test3));

        String test4 = "abcdabcd";
        System.out.println(answer(test4));

        String test5 = "abracadabra";
        System.out.println(answer(test5));

    }
}
