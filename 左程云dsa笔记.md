# 基础知识

## 左移右移

- x << n **除2**

```
int x = 3; // 二进制: 0000 0011
int result = x << 2; // 向左移动 2 位: 0000 1100
System.out.println(result); // 输出: 12

```



- x >> n **乘2**

# 处理输入输出

- 1）填函数风格

- 2）acm风格（笔试、比赛最常见）
      a. 规定数据量(BufferedReader、StreamTokenizer、PrintWriter)，其他语言有对等的写法
      b. 按行读(BufferedReader、PrintWriter)，其他语言有对等的写法
      c. 不要用Scanner、System.out，IO效率慢
  3）不推荐：临时动态空间
  4）推荐：全局静态空间

全局静态空间就是再一开始就定义好辅助数组

![image-20241216100446881](https://raw.githubusercontent.com/xiechen274/ChenCsNote/images/images/image-20241216100446881.png)

# 时间复杂度

![image-20240710174422149](https://raw.githubusercontent.com/xiechen274/ChenCsNote/images/images/image-20240710174422149.png)

数组空间复杂度on

随机算法的考量不能以最差时间为时间复杂度

![image-20240710174324665](https://raw.githubusercontent.com/xiechen274/ChenCsNote/images/images/image-20240710174324665.png)

## 复杂度均摊

下面的13条从左到右时间逐渐增加

![image-20240710174657079](https://raw.githubusercontent.com/xiechen274/ChenCsNote/images/images/image-20240710174657079.png)

动态数组为引入，算出总体，然后求单个的时间复杂度

![image-20240710175023676](https://raw.githubusercontent.com/xiechen274/ChenCsNote/images/images/image-20240710175023676.png)

- 不要轻易用代码的结构来判断复杂度

  ![image-20240710175739004](https://raw.githubusercontent.com/xiechen274/ChenCsNote/images/images/image-20240710175739004.png)

还有一个例子，调和级数，双重for不一定是n方

![image-20240710180026864](https://raw.githubusercontent.com/xiechen274/ChenCsNote/images/images/image-20240710180026864.png)



# 数据结构

## 链表

## 栈和队列

栈是一种逻辑结构，可以用不同的数据结构去实现

**队列**：先进先出，从尾进，从头出

**栈**：先进后出

### 队列

两个指针，LR

- 加入的数确定的时候 ，数组实现。比较方便，单项，数组的范围是[l,r)左闭右开，r的下标是即将进入的数存放的地方

![image-20241103172534137](https://raw.githubusercontent.com/xiechen274/ChenCsNote/images/images/image-20241103172534137.png)

- 用java原生实现的队列，用LinkList双向链表

  *缺点：常数时间慢* o（1）

  ```java
  public static class Queue1 {
  
  		// java中的双向链表LinkedList
  		// 单向链表就足够了
  		public Queue<Integer> queue = new LinkedList<>();
  
  		// 调用任何方法之前，先调用这个方法来判断队列内是否有东西
  		public boolean isEmpty() {
  			return queue.isEmpty();
  		}
  
  		// 向队列中加入num，加到尾巴
  		public void offer(int num) {
  			queue.offer(num);
  		}
  
  		// 从队列拿，从头拿
  		public int poll() {
  			return queue.poll();
  		}
  
  		// 返回队列头的元素但是不弹出
  		public int peek() {
  			return queue.peek();
  		}
  
  		// 返回目前队列里有几个数
  		public int size() {
  			return queue.size();
  		}
  
  	}
  ```

  

- 数组实现队列

```java
//l .... r

// 实际刷题时更常见的写法，常数时间好
	// 如果可以确定加入操作的总次数不超过n，那么可以用
	// 一般笔试、面试都会有一个明确数据量，所以这是最常用的方式
	public static class Queue2 {

		public int[] queue;
		public int l;
		public int r;

		// 加入操作的总次数上限是多少，一定要明确
		public Queue2(int n) {
			queue = new int[n];
			l = 0;
			r = 0;
		}

		// 调用任何方法之前，先调用这个方法来判断队列内是否有东西
		public boolean isEmpty() {
			return l == r;
		}

		public void offer(int num) {
			queue[r++] = num;
		}

		public int poll() {
			return queue[l++];
		}
		// ?
		// l...r-1 r
		// [l..r)
		public int head() {
			return queue[l];
		}

		public int tail() {
			return queue[r - 1];
		}

		public int size() {
			return r - l;
		}

	}
```

### 栈

- 数组实现栈

![image-20241103173624287](https://raw.githubusercontent.com/xiechen274/ChenCsNote/images/images/image-20241103173624287.png)

**在弹出的时候**，没有必要删除掉原来的数据，size来决定有效范围就好了，相当简单

#### java原生实现

```java
// 直接用java内部的实现
// 其实就是动态数组，不过常数时间并不好
public static class Stack1 {

    public Stack<Integer> stack = new Stack<>();

    // 调用任何方法之前，先调用这个方法来判断栈内是否有东西
    public boolean isEmpty() {
       return stack.isEmpty();
    }

    public void push(int num) {
       stack.push(num);
    }

    public int pop() {
       return stack.pop();
    }

    public int peek() {
       return stack.peek();
    }

    public int size() {
       return stack.size();
    }

}
```

#### 数组实现

```java
// 实际刷题时更常见的写法，常数时间好
// 如果可以保证同时在栈里的元素个数不会超过n，那么可以用
// 也就是发生弹出操作之后，空间可以复用
// 一般笔试、面试都会有一个明确数据量，所以这是最常用的方式
public static class Stack2 {

    public int[] stack;
    public int size;

    // 同时在栈里的元素个数不会超过n
    public Stack2(int n) {
       stack = new int[n];
       size = 0;
    }

    // 调用任何方法之前，先调用这个方法来判断栈内是否有东西
    public boolean isEmpty() {
       return size == 0;
    }

    public void push(int num) {
       stack[size++] = num;
    }

    public int pop() {
       return stack[--size];
    }

    public int peek() {
       return stack[size - 1];
    }

    public int size() {
       return size;
    }

}
```



#### 循环队列

![image-20241103181809582](https://raw.githubusercontent.com/xiechen274/ChenCsNote/images/images/image-20241103181809582.png)

**循环队列的实现**

通过新增一个size变量来控制队列的行为

![image-20241103182544586](https://raw.githubusercontent.com/xiechen274/ChenCsNote/images/images/image-20241103182544586.png)

```java
// 设计循环队列
// 测试链接 : https://leetcode.cn/problems/design-circular-queue/
class MyCircularQueue {

    public int[] queue;

    public int l, r, size, limit;

    // 同时在队列里的数字个数，不要超过k
    public MyCircularQueue(int k) {
       queue = new int[k];
       l = r = size = 0;
       limit = k;
    }

    // 如果队列满了，什么也不做，返回false
    // 如果队列没满，加入value，返回true
    public boolean enQueue(int value) {
       if (isFull()) {
          return false;
       } else {
          queue[r] = value;
          // r++, 结束了，跳回0
          r = r == limit - 1 ? 0 : (r + 1);
          size++;
          return true;
       }
    }

    // 如果队列空了，什么也不做，返回false
    // 如果队列没空，弹出头部的数字，返回true
    public boolean deQueue() {
       if (isEmpty()) {
          return false;
       } else {
          // l++, 结束了，跳回0
          l = l == limit - 1 ? 0 : (l + 1);
          size--;
          return true;
       }
    }

    // 返回队列头部的数字（不弹出），如果没有数返回-1
    public int Front() {
       if (isEmpty()) {
          return -1;
       } else {
          return queue[l];
       }
    }

    public int Rear() {
       if (isEmpty()) {
          return -1;
       } else {
          //处理循环问题
          int last = r == 0 ? (limit - 1) : (r - 1);
          return queue[last];
       }
    }

    public boolean isEmpty() {
       return size == 0;
    }

    public boolean isFull() {
       return size == limit;
    }

}
```

### 栈和队列互相实现

![image-20241110131147596](https://raw.githubusercontent.com/xiechen274/ChenCsNote/images/images/image-20241110131147596.png)

实现的逻辑

![image-20241110131734624](https://raw.githubusercontent.com/xiechen274/ChenCsNote/images/images/image-20241110131734624.png)

![image-20241110132156169](https://raw.githubusercontent.com/xiechen274/ChenCsNote/images/images/image-20241110132156169.png)

用队列实现栈

![image-20241110135759279](https://raw.githubusercontent.com/xiechen274/ChenCsNote/images/images/image-20241110135759279.png)

- 用栈实现队列最核心的就是在每次push pop peek类似的方法前先对in out 的stack进行是否到数据的判断，这是核心思想

## 二叉树及三种序遍历

![image-20241116175536950](https://raw.githubusercontent.com/xiechen274/ChenCsNote/images/images/image-20241116175536950.png)

拿后续遍历举个例子

![image-20241116180740263](https://raw.githubusercontent.com/xiechen274/ChenCsNote/images/images/image-20241116180740263.png)

递归实现非常简单，举两个列子理解就好了，先遍历那个就先打印谁，然后再递归遍历其他部分

```java
// 先序打印所有节点，递归版
public static void preOrder(TreeNode head) {
    if (head == null) {
       return;
    }
    System.out.print(head.val + " ");
    preOrder(head.left);
    preOrder(head.right);
}

// 中序打印所有节点，递归版
public static void inOrder(TreeNode head) {
    if (head == null) {
       return;
    }
    inOrder(head.left);
    System.out.print(head.val + " ");
    inOrder(head.right);
}
```

### 非递归遍历

![image-20241116182431341](https://raw.githubusercontent.com/xiechen274/ChenCsNote/images/images/image-20241116182431341.png)

```java
// 先序打印所有节点，非递归版
public static void preOrder(TreeNode head) {
    if (head != null) {
       Stack<TreeNode> stack = new Stack<>();
       stack.push(head);
       while (!stack.isEmpty()) {
          head = stack.pop();
          System.out.print(head.val + " ");
          if (head.right != null) {
             stack.push(head.right);
          }
          if (head.left != null) {
             stack.push(head.left);
          }
       }
       System.out.println();
    }
}

// 中序打印所有节点，非递归版
public static void inOrder(TreeNode head) {
    if (head != null) {
       Stack<TreeNode> stack = new Stack<>();
       while (!stack.isEmpty() || head != null) {
          if (head != null) {
             stack.push(head);
             head = head.left;
          } else {
             head = stack.pop();
             System.out.print(head.val + " ");
             head = head.right;
          }
       }
       System.out.println();
    }
}

// 后序打印所有节点，非递归版
// 这是用两个栈的方法
public static void posOrderTwoStacks(TreeNode head) {
    if (head != null) {
       Stack<TreeNode> stack = new Stack<>();
       Stack<TreeNode> collect = new Stack<>();
       stack.push(head);
       while (!stack.isEmpty()) {
          head = stack.pop();
          collect.push(head);
          if (head.left != null) {
             stack.push(head.left);
          }
          if (head.right != null) {
             stack.push(head.right);
          }
       }
       while (!collect.isEmpty()) {
          System.out.print(collect.pop().val + " ");
       }
       System.out.println();
    }
}

// 后序打印所有节点，非递归版
// 这是用一个栈的方法
public static void posOrderOneStack(TreeNode h) {
    if (h != null) {
       Stack<TreeNode> stack = new Stack<>();
       stack.push(h);
       // 如果始终没有打印过节点，h就一直是头节点
       // 一旦打印过节点，h就变成打印节点
       // 之后h的含义 : 上一次打印的节点
       while (!stack.isEmpty()) {
          TreeNode cur = stack.peek();
          if (cur.left != null && h != cur.left && h != cur.right) {
             // 有左树且左树没处理过
             stack.push(cur.left);
          } else if (cur.right != null && h != cur.right) {
             // 有右树且右树没处理过
             stack.push(cur.right);
          } else {
             // 左树、右树 没有 或者 都处理过了
             System.out.print(cur.val + " ");
             h = stack.pop();
          }
       }
       System.out.println();
    }
}
```

非递归中序遍历

每个子树都要处理完自己的左树在处理自己在处理右树

![image-20241116190827421](https://raw.githubusercontent.com/xiechen274/ChenCsNote/images/images/image-20241116190827421.png)

后序遍历，可以用先序遍历的反转，再用一个栈收集弹出的数，然后再对这个栈打印

![image-20241116191729920](https://raw.githubusercontent.com/xiechen274/ChenCsNote/images/images/image-20241116191729920.png)

**一个栈的后序遍历**

### 复杂度

递归和非递归的事件复杂度都是O(h) h是树的高度，因为每次遍历同一层虽然有很多数据但是只会消耗一个空间来读取，在读取别的数据了之后这空间就被复用到其他的空间上了

![image-20241116194646127](https://raw.githubusercontent.com/xiechen274/ChenCsNote/images/images/image-20241116194646127.png)

# 排序

## 归并排序



- 归并的时候左右相等优先拷贝左边，**保证稳定性**

![image-20250104195035849](https://raw.githubusercontent.com/xiechen274/ChenCsNote/images/images/image-20250104195035849.png)

- 递归

**取中位数，然后不断分区间，排序区间，然后合并区间**

- 非递归

非递归不是直接通过中位数，而是通过步长，从1开始，**保证每个步长区间内的有序**，然后归并

**如果步长不够左右**，就单独成块，最后在归并

![image-20250104202726691](https://raw.githubusercontent.com/xiechen274/ChenCsNote/images/images/image-20250104202726691.png)

**步长的每次迭代<<= 1**,左移1，相当于×2

### 复杂度

- O(nlog(n))

### code

- 递归版

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

/**
 * @author xlj 2025-01-04
 * https://www.luogu.com.cn/problem/P1177
 * acm风格
 */
public class MergeSort {
    //递归写法
    public static int MAXN = 10001;

    public static int[] arr = new int[MAXN];

    public  static int[] help = new int[MAXN];

    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        //nval默认返回的是double
        n = (int) in.nval; //读取数组长度
        for(int i = 0; i < n; i++){
            in.nextToken();
            arr[i] = (int) in.nval;
        }
        mergeSortByRecursion(0, n - 1);
        //输出排序后的数组
        for(int i = 0; i < n - 1; i++){
            out.print(arr[i] + " ");
        }
        out.print(arr[n - 1]);
        //关闭流
        out.flush();
        out.close();
        br.close();
    }

    //由于定义静态变量所以不需要传入数组
    private static void mergeSortByRecursion(int l, int r) {
        if(l == r){
            return;
        }
        int mid = (l + r) / 2;
        //排序左右边
        mergeSortByRecursion(l, mid);
        mergeSortByRecursion(mid + 1, r);
        //归并
        merge(l, mid, r);

    }

    private static void merge(int l, int mid, int r) {
        int pointL = l;
        int pointR = mid + 1;
        int index = l; //help数组的下标

        //移动左右区间的指针开始归并
        while(pointL <= mid && pointR <= r){
            //如果相等的话就取左边的，保证稳定性
            help[index++] = arr[pointL] <= arr[pointR] ? arr[pointL++] : arr[pointR++];//谁小取谁
        }
        //将剩余的数放入help数组中
        while(pointL <= mid){
            help[index++] = arr[pointL++];
        }
        while(pointR <= r){
            help[index++] = arr[pointR++];
        }
        for(int i = l; i <= r; i++){
            arr[i] = help[i];
        }
    }

}

```

# 归并分治

![image-20250105215038704](https://raw.githubusercontent.com/xiechen274/ChenCsNote/images/images/image-20250105215038704.png)

## 问题 小和问题

![image-20250105220438591](https://raw.githubusercontent.com/xiechen274/ChenCsNote/images/images/image-20250105220438591.png)

`code`

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

/**
 * @author xlj 2025-01-05
 * 小和问题
 * 测试链接 : https://www.nowcoder.com/practice/edfe05a1d45c4ea89101d936cac32469
 */
public class SmallSum {
    public static int MAXN = 100000;

    public static int[] arr = new int[MAXN];

    public static int[] help = new int[MAXN];

    public static int n;

    public static void main(String[] args) throws IOException {
        //处理输入输出
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        n = (int) in.nval;
        for (int i = 0; i < n; i++) {
            in.nextToken();
            arr[i] = (int) in.nval;
        }
        out.println(smallSum(0, n - 1));

        out.flush();
        out.close();
    }
    //计算小和
    private static long smallSum(int l, int r) {
        if(l == r){
            return 0;
        }
        int m = (l + r) / 2;
        return smallSum(l, m) + smallSum(m + 1, r) + mergeAndSum(l, m, r);

    }

    //统计并且并且排序
    private static long mergeAndSum(int l, int m, int r) {
        int lPoint = l;
        int rPoint = m + 1;
        long tempSum = 0;
        long ans = 0;
        //滑动窗口统计
        for(int i = m + 1, j = l; i <= r; i++){
            //不超过左侧窗口指针，并且符合小和的统计条件
            while(j <= m && arr[j] <= arr[i]){
                tempSum += arr[j++];
            }
            ans += tempSum;
        }
        //归并
        int helpLPoint = l;
        while(lPoint <= m && rPoint <= r){
            help[helpLPoint++] = arr[lPoint] <= arr[rPoint] ? arr[lPoint++] : arr[rPoint++];
        }
        while(lPoint <= m){
            help[helpLPoint++] = arr[lPoint++];
        }
        while(rPoint <= r){
            help[helpLPoint++] = arr[rPoint++];
        }
        for(int i = l; i <= r; i++){
            arr[i] = help[i];
        }
        return ans;
    }

}

```

![image-20250105220721256](https://raw.githubusercontent.com/xiechen274/ChenCsNote/images/images/image-20250105220721256.png)

## 翻转对

![image-20250105222726849](https://raw.githubusercontent.com/xiechen274/ChenCsNote/images/images/image-20250105222726849.png)

