package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZBL
 * @Date: 2023-12-22  14:35
 * <p>
 * LRU缓存
 * <p>
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 105
 * 最多调用 2 * 105 次 get 和 put
 */
public class LRUCache {

    private Map<Integer, LRUNode> map;
    private LRUNode head;

    private LRUNode tail;
    private int capacity;

    private int len;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new LRUNode(-1, -1);
        this.tail = new LRUNode(-1, -1);
        this.len = 0;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        LRUNode node = map.get(key);
        //当前节点断开
        node.pre.next = node.next;
        node.next.pre = node.pre;

        //当前节点放到开头
        head.next.pre = node;
        node.next = head.next;
        node.pre = head;
        head.next = node;
        return node.val;
    }

    public void put(int key, int value) {
        LRUNode lruNode = map.get(key);
        if (len == capacity && lruNode == null) {
            //删除最后一个节点
            LRUNode last = tail.pre;
            map.remove(last.key);
            tail.pre = last.pre;
            last.pre.next = tail;
            last.pre = null;
            last.next = null;
            len--;
        }
        //当前key不存在
        if(lruNode == null) {
            LRUNode cur = new LRUNode(key,value);
            map.put(key,cur);
            head.next.pre = cur;
            cur.next = head.next;
            head.next = cur;
            cur.pre = head;
            len++;
        } else {
            lruNode.val = value;
            map.put(key,lruNode);
            //当前节点断开
            lruNode.pre.next = lruNode.next;
            lruNode.next.pre = lruNode.pre;

            //当前节点放到开头
            head.next.pre = lruNode;
            lruNode.next = head.next;
            lruNode.pre = head;
            head.next = lruNode;
        }

    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1,1);
        lRUCache.put(2,2);
        lRUCache.get(1);
        lRUCache.put(3,3);
    }
}

class LRUNode {
    int val;
    int key; //put操作时可能需要删除最后一个节点，需要通过节点获取当前节点对应的key,从而从map中删除
    LRUNode pre;
    LRUNode next;

    public LRUNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.pre = null;
        this.next = null;
    }
}
//["LRUCache","get","put","get","put","put","get","get"]
//[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
