//编写一个程序，找出第 n 个丑数。 
//
// 丑数就是质因数只包含 2, 3, 5 的正整数。 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
// Related Topics 堆 数学 动态规划 
// 👍 424 👎 0


import java.util.HashSet;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>((a,b) -> {if (a>b) {
            return 1;
        }else if (a < b) {
            return -1;
        } else {
            return 0;
        }
        });
        pq.add(1L);
        seen.add(1L);
        Long cur = 0L;
        while (n > 0) {
            n--;
            cur = pq.poll();
            Long cur2 = cur*2;
            Long cur3 = cur*3;
            Long cur5 = cur*5;
            if (!seen.contains(cur2)) {
                pq.add(cur2);
                seen.add(cur2);
            }
            if (!seen.contains(cur3)) {
                pq.add(cur3);
                seen.add(cur3);
            }
            if (!seen.contains(cur5)) {
                pq.add(cur5);
                seen.add(cur5);
            }
        }
        return  cur.intValue();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
