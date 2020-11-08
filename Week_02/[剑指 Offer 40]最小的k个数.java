//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 157 👎 0


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    privority queue
//    public int[] getLeastNumbers(int[] arr, int k) {
//        if (k <= 0 || arr == null) {
//            return new int[0];
//        }
//        if ( arr.length <= k) {
//            return arr;
//        }
//        int[] res = new int[k];
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if (o1 > o2) {
//                    return -1;
//                } else if (o1 == o2) {
//                    return 0;
//                } else {
//                    return 1;
//                }
//            }
//        });
//        for (int i = 0; i < k; i++) {
//            priorityQueue.add(arr[i]);
//        }
//        for (int i = k; i < arr.length; i++) {
//            if(priorityQueue.peek() >arr[i]) {
//                priorityQueue.poll();
//                priorityQueue.add(arr[i]);
//            }
//        }
//        for (int i = 0; i < k; i++) {
//            res[i] = priorityQueue.poll();
//        }
//        return res;
//
//    }
//    quick sort
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k <= 0 || arr == null) {
            return new int[0];
        }
        if ( arr.length <= k) {
            return arr;
        }
        int[] res = new int[k];
        quickPartition(arr, 0, arr.length - 1, k);
        for (int i = 0; i< k; i++ ) {
            res[i] = arr[i];
        }
        return res;
    }
    private void quickPartition(int[] arr, int l, int r,int k) {
        if (l >= r) {
            return;
        }
        int p = (int)Math.random()*(r - l + 1) + l;
        swap(arr, r, p);
        int slow = l;
        for (int i = l; i < r; i++) {
            if (arr[i] < arr[r]) {
                swap(arr,slow++, i);
            }
        }
        swap(arr,slow, r);
        if (slow - l + 1 == k) {
            return;
        } else if (slow - l + 1 > k ) {
            quickPartition(arr, l, slow, k);
        } else {
            quickPartition(arr, slow + 1, r, k - (slow - l + 1));
        }
    }
    private  void swap(int[] arr, int id1, int id2) {
        int temp = arr[id1];
        arr[id1] = arr[id2];
        arr[id2] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
