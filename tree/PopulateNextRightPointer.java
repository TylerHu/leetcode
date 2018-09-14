package tree;

/**
 * LeetCode 116. Populating Next Right Pointers in Each Node(https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/)
 *
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 *
 * Solution: Start from the most left node on each level of the tree. Set the next pointer of current node's left child to current node's right child.
 * ANd set the next pointer of current node's right child to the left child of current node's next element.
 */
public class PopulateNextRightPointer {
    public void connect(TreeLinkNode root) {
        TreeLinkNode levelStart = root;
        while (levelStart != null) {
            TreeLinkNode current = levelStart;
            while(current != null) {
                if (current.left != null) {
                    //    node
                    //   /   \
                    // left->right
                    current.left.next = current.right;
                }
                if (current.next != null && current.right != null) {
                    // node ->  next
                    //  \        /
                    //  right->left
                    current.right.next = current.next.left;
                }
                //next node
                current = current.next;

            }
            //the most left node of next level
            levelStart = levelStart.left;
        }

    }
}