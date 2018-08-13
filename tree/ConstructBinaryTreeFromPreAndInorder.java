package tree;

/**
 * LeetCode105. Construct Binary Tree from Preorder and Inorder Traversal
 * (https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/)
 *
 *  Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note: You may assume that duplicates do not exist in the tree.
 *
 * Solution: Note that the first element in preorder is always the root of the tree. For inorder traverse, we visit the
 * left subtree first, then root node, then right subtree, so find the index of every preorder element in the inorder
 * traverse, the left side of index is the left substree of the preorder element, and the right side of the index is the
 * right subtree. We could do it in a recursive way. To reduce time complexity of element searching, we could use a hash
 * map to store the index of all the elements, the get operation of hashmap is 0(1).
 *
 */
public class ConstructBinaryTreeFromPreAndInorder {
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        return helper(0, 0, inorder.length-1, preorder, inorder);
    }

    public TreeNode helper(int preorderStart, int inorderStart, int inorderEnd, int[] preorder, int[] inorder) {
        if (preorderStart > preorder.length - 1 || inorderStart > inorderEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderStart]);
        //get the index of preorder element in the inorder traverse
        int inorderIndex = map.get(preorder[preorderStart]);
        //preorderStart+1 is the first left subtree element in preorder, (inorderStart, inorderIndex-1) is inorder of
        // left subtree
        root.left = helper(preorderStart+1, inorderStart, inorderIndex-1, preorder, inorder);
        //(inorderIndex-inorderStart) is the size of left subtree, so preorderStart+inorderIndex-inorderStart+1 is the
        // first right subtree element in preorder. (inorderIndex+1, inorderEnd) is inorder of right subtree
        root.right = helper(preorderStart+inorderIndex-inorderStart+1, inorderIndex+1, inorderEnd, preorder, inorder);
        return root;
    }
}