package 左神算法.进阶班二.第七章;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * 给定一个长度大于1的字符串，我们可以把这个字符串分成两个非空的部分，
并且每个部分还能细分下去，
并且可以用二叉树的形式来表达，比如
字符串 s1 = "great":
可以分解成这么一个样子（这只是其中一种分解结构）
great
/ \
gr eat
/ \ / \
g r e at
/ \
a t
我们说s1的搅乱串，指的是在任意一种分解结构中，随意交换某个节点的左
右两个孩子所形成的字符串。
比如我们可以选择在上面的分解结构中，交换“gr”这个节点的孩子节点，形
成的树为：
rgeat
/ \
rg eat
/ \ / \
r g e at
/ \
a t
那么“rgeat”，是“great”的搅乱串。
同样，我们可以继续交换“eat”节点的左右孩子，形成：
rgtae
/ \
rg tae
/ \ / \
r g ta e
/ \
t a
那么“rgtae”，是“great”的搅乱串。
所以一个字符串的搅乱串是非常之多的，分解结构本身就有很多种，
而且每一种分解结构都可以随意交换任意一个节点的左右孩子。
给定两个字符串s1和s2，判断s2是不是s1的搅乱串。
 * @date 2020/2/29 16:39
 */
public class Code_01_Scramble_String {

    public static boolean isScramble1(String str1,String str2){
        if(str1.length()!=str2.length())
            return false;
        if(str1.equals(str2))
            return true;
        return process(str1.toCharArray(),str2.toCharArray(),0,0,str1.length());
    }
    //str1从L1位置开始size的长度，str2从L2位置开始size的长度，二者是否是搅乱串。
    //三个变量，改动态规划的话是三维的
    private static boolean process(char[] chs1, char[] chs2, int s1, int s2, int len) {

        if(len==1){
            return chs1[s1]==chs2[s2];
        }
        for(int part=1;part<len;part++){
            if((process(chs1,chs2,s1,s2,part) &&
                    process(chs1,chs2,s1+part,s2+part,len-part))
                    ||(process(chs1,chs2,s1,s2+len-part,part) && process(chs1,chs2,s1+part,s2,len-part)))
                return true;
        }
        return false;
    }

    //动态规划
    public static boolean isScramble2(String s1,String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }

        int N=s1.length();
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        boolean[][][] dp=new boolean[N][N][N+1];//三维的dp
        for(int l1=0;l1<N;l1++){
            for(int l2=0;l2<N;l2++){
                  dp[l1][l2][1]=chs1[l1]==chs2[l2];
              }
          }

          for(int size=2;size<=N;size++){
            for(int l1=0;l1<=N-size;l1++){
                for(int l2=0;l2<=N-size;l2++){
                    for(int p=1;p<size;p++){
                        if((dp[l1][l2][p] && dp[l1+p][l2+p][size-p])||(
                                dp[l1][l2+size-p][p] && dp[l1+p][l2][size-p]
                        )){

                            dp[l1][l2][size]=true;
                            break;
                        }
                    }

                }
            }
          }
          return dp[0][0][N];
    }

    public static void main(String[] args) {
        String test1 = "bcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcde";
        String test2 = "cebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebd";
        String str2="great";
        String str1="rgtae";
        System.out.println(isScramble1(str1, str2));
        System.out.println(isScramble2(str1, str2));
    }



}
