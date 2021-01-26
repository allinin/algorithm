package 挑战程序设计竞赛.第二章;

/**
 * @Author zbl
 * @Date 2020/12/1 19:15
 * @Content 给定长度为n的字符串S，要构建一个长度为n的字符串T。起初，T是一个空串，随后反复进行下列任意操作：
 * 从S的头部删除一个字符，加到T的尾部
 * 从S的尾部删除一个字符，加到T的尾部
 * 目标：构造字段序尽可能小的字符串T
 * 限制条件：1<=N<=2000;字符串S只包含大写英文字母
 * @Version 1.0
 */
public class Solution1 {
    /**
     * 字典序比较类的问题上经常能用上贪心算法
     * @param s
     * @return
     */
    public String getResult(String s){
        if(s==null || s.length()<2) return  s;
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        int left=0,right=n-1;

        while(left<=right){
            boolean flag=false;//表示是否从s的开头拿一个元素加入到t中
            //贪心法的思想：找出左右端点尽可能小的元素
            for(int i=0;left+i<=right;i++){
                if(s.charAt(left+i)<s.charAt(right-i)){
                    flag=true;
                    break;
                }else if(s.charAt(left+i)>s.charAt(right-i)) {
                    flag=false;
                    break;
                }else{
                    //当相等的时候就继续找下去，看一下左右相等位置的下一个位置哪个更小，将更小的提前暴露出来
                    continue;
                }

            }
            if(flag) sb.append(s.charAt(left++));
            else sb.append(s.charAt(right--));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str="abcabcaba";
        System.out.println(new Solution1().getResult(str));
    }

}
