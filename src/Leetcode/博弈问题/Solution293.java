package Leetcode.博弈问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip twoconsecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

For example, given s = "++++", after one move, it may become one of the following states:

[
"--++",
"+--+",
"++--"
]
If there is no valid move, return an empty list [].

给一个只含有'+', '-'的字符串，每次可翻动两个连续的'+'，求有多少种翻法。
 * @date 2020/6/15 15:30
 */
public class Solution293 {

    public List<String> generatePossibleNextMoves(String s){
        List<String> res=new ArrayList<>();
        char[] chs = s.toCharArray();
        for(int i=0;i<s.length()-1;i++){
            if(chs[i]=='+' && chs[i+1]=='+')
            {
                chs[i]='-';
                chs[i+1]='-';
                res.add(new String(chs));
                chs[i]='+';
                chs[i+1]='+';
            }
        }
        return res;
    }
}
