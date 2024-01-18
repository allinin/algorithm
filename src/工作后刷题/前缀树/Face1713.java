package 工作后刷题.前缀树;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author:zbl
 * @Date:2024/1/13 21:42
 * 恢复空格(medium)
 * <p>
 * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，
 * 不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
 * <p>
 * 注意：本题相对原题稍作改动，只需返回未识别的字符数
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * 输出： 7
 * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
 * 提示：
 * <p>
 * 0 <= len(sentence) <= 1000
 * dictionary中总字符数不超过 150000。
 * 你可以认为dictionary和sentence中只包含小写字母。
 */
public class Face1713 {

    //方法一:记忆化搜索的方式
    public int respace(String[] dictionary, String sentence) {
        //按长度进行排序
        Arrays.sort(dictionary, (a, b) -> a.length() - b.length());
        int[] dp = new int[sentence.length()]; //表示索引i到末尾表示的子串有多少不能匹配
        Arrays.fill(dp, -1);
        return process(sentence, dictionary, 0, dp);
    }

    private int process(String sentence, String[] dictionary, int idx, int[] dp) {
        if (idx == sentence.length()) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int res = sentence.length();
        boolean match = false;
        for (String str : dictionary) {
            if (str.length() > sentence.length() - idx) {
                break;
            }
            if (str.equals(sentence.substring(idx, idx + str.length()))) {
                match = true;
                res = Math.min(res, process(sentence, dictionary, idx + str.length(), dp));

            }
        }
        int notMatchRes = 1 + process(sentence, dictionary, idx + 1, dp);
        if (!match) {
            dp[idx] = notMatchRes;
            return notMatchRes;
        }
        dp[idx] = Math.min(res, notMatchRes);
        return Math.min(res, notMatchRes);
    }

    //方法二：dp + 前缀树(TODO 本题是从单词末尾倒着构建前缀树的情况)
    public int respace2(String[] dictionary, String sentence) {
        Trie trie = new Trie();
        for (String str : dictionary) {
            trie.insert(str);
        }
        int[] dp = new int[sentence.length() + 1]; //表示前i个字符组成的子串有多少个字符不能匹配
        Arrays.fill(dp, sentence.length());
        dp[0] = 0;
        for (int i = 1; i <= sentence.length(); i++) {
            dp[i] = dp[i - 1] + 1;
            Node cur = trie.root;
            //因为所有的单词都是倒序构建的前缀树，索引从i到1的倒序循环可以直接判断
            for (int j = i; j >= 1; j--) {
                char c = sentence.charAt(j - 1);
                if (cur.children[c - 'a'] == null) {
                    break;
                } else if (cur.children[c - 'a'].end) {
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
                if (dp[i] == 0) {
                    break;
                }
                cur = cur.children[c - 'a'];
            }
        }
        return dp[sentence.length()];
    }

    //方法三：传统dp做法
    public int respace3(String[] dictionary, String sentence) {
        Set<String> set=new HashSet<String>(Arrays.asList(dictionary));
        int n=sentence.length();
        int[] dp=new int[n+1];//前n个字符最少不匹配的长度
        for(int i=1;i<=n;i++){
            dp[i]=dp[i-1]+1;
            //每次都需要从头到i -1构建子串
            for(int j=0;j<i;j++){
                if(set.contains(sentence.substring(j,i))){
                    dp[i]=Math.min(dp[i],dp[j]);
                }
            }
        }
        return dp[n];
    }

    class Node {
        boolean end;
        Node[] children;

        public Node() {
            this.end = false;
            this.children = new Node[26];
        }

    }

    class Trie {
        Node root;

        public Trie() {
            this.root = new Node();
        }

        //倒序构建前缀树
        public void insert(String str) {
            Node cur = root;
            for (int i = str.length() - 1; i >= 0; i--) {
                char c = str.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new Node();
                }
                cur = cur.children[c - 'a'];
            }
            cur.end = true;
        }

    }

    public static void main(String[] args) {
        String sentence = "jesslookedjustliketimherbrother";
        String[] words = new String[]{"looked", "just", "like", "her", "brother"};
        System.out.println(new Face1713().respace(words, sentence));
    }
}
