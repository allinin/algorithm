package 工作后刷题.zjlab电脑刷题内容.社招面试题目;

/**
 * @Author: ZBL
 * @Date: 2024-03-13  19:52
 */
public class KuaiShouFace {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        KuaiShouFace m = new KuaiShouFace();
        System.out.println(m.process("1.01","1.0001"));
        System.out.println(m.process("1.0","1.0.0.0"));
        System.out.println(m.process("2.1","1.1"));
        System.out.println(m.process("1.0.1","1"));
        System.out.println(m.process("7.5.2.4","7.5.3"));
    }

    public int process(String str1,String str2) {
        String[] strArr1 = str1.split("\\.");
        String[] strArr2 = str2.split("\\.");
        int n1 = strArr1.length,n2 = strArr2.length;
        int idx1 = 0,idx2 = 0,ans =0;
        while(idx1 < n1 || idx2 < n2) {
            String s1 = idx1 < n1 ? strArr1[idx1] : "0";
            String s2 = idx2 < n2 ? strArr2[idx2] : "0";
            int tmp = compare(s1,s2);
            if(tmp != 0) {
                ans = tmp;
                break;
            }
            idx1++;
            idx2++;
        }
        return ans;
    }

    private int compare(String str1,String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int effectLen1 = len1,effectLen2 = len2;
        int startIdx1 = 0,startIdx2 = 0;
        for(;startIdx1 < len1;startIdx1++) {
            if(str1.charAt(startIdx1) != '0') {
                break;
            }
        }
        for(;startIdx2 < len2;startIdx2++) {
            if(str2.charAt(startIdx2) != '0') {
                break;
            }
        }
        effectLen1 -= startIdx1;
        effectLen2 -= startIdx2;
        if(effectLen1 > effectLen2) {
            return 1;
        } else if(effectLen1 < effectLen2) {
            return -1;
        } else {
            while(startIdx1 < len1 && startIdx2 < len2) {
                if(str1.charAt(startIdx1) < str2.charAt(startIdx2)){
                    return -1;
                } else if(str1.charAt(startIdx1) > str2.charAt(startIdx2)) {
                    return 1;
                }

                startIdx1++;
                startIdx2++;
            }
        }
        return 0;
    }
}
