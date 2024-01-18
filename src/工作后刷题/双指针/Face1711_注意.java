package 工作后刷题.双指针;

/**
 * @Author:zbl
 * @Date:2024/1/15 20:20
 * 单词距离(medium)
 * 有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。
 * 如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 *
 * 示例：
 *
 * 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
 * 输出：1
 * 提示：
 *
 * words.length <= 100000
 */
public class Face1711_注意 {

    //一次遍历
    public int findClosest(String[] words, String word1, String word2) {
        int idx1 = -1,idx2 = -1;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < words.length;i++) {
            //如果word1出现多次，word2还没出现，则最短距离一定是与当前最近出现的一次有关，反之word2也是如此
            if(word1.equals(words[i])) {
                idx1 = i;
            }
            if(word2.equals(words[i])) {
                idx2 = i;
            }
            //只有当word1,word2都出现的时候才计算
            if(idx2 != -1 && idx1 != -1) {
                ans = Math.min(ans,Math.abs(idx1 - idx2));
            }
        }
        return ans;
    }
}
