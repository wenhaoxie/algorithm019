//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 764 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<Integer,Integer> nodeMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        nodeMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            nodeMap.put(inorder[i],i);
        }
        return build( preorder,  inorder,0, inorder.length - 1, 0,inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder,int preLeft, int preRight, int inLeft,int inright) {
        if (preLeft > preRight) {
            return null;
        }
        int rootVal = preorder[preLeft];
        int inRootPos = nodeMap.get(rootVal);
        int leftSize = inRootPos - inLeft;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder,inorder,preLeft + 1, preLeft + leftSize,inLeft,inRootPos - 1);
        root.right = build(preorder, inorder,preLeft + leftSize + 1, preRight, inRootPos + 1, inright);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
