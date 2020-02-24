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
}
