package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.hard;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树的序列化与反序列化
 * <p>
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 * <p>
 * 输入：root = [1,2]
 * 输出：[1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中结点数在范围 [0, 104] 内
 * -1000 <= Node.val <= 1000
 */
public class Code297 {

    // Encodes a tree to a single string.

    private String NULL_NODE = "_";
    private String SPLIT = "#";

    // TODO 序列化与反序列的关键是在反序列化时能够快速确定根节点——————>中序遍历的方式无法实现
    //前序遍历的方式
    public String serialize(TreeNode root) {
        //前序遍历的方式序列化
        if (root == null) {
            return NULL_NODE + SPLIT;
        }
        String ans = root.val + SPLIT;
        String left = serialize(root.left);
        ans += left;
        String right = serialize(root.right);
        ans += right;
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] nodeArray = data.split(SPLIT);
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < nodeArray.length; i++) {
            list.add(nodeArray[i]);
        }
        return reConstruct(list);

    }

    private TreeNode reConstruct(LinkedList<String> list) {
        String val = list.poll();//弹出第一个确定根节点
        if (val.equals(NULL_NODE)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = reConstruct(list);
        root.right = reConstruct(list);
        return root;
    }

    //后序遍历的方式
    public String serialize2(TreeNode root) {
        //后序遍历的方式序列化
        if (root == null) {
            return NULL_NODE + SPLIT;
        }
        String ans = "";
        ans += serialize(root.left);
        ans += serialize(root.right);
        ans += root.val + SPLIT;
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] nodeArray = data.split(SPLIT);
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < nodeArray.length; i++) {
            list.add(nodeArray[i]);
        }
        return reConstruct2(list);
    }

    private TreeNode reConstruct2(LinkedList<String> list) {
        if(list.isEmpty()) {
            return null;
        }
        String val = list.pollLast();//弹出最后一个，确定根节点
        if (val.equals(NULL_NODE)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(val));
        //后序的方式先构建右子树
        root.right = reConstruct2(list);
        //再构建左子树
        root.left = reConstruct2(list);
        return root;
    }

    /**
     * 按层遍历的方式
     * @param root
     * @return
     */
    public String serialize3(TreeNode root) {
        if (root == null) {
            return NULL_NODE + SPLIT;
        }
        String ans = root.val + SPLIT;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while(!deque.isEmpty()) {
            int size = deque.size();
            for(int i = 0;i < size;i++) {
                TreeNode node = deque.poll();
                if(node.left != null) {
                    deque.add(node.left);
                    ans += node.left.val + SPLIT;
                } else {
                    ans += NULL_NODE + SPLIT;
                }
                if(node.right != null) {
                    deque.add(node.right);
                    ans += node.right.val + SPLIT;
                } else {
                    ans += NULL_NODE + SPLIT;
                }
            }
        }
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize3(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] nodeArray = data.split(SPLIT);
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < nodeArray.length; i++) {
            list.add(nodeArray[i]);
        }
        return reConstruct3(list);
    }

    private TreeNode reConstruct3(LinkedList<String> list) {
        if(list.isEmpty()) {
            return null;
        }
        String val = list.poll();//弹出最后一个，确定根节点
        if (val.equals(NULL_NODE)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(val));
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while(!deque.isEmpty()) {
            int size = deque.size();
            for(int i = 0;i < size;i++) {
                TreeNode node = deque.poll();
                String leftVal = list.poll();
                String rightVal = list.poll();
                if(!leftVal.equals(NULL_NODE)) {
                    TreeNode left = new TreeNode(Integer.valueOf(leftVal));
                    node.left = left ;
                    deque.add(left);
                }
                if(!rightVal.equals(NULL_NODE)) {
                    TreeNode right = new TreeNode(Integer.valueOf(rightVal));
                    node.right = right ;
                    deque.add(right);
                }
            }
        }
        return root;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
