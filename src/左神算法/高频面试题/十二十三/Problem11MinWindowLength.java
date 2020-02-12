package 左神算法.高频面试题.十二十三;

import java.util.HashMap;

/**
 * @author zbl
 * @version 1.0
 * @content: 最小包含子串的长度
 * 给定一个字符串str1和str2,求str1的子串中含有str2所有子串的最小子串长度。不存在返回0
 * @date 2020/2/10 18:26
 */
public class Problem11MinWindowLength {

    public static int minLength(String str1,String str2){
        if(str1==null || str2==null || str1.length()<str2.length())
            return 0;
        char[] chas1= str1.toCharArray();
        char[] chas2= str2.toCharArray();
        int all=chas2.length;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<chas2.length;i++){
            if(map.containsKey(chas2[i])){
                map.put(chas2[i],map.get(chas2[i])+1);
            }else {
                map.put(chas2[i],1);
            }

        }
        int l=0;
        int r=0;
        int res=Integer.MAX_VALUE;
        while(r<chas1.length){
            if(map.containsKey(chas1[r])){
                map.put(chas1[r],map.get(chas1[r])-1);
                if(map.get(chas1[r])>=0){
                    all--;
                }
            }
            if(all==0){
                res=Math.min(res,r-l+1);
                while(l<=r){
                    if(map.containsKey(chas1[l])){
                        map.put(chas1[l],map.get(chas1[l])+1);
                        if(map.get(chas1[l++])>0){
                            all++;
                            break;
                        }
                        res=Math.min(res,r-l+1);
                    }else{
                        l++;
                        res=Math.min(res,r-l+1);
                    }

                }
            }
            r++;
        }
        return res==Integer.MAX_VALUE ? 0:res;

    }

     //左神做法
    public static int minLength2(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() < str2.length()) {
            return 0;
        }
        char[] chas1 = str1.toCharArray();
        char[] chas2 = str2.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i != chas2.length; i++) {
            map[chas2[i]]++;
        }
        int left = 0;
        int right = 0;
        int match = chas2.length;
        int minLen = Integer.MAX_VALUE;
        while (right != chas1.length) {
            map[chas1[right]]--;
            if (map[chas1[right]] >= 0) {
                match--;
            }
            if (match == 0) {
                while (map[chas1[left]] < 0) {
                    map[chas1[left++]]++;
                }
                minLen = Math.min(minLen, right - left + 1);
                match++;
                map[chas1[left++]]++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        String str1 = "adabbca";
        String str2 = "abc";
        System.out.println(minLength(str1, str2));

    }
}
