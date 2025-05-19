package hot100;

import java.util.HashMap;

/**
 * @author xlj
 * @date 2025-05-15
 * @description  LRU缓存
 *
 * 3. 核心思路（复习用）
 * 哈希表 + 双向链表：
 * 哈希表快速定位节点。
 * 双向链表维护 LRU 顺序，尾部最近使用，头部最久未用。
 * 操作流程：
 * get：哈希表查找，找到后移到尾部，返回值。
 * put：若存在，更新值并移到尾部；若不存在，插入尾部，超容量时移除头部。
 * 为什么 O(1)：
 * 哈希表查找 O(1)。
 * 双向链表插入/删除 O(1)（有前后指针）。
 */

public class LRUCache {
    // 定义双向链表节点，存储键值对及前后指针
    class DoubleNode {
        int key, value;
        DoubleNode prev, next;
        DoubleNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, DoubleNode> map;
    private DoubleNode head, tail;
    private int capacity, size;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DoubleNode(0, 0); // 头节点
        tail = new DoubleNode(0, 0); // 尾节点
        head.next = tail;
        tail.prev = head;
    }

    // 获取键值，若存在返回 value 并标记为最近使用，否则返回 -1
    public int Get(int key) {
        DoubleNode node = map.get(key);
        if (node == null) return -1;
        moveToTail(node);
        return node.value;
    }

    public void Put(int key, int value) {
        DoubleNode node = map.get(key);// 查找是否已存在
        if (node != null) {
            node.value = value;
            moveToTail(node);
        } else {
            DoubleNode newNode = new DoubleNode(key, value);
            map.put(key, newNode);
            addToTail(newNode);
            size++; //size控制的当前cache容量++
            if (size > capacity) {
                DoubleNode lru = removeHead();
                map.remove(lru.key);
                size--;
            }
        }
    }

    private void addToTail(DoubleNode node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    private void moveToTail(DoubleNode node) {
        removeNode(node);
        addToTail(node);
    }

    private void removeNode(DoubleNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private DoubleNode removeHead() {
        if (head.next == tail) return null; // 空链表
        DoubleNode node = head.next;
        removeNode(node);
        return node;
    }
}
