//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 示例: 
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 说明: 
//
// 假设你总是可以到达数组的最后一个位置。 
// Related Topics 贪心算法 数组 
// 👍 758 👎 0




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int start = 0, end = 1, count = 0;
        while (end < nums.length) {
            int maxPos = 0;
            for (int i = start; i < end; i ++) {
                maxPos = Math.max(nums[i] + i, maxPos);
            }
            start = end;
            end = maxPos + 1;
            count++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
