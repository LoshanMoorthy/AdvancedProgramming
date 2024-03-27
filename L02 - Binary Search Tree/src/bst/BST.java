package bst;

import java.util.ArrayList;

public class BST<E> implements Tree<E> {
    protected TreeNode<E> root;
    protected int size = 0;
    protected java.util.Comparator<E> c;

    /**
     * Create a default BST with a natural order comparator
     */
    public BST() {
        this.c = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
    }

    /**
     * Create a BST with a specified comparator
     */
    public BST(java.util.Comparator<E> c) {
        this.c = c;
    }

    /**
     * Create a binary tree from an array of objects
     */
    public BST(E[] objects) {
        this.c = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }

    @Override
    /** Returns true if the element is in the tree */
    public boolean search(E e) {
        TreeNode<E> current = root; // Start from the root

        boolean found = false;
        while (current != null && !found) {
            if (c.compare(e, current.element) < 0) {
                current = current.left;
            } else if (c.compare(e, current.element) > 0) {
                current = current.right;
            } else // element matches current.element
                found = true; // Element is found
        }

        return found;
    }

    /** Find and return the TreeNode object for a given value */
    public TreeNode<E> searchNode(E e) {
        TreeNode<E> current = root;
        while (current != null) {
            if (c.compare(e, current.element) < 0)
                current = current.left;
            else if (c.compare(e, current.element) > 0)
                current = current.right;
            else
                return current;
        }
        return null;
    }


