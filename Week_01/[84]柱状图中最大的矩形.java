//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 996 👎 0


import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //array list
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] leftFirstLess = new int[heights.length];
        int[] rightFirstLess = new int[heights.length];
        leftFirstLess[0] = -1;
        rightFirstLess[heights.length - 1] = heights.length;
        for (int i = 1; i< heights.length; i++) {
            int p = i-1;
            while (p >= 0 && heights[p] >= heights[i] ) {
                p  = leftFirstLess[p];
            }
            leftFirstLess[i] = p;
        }
        for ( int i = heights.length - 2; i >= 0 ; i--) {
            int p = i + 1;
            while (p < heights.length && heights[p] >= heights[i]) {
                p = rightFirstLess[p];
            }
            rightFirstLess[i] = p;
        }
        for(int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (rightFirstLess[i] - leftFirstLess[i] - 1));
        }

        return  maxArea;
    }
    //stack
//    public int largestRectangleArea(int[] heights) {
//        if (heights == null || heights.length == 0) {
//            return 0;
//        }
//        int maxArea = 0, height = 0, width = 0, curHeight = 0;
//        Deque<Integer> stack = new LinkedList<>();
//        for ( int i = 0; i<= heights.length; i++) {
//            if (i == heights.length) {
//                curHeight = -1;
//            } else {
//                curHeight = heights[i];
//            }
//            while (!stack.isEmpty() && heights[stack.peekLast()] > curHeight) {
//                height = heights[stack.pollLast()];
//                width = stack.isEmpty() ? i : i - stack.peekLast() - 1;
//                maxArea = Math.max(maxArea,height * width);
//            }
//            stack.offerLast(i);
//        }
//        return  maxArea;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
