package ZUOSHEN.进阶班一.并查集;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author zbl
 * @version 1.0
 * @content: 题目要求见笔记并查集部分
 * @date 2020/1/1 10:17
 */
public class TarjanAndDisjoinSetsForLCA难 {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class Query {
        public Node o1;
        public Node o2;

        public Query(Node o1, Node o2) {
            this.o1 = o1;
            this.o2 = o2;
        }
    }

    // 主函数
    public static Node[] tarJanQuery(Node head, Query[] quries) {
        Node[] ans = new Tarjan().query(head, quries);
        return ans;
    }

    // Tarjan算法实现处理流程
    public static class Tarjan {
        private HashMap<Node, LinkedList<Node>> queryMap;
        private HashMap<Node, LinkedList<Integer>> indexMap;
        private HashMap<Node, Node> ancestorMap;
        private DisjointSets sets;

        public Tarjan() {
            queryMap = new HashMap<Node, LinkedList<Node>>();
            indexMap = new HashMap<Node, LinkedList<Integer>>();
            ancestorMap = new HashMap<Node, Node>();
            sets = new DisjointSets();
        }

        public Node[] query(Node head, Query[] ques) {
            Node[] ans = new Node[ques.length];
            setQueries(ques, ans);
            sets.makeSets(head); //使用并查集之前，先构造并查集最初的形态，
            setAnswers(head, ans);
            return ans;
        }

        private void setQueries(Query[] ques, Node[] ans) {
            Node o1 = null;
            Node o2 = null;
            for (int i = 0; i != ans.length; i++) {
                o1 = ques[i].o1;
                o2 = ques[i].o2;
                if (o1 == o2 || o1 == null || o2 == null) {
                    ans[i] = o1 != null ? o1 : o2;
                } else {
                    if (!queryMap.containsKey(o1)) {
                        queryMap.put(o1, new LinkedList<Node>());
                        indexMap.put(o1, new LinkedList<Integer>());
                    }
                    if (!queryMap.containsKey(o2)) {
                        queryMap.put(o2, new LinkedList<Node>());
                        indexMap.put(o2, new LinkedList<Integer>());
                    }
                    queryMap.get(o1).add(o2);
                    indexMap.get(o1).add(i);
                    queryMap.get(o2).add(o1);
                    indexMap.get(o2).add(i);
                }
            }
        }

        private void setAnswers(Node head, Node[] ans) {
            if (head == null) {
                return;
            }
            setAnswers(head.left, ans);
            sets.union(head.left, head);//合并并查集
            ancestorMap.put(sets.findFather(head), head);
            setAnswers(head.right, ans);
            sets.union(head.right, head);
            ancestorMap.put(sets.findFather(head), head);
            LinkedList<Node> nList = queryMap.get(head);
            LinkedList<Integer> iList = indexMap.get(head);
            Node node = null;
            Node nodeFather = null;
            int index = 0;
            while (nList != null && !nList.isEmpty()) {
                node = nList.poll();
                index = iList.poll();
                nodeFather = sets.findFather(node);
                if (ancestorMap.containsKey(nodeFather)) {
                    ans[index] = ancestorMap.get(nodeFather);
                }
            }
        }

    }

    // 实现Tarjan类中使用的并查集结构
    public static class DisjointSets {
        public HashMap<Node, Node> fatherMap;
        public HashMap<Node, Integer> rankMap;

        public DisjointSets() {
            fatherMap = new HashMap<Node, Node>(); // (B,A)
            rankMap = new HashMap<Node, Integer>();
        }

        public void makeSets(Node head) {
            fatherMap.clear();
            rankMap.clear();
            preOrderMake(head);
        }

        private void preOrderMake(Node head) {
            if (head == null) {
                return;
            }
            fatherMap.put(head, head);
            rankMap.put(head, 0);
            preOrderMake(head.left);
            preOrderMake(head.right);
        }

        public Node findFather(Node n) {
            Node father = fatherMap.get(n);
            if (father != n) {
                father = findFather(father);
            }
            fatherMap.put(n, father);
            return father;
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node aFather = findFather(a);
            Node bFather = findFather(b);
            if (aFather != bFather) {
                int aFrank = rankMap.get(aFather);
                int bFrank = rankMap.get(bFather);
                if (aFrank < bFrank) {
                    fatherMap.put(aFather, bFather);
                } else if (aFrank > bFrank) {
                    fatherMap.put(bFather, aFather);
                } else {
                    fatherMap.put(bFather, aFather);
                    rankMap.put(aFather, aFrank + 1);
                }
            }
        }

    }

    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        head.right.right.left = new Node(8);
        printTree(head);
        System.out.println("===============");

        // 生成查询数组
        Query[] qs = new Query[7];
        qs[0] = new Query(head.left.right, head.right.left);
        qs[1] = new Query(head.left.left, head.left);
        qs[2] = new Query(head.right.left, head.right.right.left);
        qs[3] = new Query(head.left.left, head.right.right);
        qs[4] = new Query(head.right.right, head.right.right.left);
        qs[5] = new Query(head, head);
        qs[6] = new Query(head.left, head.right.right.left);

        // Tarjan算法结合并查集解决所有查询问题
        Node[] ans = tarJanQuery(head, qs);

        // 打印答案
        for (int i = 0; i != ans.length; i++) {
            System.out.println("o1 : " + qs[i].o1.value);
            System.out.println("o2 : " + qs[i].o2.value);
            System.out.println("ancestor : " + ans[i].value);
            System.out.println("===============");
        }

    }

}
