/**
 * RedBlackBSTNode is a subclass of RedBlackBST; it extends BSTNode and Comparable<T>
 * Created by peter on 3/10/17.
 * Modified by Sara Harda on 3/22/17.
 */
public class RedBlackBSTNode<T extends Comparable<T>> extends BinarySearchTreeNode<T> {
    
	//boolean instance variables
	boolean isBlack;
    boolean isNull;
    
    /**
     * Constructor without data
     */
    public RedBlackBSTNode() {
    	isNull = true;
        this.setBlack();
    }
    
    /**
     * Constructor with data
     */
    public RedBlackBSTNode(T d) {
        super(d);
        isNull = false;
    	this.setRed();
		this.setLeft(new RedBlackBSTNode<T>()); 
		this.setRight(new RedBlackBSTNode<T>());     	
    }
    
    /**
     * Checks if all the leaves are black
     */
    public boolean validateLeafNodesBlack() {
    	//if the node is null returns true
        if(this.isNull()) {
        	return true;
        }
        
    	//if left of the node is null returns false
        if (this.getLeft()==null) {
        	return false;
        }
        
    	//if right of the node is null returns false
        if (this.getRight()==null) {
        	return false;
        }
        
        //calls method recursively on left and right nodes
        return this.getLeft().validateLeafNodesBlack() && this.getRight().validateLeafNodesBlack();
    }
    
    /**
     * Checks if all red nodes have black children
     */
    public boolean validateRedHasBlackChildren() {
    	//if node is null returns true
    	if (this.isNull()) {
			return true;
    	}
    	
    	//if parent and left or parent and right are red, returns false
    	if (this.isRed() && this.getLeft().isRed() || this.isRed()
    			&& this.getRight().isRed()) {
    		return false;
    	}
    	
        //calls method recursively on left and right nodes
    	return this.getLeft().validateRedHasBlackChildren() && this.getRight().validateRedHasBlackChildren();
    }
    
    /**
     * Checks if all the simple paths from the node to leaves have the 
     * same numbers of black nodes
     */
    public int validateBlackHeight() {
    	//if the node is null return 0
    	if (this.isNull()) {
    		return 0;
    	}
    	
    	//counts left black height
    	int leftBH = this.getLeft().validateBlackHeight();
    	//counts right black height
    	int rightBH = this.getRight().validateBlackHeight();

    	//if node's left child is black
    	if (this.getLeft().isBlack()) {
    		//increments left black height by 1
    		leftBH++;
    	}
    	
    	//if node's right child is black
    	if (this.getRight().isBlack()) {
    		//increments right black height by 1
    		rightBH++;
    	}

    	//if left black height and right black height are equal
    	if (leftBH == rightBH) {
    		//returns the left black height
    		return leftBH;
    	}
    	
    	//if tree if not balanced
    	else {
    		//returns -1 
    		return -1;
    	}
    }

    public boolean isBlack() {
        return isBlack;
    }

    public void setBlack() {
        isBlack = true;
    }

    public boolean isRed() {
        return !isBlack;
    }

    public void setRed() {
        isBlack = false;
    }

    public boolean isNull() {
        return isBlack() && isNull;
    }

    public boolean isNotNull() {
        return !isNull;
    }

    public RedBlackBSTNode<T> getLeft() {
        return (RedBlackBSTNode<T>) super.getLeft();
    }

    public RedBlackBSTNode<T> getRight() {
        return (RedBlackBSTNode<T>) super.getRight();
    }

    public RedBlackBSTNode<T> getParent() {
        return (RedBlackBSTNode<T>) super.getParent();
    }

    public RedBlackBSTNode<T> getGrandParent() {
        return this.getParent().getParent();
    }

    public boolean isParentLeftChild() {
        return this.getParent() == this.getGrandParent().getLeft();
    }

    public RedBlackBSTNode<T> getUncle() {
        if( isParentLeftChild() ) {
            return this.getGrandParent().getRight();
        } else {
            return this.getGrandParent().getLeft();
        }
    }

    public boolean isLeftChild() {
        return (this == this.getParent().getLeft());
    }

    public boolean isRightChild() {
        return (this == this.getParent().getRight());
    }

    public String toString() {
        if(isNull()) {
            return "Node: isNull";
        } else {
            if( isRed() )
                return "Node: Red " + getData().toString();
            else
                return "Node: Black " + getData().toString();
        }
    }

    public int compareTo(RedBlackBSTNode<T> n) {
        return this.getData().compareTo(n.getData());
    }
}
