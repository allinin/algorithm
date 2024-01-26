package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;
import java.util.*;

/**
 * 除法求值
 * <p>
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 * <p>
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 * <p>
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
 * <p>
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 * <p>
 * 注意：未在等式列表中出现的变量是未定义的，因此无法确定它们的答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * 解释：
 * 条件：a / b = 2.0, b / c = 3.0
 * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
 * 注意：x 是未定义的 => -1.0
 * 示例 2：
 * <p>
 * 输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * 输出：[3.75000,0.40000,5.00000,0.20000]
 * 示例 3：
 * <p>
 * 输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * 输出：[0.50000,2.00000,-1.00000,-1.00000]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj 由小写英文字母与数字组成
 */
public class Code399_DONE {

    //TODO 并查集的方式
    public double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int len = values.length;
        UnionFind unionFind = new UnionFind(2 * len);//最多可能有2 * len个元素
        Map<String, Integer> map = new HashMap<>();//将原来的字符串转化为数值，便于使用并查集
        int idx = 0, index = 0;
        for (List<String> equation : equations) {
            String x = equation.get(0);
            String y = equation.get(1);
            if (!map.containsKey(x)) {
                map.put(x, idx++);
            }
            if (!map.containsKey(y)) {
                map.put(y, idx++);
            }
            //x,y之间是有交集的两个子集，合并
            unionFind.union(map.get(x), map.get(y), values[index++]);
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String x = query.get(0);
            String y = query.get(1);
            if (!map.containsKey(x) || !map.containsKey(y)) {
                res[i] = -1.0d;
            } else {
                res[i] = unionFind.connectCalculate(map.get(x), map.get(y));
            }
        }
        return res;
    }

    class UnionFind {

        //用来存放每个元素的及父节点之间的关系
        int[] parents;
        //用来存放元素及父节点之间的权重关系,这里表示parent[x] / x的值
        double[] weights;

        public UnionFind(int m) {
            this.parents = new int[m];
            this.weights = new double[m];
            //初始化每个元素与父节点之间的权重关系为1,0
            Arrays.fill(weights, 1.0d);
            //初始化每个元素的父节点都是元素本身，共有m个独立的子集
            for (int i = 0; i < m; i++) {
                parents[i] = i;
            }
        }

        public int find(int x) {
            int parent = parents[x];
            if (parent == x) {
                return parent;
            }
            int root = find(parent);
            parents[x] = root;
            weights[x] = weights[x] * weights[parent];
            return root;
        }

        public void union(int x, int y, double k) {
            int parentX = find(x);
            int parentY = find(y);
            if (parentY == parentX) {
                return;
            }
            //合并
            parents[parentY] = parentX;
            weights[parentY] = weights[x] / weights[y] * k;
        }

        public double connectCalculate(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            //x与y属于同一个子集
            if (parentX == parentY) {
                return weights[y] / weights[x];
            }
            //否则无法计算
            return -1.0d;
        }
    }

    /**
     * dfs的方式
     *
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        List<List<String>> equationsTmp = new ArrayList<>();
        double[] valuesTmp = new double[values.length * 2];
        //记录有哪些不同的表达式
        Set<String> set = new HashSet<>();
        int index = 0;
        //扩充原来的等式集合
        for (List<String> list : equations) {
            equationsTmp.add(list);
            valuesTmp[index] = values[index / 2];
            List<String> tmp = new ArrayList<>();
            tmp.add(list.get(1));
            tmp.add(list.get(0));
            equationsTmp.add(tmp);
            valuesTmp[++index] = 1.0 / values[index / 2];
            index++;
            set.addAll(list);
        }
        double[] res = new double[queries.size()];
        Arrays.fill(res, -1.0);
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            if (!set.contains(query.get(0)) || !set.contains(query.get(1))) {
                res[i] = -1.0;
            } else if (query.get(0).equals(query.get(1))) {
                res[i] = 1.0;
            } else {
                for (int j = 0; j < equationsTmp.size(); j++) {
                    if (equationsTmp.get(j).get(0).equals(query.get(0))) {
                        boolean[] visited = new boolean[equationsTmp.size()];
                        visited[j] = true;
                        double ans = process(equationsTmp.get(j).get(1), query.get(1), equationsTmp, valuesTmp, valuesTmp[j], visited);
                        if (ans != -1.0) {
                            res[i] = ans;
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }

    private double process(String start, String end, List<List<String>> equations, double[] values, double value, boolean[] visited) {
        if (start.equals(end)) {
            return value;
        }
        for (int i = 0; i < equations.size(); i++) {
            if (equations.get(i).get(0).equals(start) && !visited[i]) {
                value *= values[i];
                visited[i] = true;
                double ans = process(equations.get(i).get(1), end, equations, values, value, visited);
                if (ans != -1.0) {
                    return ans;
                } else {
                    //回溯
                    value /= values[i];
                    visited[i] = false;
                }
            }
        }
        return -1.0;
    }


    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        equations.add(list1);
        List<String> list = new ArrayList<>();
        list.add("b");
        list.add("c");
        equations.add(list);
        List<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("c");
        equations.add(list2);
        List<String> list3 = new ArrayList<>();
        list3.add("d");
        list3.add("e");
        equations.add(list3);
        double[] values = new double[]{2.0, 3.0, 6.0, 1.0};
        List<List<String>> queries = new ArrayList<>();
        List<String> query1 = new ArrayList<>();
        query1.add("a");
        query1.add("c");
        queries.add(query1);
        List<String> query2 = new ArrayList<>();
        query2.add("b");
        query2.add("c");
        queries.add(query2);

        List<String> query3 = new ArrayList<>();
        query3.add("a");
        query3.add("e");
        queries.add(query3);


        List<String> query4 = new ArrayList<>();
        query4.add("a");
        query4.add("d");
        queries.add(query4);

        double[] doubles = new Code399_DONE().calcEquation(equations, values, queries);
        double[] doubles2 = new Code399_DONE().calcEquation2(equations, values, queries);
        for(int i = 0;i < doubles2.length;i++) {
            System.out.println(doubles2[i] == doubles[i]);
        }


    }
}