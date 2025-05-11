package hot100.heap;

import sun.java2d.pipe.SpanClipRenderer;

/**
 * @author xlj
 * @date 2025-05-11
 * @description https://leetcode.cn/problems/sort-an-array/ 测试链接
 */

public class HeapSort {

    public static int[] arr = new int[]{2,1,4,6,1};

    public static int n;

    //堆排序
    public void sortArr(int[] nums) {
        int n = nums.length;
        int size = n;

        //构建大根堆
        for(int i = 0; i < n; i++){
            heapInsert(i,size);
        }
        while(size > 0){
            //将堆顶的元素放置到最后
            swap(0,size - 1);
            size--;
            heapify(0,size);

        }

    }

    /**
     * 向上调整大根堆
     *
     * @param i    插入的位置
     * @param size 此时堆的大小
     * @return
     */
    public void heapInsert(int i, int size) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            //调整i的大小
            i = (i - 1) / 2;
        }
    }

    /**
     * 向下调整大根堆
     *
     * @param i    插入的位置
     * @param size 此时堆的大小
     * @return
     */
    public void heapify(int i, int size) {
        //向下调整的过程要确定一下是否有越界
        int l = i * 2 + 1; //左孩子

        //判断越界，这里采用一个优雅的写法,只用判断l < size
        while(l < size){
            //找到最大的下标
            // 评选，最强的孩子，是哪个下标的孩子
            int best = l + 1 < size && arr[l + 1] > arr[l] ? l + 1 : l;
            // 上面已经评选了最强的孩子，接下来，当前的数和最强的孩子之前，最强下标是谁
            best = arr[best] > arr[i] ? best : i;
            if(best == i){
                break;
            }
            swap(i,best);
            i = best; //
            l = i * 2 + 1;
        }
    }

    //通过坐标交换两个元素
    private static void swap(int i, int parIndex) {
        int temp = arr[i];
        arr[i] = arr[parIndex];
        arr[parIndex] = temp;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        heapSort.sortArr(arr);
        System.out.println("==============");
    }
}
