package 左神算法.高频面试题.十京东;

/*
  回文是指从前往后读和从后往前读是一样的词语，给定一个字符串s,然后在后面附加0个或更多个字母形成回文。希望这个回文
  越短越好，求能够得到的最短回文串
 */
public class ShortestMakePalindrome {

    //将原来的数组变成manacher数组，保证数组应用是奇数的长度
    public static char[] manacherString(String str){
        char[] charArr=str.toCharArray();
        char[] res=new char[charArr.length*2+1];
        int index=0;
        for(int i=0;i<res.length;i++){
            res[i]=(i&1)==0 ? '#':charArr[index++];
        }
        return res;
    }

    public static int shortestEnd(String str){
        if(str==null || str.length()==0)
            return 0;
        char[] charArr=manacherString(str);
        int[] pArr=new int [charArr.length];//回文半径数组
        int index=-1;//回文中心
        int pR=-1;//回文最右边界
        int maxContainsEnd=0;
        for(int i=0;i<charArr.length;i++) {
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {//进行左右两边扩
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
                    pArr[i]++;
                else
                    break;
            }
            if (index + pArr[i] > pR) {
                index = i;
                pR = i + pArr[i];
            }
            if (pR == charArr.length) {
                maxContainsEnd = pArr[i];//这里maxContainsEnd的值是在manacher的情况下求出的。所以相当于原数组的回文直径
                break;
            }
        }
        return 2*str.length()-maxContainsEnd+1;
    }
    public static void main(String[] args) {
        String test = "abcd1234321";
        System.out.println(shortestEnd(test));
    }
}
