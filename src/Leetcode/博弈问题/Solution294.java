package Leetcode.博弈问题;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -,
 * you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a
 * move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

Example:

Input: s = "++++"
Output: true
Explanation: The starting player can guarantee a win by flipping the middle "++" to become "+--+".
 * @date 2020/6/15 16:07
 */
public class Solution294 {

    //题目的意思是只要存在一种方式使得第一个先翻牌的人赢便返回true
    public boolean canWin(String s){
        if(s==null || s.length()<2)
              return false;
        int len=s.length();
        for(int i=0;i<len-1;i++){
            if(s.charAt(i)=='+' && s.charAt(i+1)=='+' && !canWin(s.substring(0,i)+"--"+s.substring(i+2)))
                //第一个人将i以及i+1位置的+翻转成‘--’，然后if中的canwin表示第二个的操作，此时新的s,
                // 第二个人相当于是第一个对新的s进行操作的人，并且他无论如何操作都返回false,从而说明存在使第一个人赢的翻牌操作
                return true;
        }
        return false;

    }
}
