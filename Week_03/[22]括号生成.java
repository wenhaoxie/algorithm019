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
// 👍 1418 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 0 ) {
            return new ArrayList();
        }
        List<String> res = new ArrayList<>();
        backTracking(res, new StringBuilder(),n, 0,0);
        return res;
    }
    private void backTracking(List<String> res, StringBuilder sb, int max, int left, int right) {
        if (sb.length() == max * 2) {
            res.add(sb.toString());
            return;
        }
        if (left < max) {
            sb.append('(');
            backTracking(res,sb,max,left + 1, right);
            sb.setLength(sb.length() - 1);
        }
        if (right < left) {
            sb.append(')');
            backTracking(res, sb,max,left,right+1);
            sb.setLength((sb.length() - 1));
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
