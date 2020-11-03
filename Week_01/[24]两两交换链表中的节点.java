//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
// Related Topics 链表 
// 👍 728 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
//    recursion
//    public ListNode swapPairs(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode first = head;
//        ListNode second = head.next;
//        first.next = swapPairs(second.next);
//        second.next  = first;
//        return second;
//    }
//    itertation
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (head != null && head.next != null) {
            ListNode next = head.next.next;
            cur.next = head.next;
            head.next.next = head;
            head.next = next;
            cur = head;
            head = head.next;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
