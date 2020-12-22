//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1487 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        backTracking(res, n, 0,0, new StringBuilder());
        return res;
    }
    private void backTracking(List<String> res, int n, int left, int right, StringBuilder sb) {
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }
        if(left < n) {
            sb.append('(');
            backTracking(res, n, left + 1, right, sb);
            sb.setLength(sb.length() - 1);
        }
        if (left > right ) {
            sb.append(')');
            backTracking(res, n, left , right + 1, sb);
            sb.setLength(sb.length() - 1);
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)
