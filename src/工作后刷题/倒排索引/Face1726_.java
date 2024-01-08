package 工作后刷题.倒排索引;

import java.util.*;

/**
 * @Author:zbl
 * @Date:2024/1/7 14:20
 * 程序员面试金典 17.26 (hard)
 * <p>
 * 两个(具有不同单词的)文档的交集(intersection)中元素的个数除以并集(union)中元素的个数，就是这两个文档的相似度。例如，{1, 5, 3} 和 {1, 7, 2, 3} 的相似度是 0.4，其中，交集的元素有 2 个，并集的元素有 5 个。给定一系列的长篇文档，每个文档元素各不相同，并与一个 ID 相关联。它们的相似度非常“稀疏”，也就是说任选 2 个文档，相似度都很接近 0。请设计一个算法返回每对文档的 ID 及其相似度。只需输出相似度大于 0 的组合。请忽略空文档。为简单起见，可以假定每个文档由一个含有不同整数的数组表示。
 * <p>
 * 输入为一个二维数组 docs，docs[i] 表示 id 为 i 的文档。返回一个数组，其中每个元素是一个字符串，代表每对相似度大于 0 的文档，其格式为 {id1},{id2}: {similarity}，其中 id1 为两个文档中较小的 id，similarity 为相似度，精确到小数点后 4 位。以任意顺序返回数组均可。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * [14, 15, 100, 9, 3],
 * [32, 1, 9, 3, 5],
 * [15, 29, 2, 6, 8, 7],
 * [7, 10]
 * ]
 * 输出:
 * [
 * "0,1: 0.2500",
 * "0,2: 0.1000",
 * "2,3: 0.1429"
 * ]
 * 提示：
 * <p>
 * docs.length <= 500
 * docs[i].length <= 500
 */
public class Face1726_ {

    //倒排索引的方式
    public static List<String> computeSimilarities(int[][] docs) {
        List<String> res = new ArrayList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[][] help = new int[docs.length][docs.length];//记录第i个文档与第j个文档后多少个相同的单词
        for (int i = 0; i < docs.length; i++) {
            for (int j = 0; j < docs[i].length; j++) {
                Set<Integer> set = map.get(docs[i][j]);
                if (set == null) {
                    set = new HashSet<>();
                    map.put(docs[i][j], set);
                } else {
                    //当前i阶段的k一定是小于i的
                    for (Integer k : set) {
                        help[i][k]++;
                    }
                }
                set.add(i);
            }
            //计算
            for (int k = 0; k < docs.length; k++) {
                if (help[i][k] != 0) {
                    //所以这里k在前，i在后，因为有效的help[i][k]的k一定是小于i的
                    res.add(k + "," + i + ": " + String.format("%.4f", (double) help[i][k] / (docs[i].length + docs[k].length - help[i][k])));
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] docs = new int[][] {{14, 15, 100, 9, 3}, {32, 1, 9, 3, 5}, {15, 29, 2, 6, 8, 7}, {7, 10}};
        computeSimilarities(docs);
    }

}
