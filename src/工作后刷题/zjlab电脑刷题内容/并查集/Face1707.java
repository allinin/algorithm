package 工作后刷题.zjlab电脑刷题内容.并查集;

import java.util.*;

/**
 * @Author: ZBL
 * @Date: 2024-01-16  10:58
 * 婴儿的名字
 * 每年，政府都会公布一万个最常见的婴儿名字和它们出现的频率，也就是同名婴儿的数量。
 * 有些名字有多种拼法，例如，John 和 Jon 本质上是相同的名字，但被当成了两个名字公布出来。
 * 给定两个列表，一个是名字及对应的频率，另一个是本质相同的名字对。
 * 设计一个算法打印出每个真实名字的实际频率。
 * 注意，如果 John 和 Jon 是相同的，并且 Jon 和 Johnny 相同，则 John 与 Johnny 也相同，
 * 即它们有传递和对称性。
 * <p>
 * 在结果列表中，选择 字典序最小 的名字作为真实名字。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：names = ["John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"],
 * synonyms = ["(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"]
 * 输出：["John(27)","Chris(36)"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * names.length <= 100000
 */
public class Face1707 {
    public String[] trulyMostPopular(String[] names, String[] synonyms) {

        List<String> res = new ArrayList<>();
        //名字：出现次数
        Map<String, Integer> map = new HashMap<>();
        for (String name : names) {
            int splitIndex = name.indexOf("(");
            map.put(name.substring(0, splitIndex), Integer.valueOf(name.substring(splitIndex + 1, name.length() - 1)));
        }
        //对字典中名字也进行统计编号，
        for(String str : synonyms) {
            int mid = str.indexOf(",");
            String name1 = str.substring(1,mid);
            String name2 = str.substring(mid + 1,str.length() - 1);
            if(!map.containsKey(name1)) {
                map.put(name1,0);
            }
            if(!map.containsKey(name2)) {
                map.put(name2,0);
            }
        }
        //名字进行编码，从而进行并查集
        int[] weight = new int[map.size()];
        List<String> nameList = new ArrayList<>(map.keySet());
        Collections.sort(nameList);
        Map<String, Integer> nameIdMap = new HashMap<>();
        int idx = 0;
        for (String name : nameList) {
            nameIdMap.put(name, idx);
            weight[idx] = map.get(name);
            idx++;
        }
        //构建并查集
        MergeSearchArray mergeSearchArray = new MergeSearchArray(weight.length, weight);
        for (String str : synonyms) {
            int mid = str.indexOf(",");
            Integer id1 = nameIdMap.get(str.substring(1, mid));
            Integer id2 = nameIdMap.get(str.substring(mid + 1, str.length() - 1));
            //合并
            mergeSearchArray.merge(id1, id2);

        }
        for (String str : nameList) {
            Integer id = nameIdMap.get(str);
            if (mergeSearchArray.find(id) == id) {
                StringBuilder sb = new StringBuilder();
                sb.append(str).append("(").append(mergeSearchArray.weights[id]).append(")");
                res.add(sb.toString());
            }
        }
        return res.toArray(new String[0]);
    }

    //并查集应用
    class MergeSearchArray {
        public int[] parents;
        public int[] weights;

        public MergeSearchArray(int n, int[] weight) {
            this.parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
            this.weights = new int[n];
            for (int i = 0; i < n; i++) {
                this.weights[i] = weight[i];
            }
        }

        public int find(int i) {
            int parent = parents[i];
            if (parent != i) {
                parent = find(parent);
            }
            parents[i] = parent;
            return parent;
        }

        public void merge(int i, int j) {
            int parentI = find(i);
            int parentJ = find(j);
            if (parentJ == parentI) {
                return;
            }
            if (parentI < parentJ) {
                parents[parentJ] = parentI;
                weights[parentI] += weights[parentJ];
            } else {
                parents[parentI] = parentJ;
                weights[parentJ] += weights[parentI];
            }
        }
    }

    public static void main(String[] args) {
        String[] names = {"a(10)","c(13)"};
        String[] synonyms = {"(a,b)","(c,d)","(b,c)"};
        String[] res = new Face1707().trulyMostPopular(names, synonyms);
        for (String str : res) {
            System.out.println(str);
        }
    }
}
