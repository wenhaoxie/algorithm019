学习笔记

dfs 模板：
```JAVA
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if(root==null){
            return allResults;
        }
        travel(root,0,allResults);
        return allResults;
    }


    private void travel(TreeNode root,int level,List<List<Integer>> results){
        if(results.size()==level){
            results.add(new ArrayList<>());
        }
        results.get(level).add(root.val);
        if(root.left!=null){
            travel(root.left,level+1,results);
        }
        if(root.right!=null){
            travel(root.right,level+1,results);
        }
    }
    
    public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
```



bfs 模板：
```JAVA
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> allResults = new ArrayList<>();
    if (root == null) {
        return allResults;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
        int size = nodes.size();
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode node = nodes.poll();
            results.add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        allResults.add(results);
    }
    return allResults;
}
```


深度搜索，光度搜索题目：
102 二叉树的层序遍历
433 最小基因变化
22. 括号生成
515. 在每个树行中找最大值
127. 单词接龙
126. 单词接龙 II
200. 岛屿数量
529. 扫雷游戏

贪心：
322. 零钱兑换
860. 柠檬水找零
122. 买卖股票的最佳时机 II
455. 分发饼干
874. 模拟行走机器人
55. 跳跃游戏
45. 跳跃游戏 II

二分查找代码模板：
```JAVA
public int binarySearch(int[] array, int target) {
    int left = 0, right = array.length - 1, mid;
    while (left <= right) {
        mid = (right - left) / 2 + left;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    return -1;
}
```
二分法 题目：
69. x 的平方根
367. 有效的完全平方数
33. 搜索旋转排序数组
74. 搜索二维矩阵
153. 寻找旋转排序数组中的最小值