    @Override
    /** Insert element e into the binary tree
     * Return true if the element is inserted successfully */
    public boolean insert(E e) {
        boolean inserted = true;
        if (root == null)
            root = createNewNode(e); // Create a new root
        else {
            // Locate the parent node
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null && inserted)
                if (c.compare(e, current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (c.compare(e, current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    inserted = false; // Duplicate node not inserted

            // Create the new node and attach it to the parent node
            if (c.compare(e, parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }

        size++;
        return inserted; // Element inserted successfully
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    /**
     * In 'inorder', the print statement is between the recursive calls
     * for the left and right children
     * In 'preorder', the print statement is before the recursive call
     * In 'postorder', the print statement is after the recursive calls.
     */

    /* Left, Root, Right */
    @Override
    /** Inorder traversal from the root */
    public void inorder() {
        inorder(root);
    }

    private void inorder(TreeNode<E> node) {
        if (node == null) return;
        inorder(node.left);
        System.out.println(node.element + " ");
        inorder(node.right);
    }


    /* Root, Left, Right */
    @Override
    /** Postorder traversal from the root */
    public void postorder() {
        postorder(root);
    }

    private void postorder(TreeNode<E> node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.element + " ");
    }


    /* Left, Right, Root */
    @Override
    /** Preorder traversal from the root */
    public void preorder() {
        preorder(root);
    }

    private void preorder(TreeNode<E> node) {
        if (node == null) return;
        System.out.println(node.element + " ");
        preorder(node.left);
        preorder(node.right);
    }


    /**
     * This inner class is static, because it does not access
     * any instance members defined in its outer class
     */
    public static class TreeNode<E> {
        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        }
    }

    @Override
    /** Get the number of nodes in the tree */
    public int getSize() {
        return size;
    }

    /**
     * Returns the root of the tree
     */
    public TreeNode<E> getRoot() {
        return root;
    }


    @Override
    /** Delete an element from the binary tree.
     * Return true if the element is deleted successfully
     * Return false if the element is not in the tree */
    public boolean delete(E e) {
        // Locate the node to be deleted and also locate its parent node
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        boolean found = false;
        while (current != null && !found) {
            if (c.compare(e, current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (c.compare(e, current.element) > 0) {
                parent = current;
                current = current.right;
            } else
                found = true; // Element is in the tree pointed at by current
        }

        if (found) {
            // Case 1: current has no left child
            if (current.left == null) {
                // Connect the parent with the right child of the current node
                if (parent == null) {
                    root = current.right;
                } else {
                    if (c.compare(e, parent.element) < 0)
                        parent.left = current.right;
                    else
                        parent.right = current.right;
                }
            } else {
                // Case 2: The current node has a left child
                // Locate the rightmost node in the left subtree of
                // the current node and also its parent
                TreeNode<E> parentOfRightMost = current;
                TreeNode<E> rightMost = current.left;

                while (rightMost.right != null) {
                    parentOfRightMost = rightMost;
                    rightMost = rightMost.right; // Keep going to the right
                }

                // Replace the element in current by the element in rightMost
                current.element = rightMost.element;

                // Eliminate rightmost node
                if (parentOfRightMost.right == rightMost)
                    parentOfRightMost.right = rightMost.left;
                else
                    // Special case: parentOfRightMost == current
                    parentOfRightMost.left = rightMost.left;
            }
            size--; // Reduce the size of the tree
        }
        return found; // Element deleted successfully
    }

    public boolean isLeaf(TreeNode<E> node) {
        return (node.left == null) && (node.right == null);
    }

    public boolean isInternal(TreeNode<E> node) {
        return !isLeaf(node);
    }

    public int height() {
        return height(root);
    }

    private int height(TreeNode<E> node) {
        if (node == null)
            return -1;
        else
            return 1 + Math.max(height(node.left), height(node.right));
    }

    private E findMin() {
        return findMin(root);
    }

    private E findMin(TreeNode<E> node) {
        if (node.left == null)
            return node.element;
        return findMin(node.left);
    }

    public E findMax() {
        return findMax(root);
    }

    private E findMax(TreeNode<E> node) {
        TreeNode<E> current = node;
        while (current.right != null)
            current = current.right;
        return current.element;
    }

    public int sum() {
        return sum(root);
    }

    private int sum(TreeNode<E> node) {
        if (node == null) {
            return 0;
        } else {
            int leftSum = sum(node.left);
            int rightSum = sum(node.right);

            return leftSum + rightSum + (Integer)node.element;
        }
    }

    public E removeMin() {
        // Tjek om træet er tomt
        if (root == null) return null;

        // Nuværende node og forældre
        TreeNode<E> parent = null;
        TreeNode<E> current = root;

        // Find det mindste element (yderst venstre element)
        while (current.left != null) {
            parent = current; // Nuværende node
            current = current.left; // Mindste node
        }

        // Hvis det mindste element er roden selv
        // opdater træets rod til at være det mindste element af højre barn.
        if (parent == null)
            root = current.right;
        else
            // Hvis mindste element har parent så fjern referencen
            parent.left = current.right;

        // Reducer størrelsen af træet
        size--;
        return current.element;
    }

    public E removeMax() {
        // Tjek om træet er tomt
        if (root == null) return null;

        // Nuværende node og dens parent
        TreeNode<E> parent = null;
        TreeNode<E> current = root;

        // Find det største element (yderst højre element)
        while (current.right != null) {
            parent = current; // Nuværende node eller currents parent
            current = current.right; // Største node
        }

        // Hvis største element er roden selv
        // Opdater træets rod til at være det største element af venstre barn
        if (parent == null)
            root = current.left;
        else
            // Hvis største element har parent så fjern referencen
            parent.right = current.left;

        // Reducer størrelsen af træet
        size--;
        return current.element;
    }

    public ArrayList<E> greatherThan(E element) {
        ArrayList<E> result = new ArrayList<>();
        greatherThanHelper(root, element, result);
        return result;
    }

    private void greatherThanHelper(TreeNode<E> node, E element, ArrayList<E> result) {
        if (node == null) return;

        // Traversing left subtree, if current element is greather than given element
        if (c.compare(node.element, element) > 0)
            greatherThanHelper(node.left, element, result);

        // Add current element if bigger than given element
        if (c.compare(node.element, element) > 0)
            result.add(node.element);

        // Traverse right subtree because all elements here will be bigger
        greatherThanHelper(node.right, element, result);
    }

    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.insert(45);
        tree.insert(22);
        tree.insert(11);
        tree.insert(30);
        tree.insert(77);
        tree.insert(90);
        tree.insert(15);
        tree.insert(25);
        tree.insert(88);

        System.out.print("Inorder traversal: ");
        tree.inorder();
        System.out.println();

        System.out.print("Preorder traversal: ");
        tree.preorder();
        System.out.println();

        System.out.print("Postorder traversal: ");
        tree.postorder();
        System.out.println();


        System.out.println("Is the node with element 15 a leaf? " + tree.isLeaf(tree.searchNode(15)));
        System.out.println("Is the node with element 22 internal? " + tree.isInternal(tree.searchNode(22)));

        System.out.println("The height of the tree is: " + tree.height());

        System.out.println("Min value of tree: " + tree.findMin());
        System.out.println("Max value of tree: " + tree.findMax());

        System.out.println("Sum of tree: " + tree.sum());

        tree.removeMin();
        System.out.println("After removal of min: ");
        tree.inorder();

        System.out.println();

        tree.removeMax();
        System.out.println("After removal of max:");
        tree.inorder();

        System.out.println();

        System.out.println(tree.greatherThan(15));
    }
}