import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 *
 * @author cheng.wang
 * @version Date：2026/4/23
 */
public class TreeOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        return result;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
