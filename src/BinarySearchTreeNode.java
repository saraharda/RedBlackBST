/**
 * BinarySearchTreeNode creates a basic binary tree node with data of type T and pointers to left and right children.
 * Author: Sara Harda
 */

public class BinarySearchTreeNode <T extends Comparable<T>> {

	//instance of comparable data
	protected T data;
	
	//instance of left node
	protected BinarySearchTreeNode<T> left;
	
	//instance of right node
	protected BinarySearchTreeNode<T> right;
	
	//instance of parent node
	protected BinarySearchTreeNode<T> parent;

	/**
	 * Constructor
	 */
	public BinarySearchTreeNode(){
		//empty
	}

	/**
	 * Constructor with data as argument
	 */
	public BinarySearchTreeNode(T data){
		this.data=data;
	}

	/**
	 * Gets data from node
	 */
	public T getData(){
		return data;
	}

	/**
	 * Sets data
	 */
	public void setData(T comparableData){
		this.data = comparableData;
	}

	/**
	 * Gets left node
	 */
	public BinarySearchTreeNode<T> getLeft(){
		if(left!=null){
			return left;
		}
		else{
			return null; 
		}
	}

	/**
	 * Sets left node
	 */
	public void setLeft(BinarySearchTreeNode<T> leftNode){
		this.left = leftNode;
	}

	/**
	 * Gets right node
	 */
	public BinarySearchTreeNode<T> getRight(){
		if(right != null){
			return right;
		}
		else{
			return null;
		}
	}

	/**
	 * Sets right node
	 */
	public void setRight(BinarySearchTreeNode<T> rightNode){
		this.right = rightNode;
	}

	/**
	 * Gets parent node
	 */
	public BinarySearchTreeNode<T> getParent(){
		if(parent != null){
			return parent;
		}
		else{
			return null;
		}
	}

	/**
	 * Sets a parent node
	 */
	public void setParent(BinarySearchTreeNode<T> parentNode){
		this.parent = parentNode;
	}

	/**
	 * Inserts data recursively
	 */
	public void insert(T data){
		//if passed in data is equal to data
		if(this.data.compareTo(data) == 0){
			return;
		}
		//if passed in data is smaller than data
		if(data.compareTo((T) this.getData()) < 0){
			//if left is null
			if(this.getLeft()==null){
				BinarySearchTreeNode<T> left1 = new BinarySearchTreeNode<T>();
				left1.setData(data);
				left1.setParent(this);
				this.setLeft(left1);
			}
			//call method recursively
			else{
				left.insert(data);
			}

		}
		//if passed in data is larger than data
		if(data.compareTo((T) this.getData()) > 0){
			//if the right is null
			if(this.getRight() == null){
				BinarySearchTreeNode<T> right1 = new BinarySearchTreeNode<T>();
				right1.setData(data);
				right1.setParent(this);
				this.setRight(right1);
			}
			else{
				//call method recursively
				right.insert(data);
			}
		}
	}

	/**
	 * Searches node recursively
	 */
	public BinarySearchTreeNode<T> search( T dataD) {
		//if passed in data is equal to data
		if(dataD.compareTo( (T) this.getData()) == 0){
			//return data
			return this;
		}
		//if passed in data is smaller than data
		else if(dataD.compareTo((T) this.getData()) < 0){
			if(this.getLeft() == null){
				return null;
			}
			else if(this.getLeft() != null){
				if(this.getLeft().getData() == dataD){
					return this.getLeft();
				}
				else{
					//call method recursively
					return this.getLeft().search(dataD);
				}
			}
		}
		//if passed in data is larger than data
		else if(dataD.compareTo((T) this.getData()) > 0){
			if(this.getRight() == null){
				return null;
			}
			else if(this.getRight() != null){
				if(this.getRight().getData() == dataD){
					return this.getRight();
				}
				else{
					//call method recursively
					return this.getRight().search(dataD);
				}
			}
		}
		return null;
	}
}	
