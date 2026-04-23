import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树后序遍历
 *
 * @author cheng.wang
 * @version Date：2026/4/23
 */
public class TreeOrderTest {

    public List<Integer> treeOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        order(root, result);
        return result;
    }

    private void order(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        // 左子树
        order(root.left, result);
        // 右子树
        order(root.right, result);
        // 根
        result.add(root.val);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

}

