package 左神算法.进阶班二.第五章;

/**
 * @author zbl
 * @version 1.0
 * @content:表达式得到期望结果的组成种数
【题目】
给定一个只由0（假）、1(真)、&(逻辑与)、|（逻辑或）和^(异或)五种字符组成的字符
串express，再给定一个布尔值desired。返回express能有多少种组合方式，可以达到
desired的结果。
【举例】
express="1^0|0|1"，desired=false。
只有1^((0|0)|1)和1^(0|(0|1))的组合可以得到false，返回2。
express="1"，desired=false。
无组合则可以得到false，返回0。
 * @date 2020/2/24 16:05
 */
public class Code_05_ExpressionNumber {

    //判断是否是有效的字符串
    public static boolean isValid(char[] chs){
        if((chs.length & 1)==0 )
            return false;
        for(int i=0;i<chs.length;i+=2){
            if(chs[i]!='0' && chs[i]!='1')
                return false;
        }
        for(int i=1;i<chs.length;i+=2){
            if(chs[i]!='&' && chs[i]!='|' && chs[i]!='^')
                return false;
        }
        return true;
    }

    public static class ReturnData{
        public int trueNums;
        public int falseNums;

        public ReturnData(int trueNums, int falseNums) {
            this.trueNums = trueNums;//boolean==true的时候的返回数目
            this.falseNums = falseNums;
        }
    }


        //递归的方式
      public static int num1(String str,boolean desired){
        if(str==null || str.equals("") ){
            return 0;
        }
        if(!isValid(str.toCharArray())){
            throw new RuntimeException("无效字符串");
        }
        char[] chs=str.toCharArray();
          ReturnData process = process(chs, 0, chs.length - 1);
          return desired ? process.trueNums:process.falseNums;
    }

    //l.r为判断的字符数组的最左和最右边界位置,并且一定要是0或者1
    private static ReturnData process(char[] chs, int l, int r) {
        if(l==r){
            if(chs[l]=='0')
                return new ReturnData(0,1);
            if(chs[l]=='1')
                return new ReturnData(1,0);
        }
        int trueNums=0;
        int falseNums=0;
        for(int i=l+1;i<r;i+=2){//i取逻辑符号的位置进行划分
            ReturnData leftpart = process(chs, l, i - 1);
            ReturnData rightpart = process(chs, i + 1, r);
            int a=leftpart.trueNums;
            int b=leftpart.falseNums;
            int c=rightpart.trueNums;
            int d=rightpart.falseNums;
            if(chs[i]=='&'){
                trueNums+=a*c;
                falseNums+=a*d+b*c+b*d;
            }else if(chs[i]=='|'){
                trueNums+=a*c+a*d+b*c;
                falseNums+=b*d;
            }else{
                trueNums+=a*d+b*c;
                falseNums+=a*c+b*d;
            }

        }
        return new ReturnData(trueNums,falseNums);
    }

    //根据上面的递归改动态规划
    public static int num2(String str,boolean desire){
        if(str==null || str.length()==0)
            throw new RuntimeException("无效字符串");
        if(!isValid(str.toCharArray()))
            throw new RuntimeException("无效字符串");
        if(str.length()==1){
            return desire ?(str.equals("1")?1:0):(str.equals("0") ? 1:0);
        }
        char[] chs=str.toCharArray();
        int len=chs.length;
        int[][] trueDp=new int[len][len];
        int[][] falseDp=new int[len][len];
        for(int i=0;i<str.length();i+=2){
            trueDp[i][i]=(chs[i]=='1')?1:0;
            falseDp[i][i]=chs[i]=='0'?1:0;
        }

        for(int row=len-3;row>-1;row-=2){
            for(int col=row+2;col<len;col+=2){
                int trueNums=0;
                int falseNums=0;
                for(int split=row+1;split<col;split+=2){
                    int a=trueDp[row][split-1];
                    int b=falseDp[row][split-1];
                    int c=trueDp[split+1][col];
                    int d=falseDp[split+1][col];

                    if(chs[split]=='&'){
                        trueNums+=a*c;
                        falseNums+=a*d+b*c+b*d;
                    }else if(chs[split]=='|'){
                        trueNums+=a*c+a*d+b*c;
                        falseNums+=b*d;
                    }else{
                        trueNums+=a*d+b*c;
                        falseNums+=a*c+b*d;
                    }
                }
                trueDp[row][col]=trueNums;
                falseDp[row][col]=falseNums;
            }
        }
        return desire ? trueDp[0][len-1]:falseDp[0][len-1];

    }


