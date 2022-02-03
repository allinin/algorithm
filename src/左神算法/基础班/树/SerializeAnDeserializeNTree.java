package 左神算法.基础班.树;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAnDeserializeNTree {

    /**
     * 定义n叉树的节点
     */
    public static class Node{
        int val;
        List<Node> children;
        Node(){}
        Node(int val,List<Node> childern){
            this.val = val;
            this.children = childern;
        }
    }

    /**
     * 序列化操作，其实就是dfs的过程，并且记录每个节点孩子的数量
     * @param root
     * @return
     */
    public String serialize(Node root){
        if(root == null){
            return "";
        }
        List<String> list = new ArrayList<>();
        process(root,list);
        return String.join("#",list);
    }
    private void process(Node root,List<String>list){
        if(root == null){
            return;
        }
        String val = String.valueOf(root.val);
        String childrendNum = String.valueOf(root.children.size());
        list.add(val);
        list.add(childrendNum);
        for(Node node : root.children){
            process(node,list);
        }
    }

    /**
     * 反序列化操作
     * @param data
     * @return
     */
    public Node deserialize(String data){
        if(data == null || data.length() == 0){
            return null;
        }
        String[] strs = data.split("#");
        Queue<String> queue = new LinkedList<>();
        for(String str : strs){
            queue.add(str);
        }
        return doDeserialize(queue);
    }
    private Node doDeserialize(Queue<String> queue){
       Node root = new Node();
       int val = Integer.valueOf(queue.poll());
       int size = Integer.valueOf(queue.poll());
       root.val = val;
       root.children = new ArrayList<>(size);
       for(int i = 0;i < size;i++){
           root.children.add(doDeserialize(queue));
       }
       return root;
    }
}
