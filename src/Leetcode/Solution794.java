package Leetcode;

/**
 * @author zbl
 * @version 1.0
 * @content:用字符串数组作为井字游戏的游戏板 board。当且仅当在井字游戏过程中，玩家有可能将字符放置成游戏板所显示的状态时，才返回 true。

该游戏板是一个 3 x 3 数组，由字符 " "，"X" 和 "O" 组成。字符 " " 代表一个空位。

以下是井字游戏的规则：

玩家轮流将字符放入空位（" "）中。
第一个玩家总是放字符 “X”，且第二个玩家总是放字符 “O”。
“X” 和 “O” 只允许放置在空位中，不允许对已放有字符的位置进行填充。
当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。
当所有位置非空时，也算为游戏结束。
如果游戏结束，玩家不允许再放置字符。

示例 1:
输入: board = ["O  ", "   ", "   "]
输出: false
解释: 第一个玩家总是放置“X”。

示例 2:
输入: board = ["XOX", " X ", "   "]
输出: false
解释: 玩家应该是轮流放置的。

示例 3:
输入: board = ["XXX", "   ", "OOO"]
输出: false

示例 4:
输入: board = ["XOX", "O O", "XOX"]
输出: true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-tic-tac-toe-state
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/5 15:50
 */
public class Solution794 {

    public static boolean validTicTacToe(String[] board) {
        int counto=0,countx=0,rcounto=0,rcountx=0,ccounto=0,ccountx=0,xcounto=0,xcountx=0;
        boolean flag=false;
        for(int i=0;i<3;i++){//考虑行
            String str=board[i];
            for(int j=0;j<3;j++){
                if(str.charAt(j)=='O'){
                    counto++;
                    if(!flag)
                        rcounto++;
                }
                if(str.charAt(j)=='X'){
                    countx++;
                    if(!flag)
                        rcountx++;
                }
            }
            if(rcounto==3 || rcountx==3)
                flag=true;
            else{
                rcounto=0;
                rcountx=0;
            }

        }
        if(countx<counto || countx-counto>1)
            return false;
        //统计是否存在列全部为相同的情况
        if(board[0].charAt(0)==board[1].charAt(0) && board[1].charAt(0)==board[2].charAt(0))
        {
            if(board[0].charAt(0)=='O') ccounto=3;
            if(board[0].charAt(0)=='X') ccountx=3;
        }
        if (board[0].charAt(1)==board[1].charAt(1) && board[1].charAt(1)==board[2].charAt(1)){
            if(board[0].charAt(1)=='O') ccounto=3;
            if(board[0].charAt(1)=='X') ccountx=3;
        }
        if(board[0].charAt(2)==board[1].charAt(2) && board[1].charAt(2)==board[2].charAt(2)){
            if(board[0].charAt(2)=='O') ccounto=3;
            if(board[0].charAt(2)=='X') ccountx=3;
        }
        //对角线
        if(board[0].charAt(0)==board[1].charAt(1) && board[2].charAt(2)==board[1].charAt(1)){
            if(board[0].charAt(0)=='O') xcounto=3;
            if(board[0].charAt(0)=='X') xcountx=3;
        }
        if(board[0].charAt(2)==board[1].charAt(1) && board[2].charAt(0)==board[1].charAt(1)){
            if(board[0].charAt(2)=='O') xcounto=3;
            if(board[0].charAt(2)=='X') xcountx=3;
        }


        if(ccounto==3 || rcounto==3 || xcounto==3){
            if(countx>counto)
                return false;

        }
        if(rcountx==3 || ccountx==3 || xcountx==3){
            if(counto==countx)
                return false;
        }
        return true;

    }

    public static void main(String[] args) {
        String[] strs={"XXO","XOX","OXO"};
        System.out.println(validTicTacToe(strs));

    }
}
