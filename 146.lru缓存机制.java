import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 * 1.hashtable 用于kv操作
 * 2.listnode 用于控制缓存长度，最近和最新的设置
 * ps:单向链表删除一个节点需要访问它的前驱节点，它只能花 O(n) 时间遍历查找它.
 * 因此这里需要用双向链表，便于节点的操作。
 * public class DlinkListNode {
    int val;
    DlinkListNode next;
    DlinkListNode prev;

    DlinkListNode(int x) {
        val = x;
    }
}
 */

// @lc code=start
class LRUCache {
    class DlinkListNode {
        int val;
        int key;
        // key的设置，便于后面的删除map操作
        DlinkListNode next;
        DlinkListNode prev;

        DlinkListNode() {
        }

        DlinkListNode(int x, int y) {
            val = y;
            key = x;
        }
    }

    public static void main(String[] args) {
        LRUCache a = new LRUCache(2);
        a.put(1, 1);
        a.put(2, 2);
        System.out.println(a.get(1));
        a.put(3, 3);
        System.out.println(a.get(2));

        a.put(4, 4);
        System.out.println(a.get(1));//
        System.out.println(a.get(3));
        System.out.println(a.get(4));

    }

    HashMap<Integer, DlinkListNode> map;
    int size;
    DlinkListNode head;
    DlinkListNode tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        size = capacity;
        head = new DlinkListNode();
        tail = new DlinkListNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.keySet().contains(key)) {
            movetohead(map.get(key));
            return map.get(key).val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.keySet().contains(key)) {
            map.get(key).val = value;
            movetohead(map.get(key));
        } else {
            if (map.size() < size) {
                DlinkListNode newNode = new DlinkListNode(key, value);
                map.put(key, newNode);
                addNode(newNode);
            } else {
                DlinkListNode newNode = new DlinkListNode(key, value);
                map.put(key, newNode);
                addNode(newNode);
                // 先清除map的值，再去掉链表里的尾节点
                map.remove(tail.prev.key);
                deleteTail();

            }
        }
    }

    /**
     * 每次都加在head后面
     * 
     * @param newNode
     */
    private void addNode(DlinkListNode newNode) {
        DlinkListNode temp = head.next;
        head.next = newNode;
        temp.prev = newNode;
        newNode.prev = head;
        newNode.next = temp;
    }

    /**
     * 容量不够的时候，删除最末尾的节点
     */
    private void deleteTail() {
        remove(tail.prev);
    }

    private void remove(DlinkListNode dlinkListNode) {
        dlinkListNode.prev.next = dlinkListNode.next;
        dlinkListNode.next.prev = dlinkListNode.prev;
    }

    /**
     * 每次对目标node做get或者put操作，都需要将其更新到head后面，并和之前的节点兄弟告别
     * 
     * @param dlinkListNode
     */
    private void movetohead(DlinkListNode dlinkListNode) {
        remove(dlinkListNode);
        addNode(dlinkListNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// @lc code=end
