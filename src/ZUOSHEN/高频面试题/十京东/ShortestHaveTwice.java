package ZUOSHEN.高频面试题.十京东;
/*
   给定一个字符串s，请计算输出含有连续两个s作为 子串的最短字符串。注意两个s可能有重叠的部分，例如：ababa含有连个aba
 */
public class ShortestHaveTwice {

    public static String answer(String str){
        if(str==null || str.length()==0)
            return "";
        if(str.length()==1){
            return str+str;
        }
        char[] chas=str.toCharArray();
        if(str.length()==2){
            return chas[0]==chas[1] ? str+String.valueOf(chas[0]): str+str;
        }
        int endNext=endNextLength(chas);
        return str+str.substring(endNext);
    }

    private static int endNextLength(char[] chas) {
        int [] next=new int[chas.length+1];
        next[0]=-1;
        next[1]=0;
        int pos=2;
        int cn=0;
        //与下面的等价
//        while(pos<next.length){
//            cn=next[pos-1];
//            if(chas[cn]==chas[pos-1]){
//                next[pos]=next[pos-1]+1;
//            }else{
//                while(cn>0) {
//                    cn = next[cn];
//                    if (cn <= 0){
//                        next[pos]=0;
//                        break;
//                    }
//                     else if(chas[cn] == chas[pos - 1]) {
//                        next[pos] = next[cn] + 1;
//                        break;
//                    }
//                }
//            }
//            pos++;
//
//        }

        while (pos < next.length) {
            if (chas[pos - 1] == chas[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next[chas.length];
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
        String test6 = "abracadabraca";
        System.out.println(answer(test6));

    }
}
