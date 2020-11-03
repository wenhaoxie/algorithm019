//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 
// 👍 1791 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int trap(int[] height) {
//        if(height == null || height.length <= 1) {
//            return 0;
//        }
//        int left = 0;
//        int right = height.length - 1;
//        int leftMax = 0,rightMax = 0, res = 0;
//        while (left <= right) {
//            leftMax = Math.max(height[left],leftMax);
//            rightMax = Math.max(height[right], rightMax);
//            if(leftMax > rightMax) {
//                res += rightMax - height[right--];
//            } else {
//                res += leftMax - height[left++];
//            }
//        }
//        return  res;
//    }
//    public int trap(int[] height) {
//        if(height == null || height.length <= 1) {
//            return 0;
//        }
//        int leftMax = height[0];
//        int rightMax = height[height.length -1], res = 0;
//        Deque<Integer> stack = new LinkedList<>();
//        for ( int i = 0; i < height.length; i++) {
//            if (leftMax > height[i]) {
//                stack.offerLast(height[i]);
//            } else {
//                while(stack.size() > 0) {
//                    res += leftMax - stack.pollLast();
//                }
//                leftMax = height[i];
//            }
//        }
//        while(stack.size() > 0) {
//            int temp = stack.pollLast();
//            if (rightMax > temp) {
//                res += rightMax - temp;
//            } else if (temp > rightMax) {
//                rightMax = temp;
//            }
//        }
//        return  res;
//    }
//    public int trap(int[] height) {
//        if(height == null || height.length <= 1) {
//            return 0;
//        }
//        int left = 0;
//        int right = height.length - 1;
//        int minHight = Math.min(height[left], height[right]);
//        int res = 0;
//        while (left < right) {
//            while (left < right && height[left] <= minHight) {
//                res += minHight - height[left++];
//            }
//            while (left < right && height[right] <= minHight) {
//                res += minHight - height[right--];
//            }
//            minHight = Math.min(height[left],height[right]);
//        }
//        return  res;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
