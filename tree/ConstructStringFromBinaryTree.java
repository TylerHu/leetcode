package tree;

/**
 * LeetCode606. Construct String from Binary Tree(https://leetcode.com/problems/construct-string-from-binary-tree/description/)
 *
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
 * The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs.
 * that don't affect the one-to-one mapping relationship between the string and the original binary tree.
 *
 * Solution: Use preorder traversal, and check whether the left node is null or the the right is null. If both left and right nodes
 * are null, return current val, if left node is null, but the right node is not null, append "()(right node val)" to the
 * current val, if right node is null, but the left node is not null, append "(left node val)" to tthe current val
 */
public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        String result = t.val + "";
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        if (left.equals("") && right.equals("")) {
            return result;
        }
        if (left.equals("")) {
            //append "()(right node val)"
            return result +"()" + "(" + right + ")";
        }
        if (right.equals("")) {
            //append "(left node val)"
            return result + "(" + left + ")";
        }
        //append "(left node val)(right node val)"
        return result + "(" + left + ")" + "(" + right + ")";
    }
}