    public static int num3(String express, boolean desired) {
        if (express == null || express.equals("")) {
            return 0;
        }
        char[] exp = express.toCharArray();
        if (!isValid(exp)) {
            return 0;
        }
        return p(exp, desired, 0, exp.length - 1);
    }

    public static int p(char[] exp, boolean desired, int l, int r) {
        if (l == r) {
            if (exp[l] == '1') {
                return desired ? 1 : 0;
            } else {
                return desired ? 0 : 1;
            }
        }
        int res = 0;
        if (desired) {
            for (int i = l + 1; i < r; i += 2) {
                switch (exp[i]) {
                    case '&':
                        res += p(exp, true, l, i - 1) * p(exp, true, i + 1, r);
                        break;
                    case '|':
                        res += p(exp, true, l, i - 1) * p(exp, false, i + 1, r);
                        res += p(exp, false, l, i - 1) * p(exp, true, i + 1, r);
                        res += p(exp, true, l, i - 1) * p(exp, true, i + 1, r);
                        break;
                    case '^':
                        res += p(exp, true, l, i - 1) * p(exp, false, i + 1, r);
                        res += p(exp, false, l, i - 1) * p(exp, true, i + 1, r);
                        break;
                }
            }
        } else {
            for (int i = l + 1; i < r; i += 2) {
                switch (exp[i]) {
                    case '&':
                        res += p(exp, false, l, i - 1) * p(exp, true, i + 1, r);
                        res += p(exp, true, l, i - 1) * p(exp, false, i + 1, r);
                        res += p(exp, false, l, i - 1) * p(exp, false, i + 1, r);
                        break;
                    case '|':
                        res += p(exp, false, l, i - 1) * p(exp, false, i + 1, r);
                        break;
                    case '^':
                        res += p(exp, true, l, i - 1) * p(exp, true, i + 1, r);
                        res += p(exp, false, l, i - 1) * p(exp, false, i + 1, r);
                        break;
                }
            }
        }
        return res;
    }

    public static int num4(String express, boolean desired) {
        if (express == null || express.equals("")) {
            return 0;
        }
        char[] exp = express.toCharArray();
        if (!isValid(exp)) {
            return 0;
        }
        int[][] t = new int[exp.length][exp.length];
        int[][] f = new int[exp.length][exp.length];
        t[0][0] = exp[0] == '0' ? 0 : 1;
        f[0][0] = exp[0] == '1' ? 0 : 1;
        for (int i = 2; i < exp.length; i += 2) {
            t[i][i] = exp[i] == '0' ? 0 : 1;
            f[i][i] = exp[i] == '1' ? 0 : 1;
            for (int j = i - 2; j >= 0; j -= 2) {
                for (int k = j; k < i; k += 2) {
                    if (exp[k + 1] == '&') {
                        t[j][i] += t[j][k] * t[k + 2][i];
                        f[j][i] += (f[j][k] + t[j][k]) * f[k + 2][i] + f[j][k] * t[k + 2][i];
                    } else if (exp[k + 1] == '|') {
                        t[j][i] += (f[j][k] + t[j][k]) * t[k + 2][i] + t[j][k] * f[k + 2][i];
                        f[j][i] += f[j][k] * f[k + 2][i];
                    } else {
                        t[j][i] += f[j][k] * t[k + 2][i] + t[j][k] * f[k + 2][i];
                        f[j][i] += f[j][k] * f[k + 2][i] + t[j][k] * t[k + 2][i];
                    }
                }
            }
        }
        return desired ? t[0][t.length - 1] : f[0][f.length - 1];
    }

    public static void main(String[] args) {
        String express = "1^0&0|1&1^0&0^1|0|1&1";
        boolean desired = true;
        System.out.println(num1(express, desired));
        System.out.println(num2(express, desired));
        System.out.println(num3(express, desired));
        System.out.println(num4(express, desired));

    }
}
