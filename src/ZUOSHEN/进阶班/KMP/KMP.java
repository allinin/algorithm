package ZUOSHEN.进阶班.KMP;

/**
 * 返回str2在str1中首次出现的位置,不存在则返回-1。即：kmp算法实现过程
 */
public class KMP {

    public static int getIndexOf(String s,String m)
    {
        if(s==null || m==null || s.length()<m.length()||m.length()<1)
            return -1;
        char[] ss=s.toCharArray();
        char[] ms=m.toCharArray();
        int si=0;
        int mi=0;
        int []next=getNextArray(ms);
        while(si<ss.length && mi<ms.length)
        {
            if(ss[si]==ms[mi])
            {
                si++;
                mi++;
            }else{
                if(next[mi]==-1)
                {
                    si++;
                }else{
                    mi=next[mi];//next[i]表示i位置的字符的最大相同前后缀的下一个字符的位置
                }
            }

        }
        return mi==ms.length? si-mi: -1;
    }

    //next数组只与str2有关，与str1没有关系
    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;//cn表示跳到的位置,cn初始值=next[pos-1]==next[1]==0
        while (pos < next.length) {
            if (ms[pos - 1] == ms[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];//往前跳，跳到cn位置的前缀的下一个字符
            } else {//也就是cn<=0,其实只存在可能是0的情况
                next[pos++] = 0;
            }
        }
        return next;
    }
    public static void main(String[] args) {
        String str = "abcabcababaccc";
        String match = "b";
        System.out.println(getIndexOf(str, match));

    }
}
