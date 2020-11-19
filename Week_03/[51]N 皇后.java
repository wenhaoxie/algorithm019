//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例： 
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// Related Topics 回溯算法 
// 👍 668 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diags1 = new HashSet<>();
        Set<Integer> diags2 = new HashSet<>();
        backTracking(res, new int[n], 0,n,cols,diags1,diags2);
        return res;
    }
    private void backTracking(List<List<String>> res,int[] cur, int row,int n,Set<Integer> cols,Set<Integer> diags1,Set<Integer> diags2) {
        if (row == n) {
            res.add(generateBoard(cur));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (cols.contains(i)) {
                continue;
            }
            if (diags1.contains(row - i)) {
                continue;
            }
            if (diags2.contains(row + i)) {
                continue;
            }
            cur[row] = i;
            cols.add(i);
            diags1.add(row - i);
            diags2.add(row + i);
            backTracking(res, cur, row + 1, n, cols, diags1, diags2);
            diags1.remove(row - i);
            diags2.remove(row + i);
            cols.remove(i);
        }
    }
    private List<String> generateBoard(int[] cur) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < cur.length; i++) {
            char[] chars = new char[cur.length];
            Arrays.fill(chars, '.');
            chars[cur[i]] = 'Q';
            res.add(String.valueOf(chars));
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
