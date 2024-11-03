package designcircularqueue;

//https://leetcode.cn/problems/design-circular-queue/
public class DesignCirlarQueue {
    static class MyCircularQueue {
        int[] queue;
        int l, r, capacity;
        int size;

        public MyCircularQueue(int k) {
            queue = new int[k];
            l = r = size =0;
            capacity = k;
        }

        public boolean enQueue(int value) {
            if (size < capacity) {
                queue[r] = value;
                r = (r + 1) % capacity;
                size++;
                return true;
            }
            return false; // 示例返回
        }

        public boolean deQueue() {
            if (size != 0) {
                l = (l + 1) % capacity; // 使用取模运算更新l
                size--;
                return true;
            }
            return false; // 示例返回
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return queue[l];
        }

        public int Rear() {
            if(isEmpty()){
                return -1;
            }

            if ((r == 0)){
                //这里原本写成size - 1了。。。如果不是满队列的情况就会出错
                //还奇怪为啥一直过不了
                return queue[capacity - 1];
            }else {
                return  queue[r - 1];
            }

        }

        public boolean isEmpty() {
            return size == 0; // 队列为空
        }

        public boolean isFull() {
            return size == capacity; // 队列已满
        }

        public static void main(String[] args) {
            MyCircularQueue circularQueue = new MyCircularQueue(3); // 创建一个容量为3的循环队列

            // 测试用例 1: 添加元素
            System.out.println(circularQueue.enQueue(1)); // 预期输出: true
            System.out.println(circularQueue.enQueue(2)); // 预期输出: true
            System.out.println(circularQueue.enQueue(3)); // 预期输出: true
            System.out.println(circularQueue.enQueue(3)); // 预期输出: true
            System.out.println(circularQueue.enQueue(4)); // 预期输出: false（队列已满）

            // 测试用例 2: 获取队头和队尾元素
            System.out.println(circularQueue.Front()); // 预期输出: 1
            System.out.println(circularQueue.Rear()); // 预期输出: 3

            // 测试用例 3: 移除元素
            System.out.println(circularQueue.deQueue()); // 预期输出: true
            System.out.println(circularQueue.Front()); // 预期输出: 2

            // 测试用例 4: 再次添加元素
            System.out.println(circularQueue.enQueue(4)); // 预期输出: true
            System.out.println(circularQueue.Rear()); // 预期输出: 4
        }
    }
}
