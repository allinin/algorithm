package 左神算法.进阶班一.Manacher;

/**
 * @author zbl
 * @version 1.0
 * @content: 如果只能向字符串的后面添加字符，如何使整个字符串成为回文串，求需要添加的最短字符串
 * @date 2019/12/27 11:14
 */
public class ShortestEnd {

    //找到包含原来字符串最后一个字符的回文串，将原字符串中剩余位置的字符反过来添加到字符串的后面即可，

    public static char[] manacherString(String str){
        char[] strArr=str.toCharArray();
        char[] chas=new char[2*strArr.length+1];
        int index=0;
        for(int i=0;i<chas.length;i++){
            chas[i]=(i&1)==1?strArr[index++]:'#';
        }
        return chas;
    }

    public static String shortestEnd(String str){
        if(str==null || str.length()==0)
            return null;
        char[] chars = manacherString(str);
        int[] pArr=new int[chars.length];
        int index=-1;//回文中心
        int pR=-1;//最后回文右边界
        int maxContainedEnd=-1;
        for(int i=0;i<chars.length;i++)
        {
//            pArr[i]=pR>i ? Math.min(pArr[2*index-i],pR-i):1;//在最右回文右边界之外，先暂定pArr[i]=1,即当前元素自己;
//            while(i+pArr[i]<chars.length && i-pArr[i]>=0)
//            {
//                if(chars[i+pArr[i]]==chars[i-pArr[i]])
//                    pArr[i]++;
//                else
//                    break;
//            }
//            if(i+pArr[i]>pR)
//            {
//                pR=i+pArr[i];
//                index=i;
//            }

            //i在回文边界内和上面实现的功能一样,代码中相应位置全部换为注释部分也可以，这样的话，最右右边界就是不包含的一个位置了
             if(pR>i)
             {
                 if(2*index-i-pArr[2*index-i]>index-pArr[index])
                 {
                     pArr[i]=pArr[2*index-i];
                 }else if(2*index-i-pArr[2*index-i]<index-pArr[index])
                 {
                     pArr[i]=pR-i+1; //pArr[i]=pR-i;
                 }else {
                     pArr[i]=pArr[2*index-i];
                     while(i+pArr[i]<chars.length && i-pArr[i]>-1)
                     {
                         if(chars[i+pArr[i]]==chars[i-pArr[i]])
                             pArr[i]++;
                         else
                             break;
                     }
                 }
             }else{
                 pArr[i]=1;
                 while(i+pArr[i]<chars.length && i-pArr[i]>=0)
                 {
                     if(chars[i+pArr[i]]==chars[i-pArr[i]])
                         pArr[i]++;
                     else
                         break;
                 }
             }
             if(i+pArr[i]-1>pR){ //或者是这样i+pArr[i]>pR
                 pR=i+pArr[i]-1; //pR=i+pArr[i]
                 index=i;
             }
            if(pR==chars.length-1) //pR=chars.length;
            {
                maxContainedEnd=pArr[i];
                break;
            }



        }
        char[] res=new char[str.length()-maxContainedEnd+1];
        for(int i=0;i<res.length;i++)
        {
            res[res.length-1-i]=chars[i*2+1];
        }
        return String.valueOf(res);
    }
    public static void main(String[] args) {
        String str2 = "123abba";
        System.out.println(shortestEnd(str2));

    }
}
