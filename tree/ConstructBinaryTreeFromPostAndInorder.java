packge tree;

/**
 * LeetCode106. Construct Binary Tree from Inorder and Postorder Traversal
 * (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/)
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note: You may assume that duplicates do not exist in the tree.
 *
 * Solution: The approach is quite simliar to LeetCode 105(Construct Binary Tree from Preorder and Inorder Traversal).
 * For postorder traversal, we visit left subtree first, and then righ subtree, and the the root node. So the last
 * element in postorder traversal is the root node. The postorder traversal is in such pattern: [left, left..., right,
 * right...root]. Find the index of the root node in inorder, the left side of this element is the left subtree, and the
 * right side of this element is the right subtree. Do it in a recursive way.
 */

public class ConstructBinaryTreeFromPostAndInorder {

    static Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        //start from the end of the postorder traversal
        return helper(postorder.length-1, 0, inorder.length-1, inorder, postorder);

    }

    public TreeNode helper(int postorderIndex, int inorderStart, int inorderEnd, int[] inorder, int[] postorder) {
        if (postorderIndex < 0 || inorderStart > inorderEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorderIndex]);
        //find the index of the root node in inorder
        int inorderIndex = map.get(postorder[postorderIndex]);
        //the size of the right subtree is inorderEnd - inorderIndex, so the next left subtree root node index is
        //postorderIndex-(inorderEnd-inorderIndex)-1
        root.left = helper(postorderIndex-inorderEnd+inorderIndex-1, inorderStart, inorderIndex-1, inorder, postorder);
        //next right subtree root node index is postorderIndex-1
        root.right = helper(postorderIndex-1, inorderIndex+1, inorderEnd, inorder, postorder);
        return root;
    }
}