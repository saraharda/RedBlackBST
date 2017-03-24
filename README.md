# RedBlackBST

Implementation of a Red Black binary search tree in Java


-BinarySearchTree.java : BinarySearchTree class for a basic binary search tree. It contains Comparable objects as data with
the invariant that all data in the left subtree of a node is less than the data at the node, and all data in the right subtree
is greater than or equal to the data at the node.

-BinarySearchTreeNode.java : Creates a basic binary tree node with data of type T and pointers to left and right children.

-RedBlackBST.java: RedBlackBST extends Comparable<T> as well as BinarySearchTree<T>. It contains rotation and insertion and calls node 
validation methods on the root of the tree

-RedBlackBSTNode.java: RedBlackBSTNode is a subclass of RedBlackBST; it extends BSTNode and Comparable<T>. It has methods that perform the validation

-RedBlackBSTNodeTest.java: JUnit test for the RedBlackBSTNode class

-RedBlackBSTTest.java: JUnit test for the RedBlackBST class
