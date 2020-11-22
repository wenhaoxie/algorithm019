//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 442 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < k) return res;
        dfs(res, n, 1, k, new ArrayList<Integer>());
        return res;
    }
    private void dfs(List<List<Integer>> res, int n, int start, int k,List<Integer> cur) {
        int size = cur.size();
        if (size == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i <= n - k + 1 + size; i++) {
            cur.add(i);
            dfs(res, n, i + 1, k, cur);
            cur.remove(size);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
