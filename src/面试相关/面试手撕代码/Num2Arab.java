package 面试相关.面试手撕代码;

/**
 * @author zbl
 * @version 1.0
 * @content:中文数字转阿拉伯数字，例如一千一百万零一百 -> 11000100
 * @date 2020/11/13 14:14
 */
public class Num2Arab {

    //单位
    private static char[] units={'千','百','十'};
    //中文数字
    private static char[] numChars={'一','二','三','四','五','六','七','八','九'};

    //单独的零
    private static char numZero='零';

    //将一位中文数字转化为一位数字
    public static int oneCharCN2Arab(char chs){
        if(numChars[0]==chs){
            return 1;
        }else if(numChars[1]==chs || chs=='两'){
            return 2;
        }else if(numChars[2]==chs){
            return 3;
        }else if(numChars[3]==chs){
            return 4;
        }else if(numChars[4]==chs){
            return 5;
        }else if(numChars[5]==chs){
            return 6;
        }else if(numChars[6]==chs){
            return 7;
        }else if(numChars[7]==chs){
            return 8;
        }else if(numChars[8]==chs){
            return 9;
        }
        return 0;
    }

    //将中文数字转化为阿拉伯数字,在这里转化范围默认不超过int的范围
    public static  int numberChar2Arab(String numStr){
        if(numStr==null || numStr.length()==0) return 0;
        //将numStr以亿，万，千为间隔划分
        int[] idxes=new int[2];//分别存放亿，万，所在的位置所以
        idxes[0]=numStr.indexOf('亿');
        idxes[1]=numStr.indexOf('万');
        String[] nums=new String[3];
        if(idxes[0]!=-1){
            nums[0]=numStr.substring(0,idxes[0]);
        }
        if(idxes[1]!=-1){
            nums[1]=numStr.substring(idxes[0]+1,idxes[1]);
        }

        nums[2]=numStr.substring(idxes[1]+1);

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<3;i++){
            if(nums[i]=="" && sb.length()==0) continue;
            String ans=help(nums[i]);
            sb.append(ans);
        }
        return Integer.valueOf(sb.toString());//Integer.valueOf在转化时，会将开始的无意义的零自动清除

    }

    //将万以下的中文数字转化为阿拉伯数字
    private static String help(String str){

        if(str==null || str.length()==0) return "";
        //if(str.length()==1) return "10";//就是只有一个数：十的情况
        int[] idxes=new int[3];//存放千，百，十的位置
        for(int i=0;i<3;i++){
            idxes[i]=str.indexOf(units[i]);
        }

        StringBuilder sb=new StringBuilder();

        if(idxes[0]!=-1){
            char temp=str.substring(0,idxes[0]).charAt(0);
            int tmp=oneCharCN2Arab(temp);
            sb.append(tmp);
        }else {
            sb.append(0);
        }

        if(idxes[1]!=-1){
            char temp=str.substring(idxes[1]-1,idxes[1]).charAt(0);
            int tmp=oneCharCN2Arab(temp);
            sb.append(tmp);
        }else{
            sb.append(0);
        }

        if(idxes[2]!=-1){
            //当str是一个十几的数时
            if(idxes[2]==0){
                sb.append(1);
            }else{
                char temp=str.substring(idxes[2]-1,idxes[2]).charAt(0);
                int tmp=oneCharCN2Arab(temp);
                sb.append(tmp);
            }

        }else{
            sb.append(0);
        }

        if(idxes[2]==str.length()-1){
            sb.append(0);
        }else {
            sb.append(oneCharCN2Arab(str.charAt(str.length()-1)));
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        String str="十";
        System.out.println(numberChar2Arab(str));

    }



}
