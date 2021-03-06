//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1961 👎 0


import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        for(int i = 0; i< s.length();i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.offerLast(map.get(c));
            } else {
                if(c != stack.peekLast()) {
                    return false;
                } else {
                    stack.pollLast();
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
