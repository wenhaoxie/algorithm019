//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 877 👎 0




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTracking(res, new ArrayList<Integer>(),nums,0);
        return res;
    }
    private void backTracking( List<List<Integer>> res, List<Integer> cur, int[] nums, int start) {
        if (start >= nums.length) {
            res.add(new ArrayList(cur));
            return;
        }
        backTracking(res,cur,nums,start + 1);
        cur.add(nums[start]);
        backTracking(res, cur,nums,start+1);
        cur.remove(cur.size() - 1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
