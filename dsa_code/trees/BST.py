class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None


class BST:
    def __init__(self, root) -> None:
        self.root = TreeNode()

    def search(self, root, target):
        if not root:
            return False

        if target < root.left.val:
            return self.search(root.left, target)
        elif target > root.right.val:
            return self.search(root.right, target)
        else:
            return True

    # Tree insert and remove
    # Insert a new node and return the root of the BST.

    def insert(self, root, val):
        if not root:
            return TreeNode(val)

        if val > root.val:
            root.right = self.insert(root.right, val)
        elif val < root.val:
            root.left = self.insert(root.left, val)
        return root

    # Return the minimum value node of the BST.
    def minValueNode(self, root):
        curr = root
        while curr and curr.left:
            curr = curr.left
        return curr

    # Remove a node and return the root of the BST.
    def remove(self, root, val):
        if not root:
            return None

        if val > root.val:
            root.right = self.remove(root.right, val)
        elif val < root.val:
            root.left = self.remove(root.left, val)
        else:
            if not root.left:
                return root.right
            elif not root.right:
                return root.left
            else:
                minNode = self.minValueNode(root.right)
                root.val = minNode.val
                root.right = self.remove(root.right, minNode.val)
        return root
