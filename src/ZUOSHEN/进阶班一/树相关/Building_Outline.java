package ZUOSHEN.进阶班一.树相关;

import java.util.*;

/**
 * @author zbl
 * @version 1.0
 * @content:给定一个n*3的矩阵，每一行代表有一座大楼，一共有N座大楼，所有大楼的地步都坐落在X轴上，每一行有三个值（a,b,c）表示每座大楼从
 * （a,0)点开始，到（b,0)点结束，高度为c.输入数据可以保证a<b，且a,b,c均为正数，大楼之间可以有重叠。请输出整体的轮廓线
 * @date 2020/1/3 13:43
 */
public class Building_Outline {

    //只有高度变化时才会描述轮廓
    public static class Node {
        public boolean isUp;
        public int posi;
        public int h;

        public Node(boolean bORe, int position, int height) {
            isUp = bORe;
            posi = position;
            h = height;
        }
    }

    public static class NodeComparator implements Comparator<Node> {
        //只按位置排序
        @Override
        public int compare(Node o1, Node o2) {
            if (o1.posi != o2.posi) {
                return o1.posi - o2.posi;
            }
            //相同位置的时候
            if (o1.isUp != o2.isUp) {
                return o1.isUp ? -1 : 1;
            }
            return 0;
        }
    }

    public static List<List<Integer>> buildingOutline(int[][] buildings) {
        Node[] nodes = new Node[buildings.length * 2];
        for (int i = 0; i < buildings.length; i++) {
            nodes[i * 2] = new Node(true, buildings[i][0], buildings[i][2]);
            nodes[i * 2 + 1] = new Node(false, buildings[i][1], buildings[i][2]);
        }
        Arrays.sort(nodes, new NodeComparator());
        TreeMap<Integer, Integer> htMap = new TreeMap<>();// k:高度，v:高度出现的次数
        TreeMap<Integer, Integer> pmMap = new TreeMap<>();//存放每一个位置的最大高度，k:位置，v:高度
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].isUp) {
                if (!htMap.containsKey(nodes[i].h)) {
                    htMap.put(nodes[i].h, 1);
                } else {
                    htMap.put(nodes[i].h, htMap.get(nodes[i].h) + 1);
                }
            } else {
                if (htMap.containsKey(nodes[i].h)) {
                    if (htMap.get(nodes[i].h) == 1) {
                        htMap.remove(nodes[i].h);
                    } else {
                        htMap.put(nodes[i].h, htMap.get(nodes[i].h) - 1);
                    }
                }
            }
            if (htMap.isEmpty()) {
                pmMap.put(nodes[i].posi, 0);
            } else {
                pmMap.put(nodes[i].posi, htMap.lastKey());//lastkey（）取出的是最大的key
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        int height = 0;
        for (Map.Entry<Integer, Integer> entry : pmMap.entrySet()) {
            int curPosition = entry.getKey();
            int curMaxHeight = entry.getValue();
            if (height != curMaxHeight) {
                if (height != 0) {
                    List<Integer> newRecord = new ArrayList<Integer>();
                    newRecord.add(start);
                    newRecord.add(curPosition);
                    newRecord.add(height);
                    res.add(newRecord);
                }
                start = curPosition;
                height = curMaxHeight;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeMap<Integer,Integer> tree=new TreeMap<>(
        );
        tree.put(8,1);
        tree.put(2,2);
        tree.put(4,4);
        tree.put(10,2);
        tree.put(5,3);
        tree.put(-1,2);
        System.out.println(tree.keySet());
        System.out.println(tree.lastKey());
    }
}
