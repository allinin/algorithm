package Leetcode;

/**
 * @author zbl
 * @version 1.0
 * @content:给你一个 m * n 的矩阵 seats 表示教室中的座位分布。如果座位是坏的（不可用），就用 '#' 表示；否则，用 '.' 表示。

学生可以看到左侧、右侧、左上、右上这四个方向上紧邻他的学生的答卷，但是看不到直接坐在他前面或者后面的学生的答卷。请你计算并返回该考场可以容纳的一起参加考试且无法作弊的最大学生人数。

学生必须坐在状况良好的座位上。

 

示例 1：



输入：seats = [["#",".","#","#",".","#"],
              [".","#","#","#","#","."],
              ["#",".","#","#",".","#"]]
输出：4
解释：教师可以让 4 个学生坐在可用的座位上，这样他们就无法在考试中作弊。
示例 2：

输入：seats = [[".","#"],
              ["#","#"],
              ["#","."],
              ["#","#"],
              [".","#"]]
输出：3
解释：让所有学生坐在可用的座位上。
示例 3：

输入：seats = [["#",".",".",".","#"],
              [".","#",".","#","."],
              [".",".","#",".","."],
              [".","#",".","#","."],
              ["#",".",".",".","#"]]
输出：10
解释：让学生坐在第 1、3 和 5 列的可用座位上。
 

提示：

seats 只包含字符 '.' 和'#'
m == seats.length
n == seats[i].length
1 <= m <= 8
1 <= n <= 8

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-students-taking-exam
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/14 19:55
 */
public class Solution1349 {

    public static int maxStudents(char[][] seats) {
        int m=seats.length;
        int n=seats[0].length;
        int [][] dp=new int[m+1][1<<n];//表示第i行的状态为j,其中j的可能性有2^n种
        int res=0;
        for(int row=1;row<=m;row++){ //第几行
            for(int state=0;state<(1<<n);state++){//每行可能的状态
                for(int laststate=0;laststate<(1<<n);laststate++){
                    if(isValid(seats,row,state,laststate)){
                        dp[row][state]=Math.max(dp[row][state],dp[row-1][laststate]+Integer.bitCount(state));
                        res=Math.max(res,dp[row][state]);
                    }
                }
            }
        }
        return res;

    }

    //判断第row行的状态为mark时，第row-1行的状态为lastmark时，是否是合法的。
    private static boolean isValid(char[][] seats,int row,int mark,int lastmark){
        int n=seats[0].length;
        for(int i=0;i<n;i++){//每一行的座位数
            if((mark & (1<<i))==0)
                continue;
            if(seats[row-1][i]=='#')
                return false;
            if(i==0 && seats[row-1][i+1]=='.' && (mark & 1<<1)!=0)
                return false;
            else if(i==n-1 && seats[row-1][i-1]=='.' && (mark & 1<<(n-2))!=0)
                return false;
            else if(i>0 && i<n-1)
                if((seats[row-1][i-1]=='.' && (mark & 1<<(i-1))!=0) || (seats[row-1][i+1]=='.' && (mark & 1<<(i+1))!=0))
                    return false;
            if(row>1){
                if(i==0 && seats[row-2][i+1]=='.' && (mark & lastmark>>1)!=0)
                    return false;
                else if(i==n-1 && seats[row-2][i-1]=='.' && (mark & lastmark<<1)!=0)
                    return false;
                else if(i>0 && i<n-1)
                    if((seats[row-2][i-1]=='.' && (mark & lastmark<<1)!=0) ||(seats[row-2][i+1]=='.' && (mark & lastmark>>1)!=0))
                        return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] seats={{'#','.','#','#','.','#'},{'.','#','#','#','#','.'},{'#','.','#','#','.','#'}};
        System.out.println(maxStudents(seats));
    }
}
