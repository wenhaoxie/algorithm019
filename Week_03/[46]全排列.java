//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1007 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur= Arrays.stream(nums).boxed().collect(Collectors.toList());
        dfs(res, cur, 0);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> nums, int start) {
        if (start == nums.size()) {
            res.add(new ArrayList<>(nums));
        }
        for (int i = start; i < nums.size(); i++) {
            swap(nums, i, start);
            dfs(res, nums, start + 1);
            swap(nums, i, start);
        }
    }
    private void swap(List<Integer> nums, int id1, int id2) {
        Integer temp = nums.get(id1);
        nums.set(id1, nums.get(id2));
        nums.set(id2, temp);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
