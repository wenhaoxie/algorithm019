//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划 
// 👍 657 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size()== 0) return 0;
        int level = triangle.size();
        for (int i = level - 2; i >= 0; i--) {
            List<Integer> curLevel = triangle.get(i);
            List<Integer> preLevel = triangle.get(i + 1);
            for (int j = 0 ; j < curLevel.size(); j++) {
                curLevel.set(j, curLevel.get(j) + Math.min(preLevel.get(j), preLevel.get(j+1)));
            }
        }
        return  triangle.get(0).get(0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
