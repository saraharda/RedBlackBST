/**
 *BinarySearchTree class BinarySearchTree class for a basic binary search tree. It contains Comparable objects as data with
 *the invariant that all data in the left subtree of a node is less than the data at the node, and all data in the right subtree
 *is greater than or equal to the data at the node.
 * Author: Sara Harda
 */
public class BinarySearchTree <T extends Comparable<T>>{
	
	//root node of the tree
	protected BinarySearchTreeNode<T> root;
	
	/**
	 * Constructor 
	 */
	public BinarySearchTree(){
		//empty
	}
	
	/**
	 * Constructor (passes a BinarySearchTreeNode)
	 */
	public BinarySearchTree(BinarySearchTreeNode<T> node){
		this.root = node;
	}
	
	/**
	 * Gets root of the BST
	 */
	public BinarySearchTreeNode<T> getRoot(){
		return root;
	}
	
	/**
	 * Inserts node to BST
	 */
	public void insert(T data){
		root.insert(data);
	}
	
	/**
	 * Searches node from BST
	 */
	public BinarySearchTreeNode<T> search(T data){
		return root.search(data);	
	}
}
