package LeetCodeHot100;

import java.util.HashMap;

/**
 * leetCode 666 路径总和IV
 */
public class LeetCode666 {
    HashMap<Integer,Integer> map = new HashMap<>();
    int ans = 0;
    public int pathSum(int[] arr) {
        if(arr == null || arr.length == 0) {
            return 0;
        }
        for(int num : arr) {
            map.put(num / 10,num % 10);
        }
        process(arr[0] / 10,0);
        return ans;
    }
    private void process(int node ,int sum) {
        if(!map.containsKey(node)){
            return;
        }
        sum += map.get(node);
        int level = node / 10; // 当前节点的深度
        int pos = level % 10; // 当前节点在该层的编号
        int nextlevel = level + 1;
        int leftNode = nextlevel * 10 + 2 * pos - 1; // 左子节点的编号
        int rightNode = nextlevel * 10 + 2 * pos + 1; // 右子节点的编号
        if(!map.containsKey(leftNode) && !map.containsKey(rightNode)) {
            ans += sum;
        } else {
            process(leftNode,sum);
            process(rightNode,sum);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {113,215,221};
        System.out.println(new LeetCode666().pathSum(arr));
    }
}
