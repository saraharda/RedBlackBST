/**
 * RedBlackBST extends Comparable<T> as well as BinarySearchTree<T>
 * It contains rotation, insertion and validation methods
 * Created by peter on 3/10/17.
 * Modified by Sara Harda on 3/22/17.
 */
public class RedBlackBST<T extends Comparable<T>> extends BinarySearchTree<T> {
	
	/**
	 * Constructor without data
	 */
	public RedBlackBST() {	
		this.root = new RedBlackBSTNode<T>();
	}
	
	/**
	 * Constructor with data
	 */
	public RedBlackBST(RedBlackBSTNode<T> n) {
		root = n;
	}
	
	/**
	 * Performs left rotation 
	 * Makes the rotated node the new root of the subtree, with x as its
	 * left child and its left child as x's right child.
	 * @param x
	 */
	public void left_rotate(RedBlackBSTNode<T> x) {
		//if right child of x not null
		if (x.getRight().isNull() != true) {

			//rotated node is right of x
			RedBlackBSTNode<T> rotate = x.getRight();
			//sets new right child for x
			x.setRight(rotate.getLeft());

			//if left of rotated node is not null
			if (rotate.getLeft() != null)
				//sets parent of rotated node's left to be x
				rotate.getLeft().setParent(x);

			//if parent of x is not null
			if (x.getParent().isNull() != true) {
				//parents of rotated node are parents of x
				rotate.setParent(x.getParent());
				//if x is left child
				if (x == x.getParent().getLeft())
					//sets rotated node to be left of parent of x
					x.getParent().setLeft(rotate);
				//else if x is right child
				else if (x == x.getParent().getRight())
					//sets rotated node to be right of parent of x
					x.getParent().setRight(rotate);
			} 
			//if right child of x is null
			else {
				//sets rotated node to be root 
				root = rotate;
			}
			//sets x to be left child of rotated node
			rotate.setLeft(x);
			//sets rotated node to be parent of node
			x.setParent(rotate);
		}
	}
	
	/**
	 * Performs right rotation 
	 * Makes the rotated node the new root of the subtree, with x as its 
	 * right child and its right child as x's left child.
	 */
	public void right_rotate(RedBlackBSTNode<T> x) {
		//if left child of x not null
		if (x.getLeft().isNull() != true) {

			//rotated node is left of x
			RedBlackBSTNode<T> rotate = x.getLeft();
			//sets new left child for x
			x.setLeft(rotate.getRight());

			//if right of rotated node is not null
			if (rotate.getRight() != null) {
				//sets parent of rotated node's right to be x
				rotate.getRight().setParent(x);
			}

			//if parent of x is not null
			if (x.getParent().isNull() != true) {
				//parents of rotated node are parents of x
				rotate.setParent(x.getParent());
				//if x is left child
				if (x == x.getParent().getLeft())
					//sets rotated node to be left of parent of x
					x.getParent().setLeft(rotate);
				//else if x is right child
				else if (x == x.getParent().getRight())
					//sets rotated node to be right of parent of x
					x.getParent().setRight(rotate);
			}
			//if left child of x is null
			else {
				//sets rotated node to be root 
				root = rotate;
			}
			//sets x to be right child of rotated node
			rotate.setRight(x);
			//sets rotated node to be parent of node
			x.setParent(rotate);
		}
	}
	
	/**
	 * Inserts new data into the red black tree 
	 * Keeps binary tree and red black tree properties
	 */
	public void insert(T d ) {
		//initializes new node z with d data
		RedBlackBSTNode<T> z = new RedBlackBSTNode<T>(d);
		//initializes new null node y 
		RedBlackBSTNode<T> y = new RedBlackBSTNode<T>();
		//sets root of tree to be x
		RedBlackBSTNode<T> x = new RedBlackBSTNode<T>();
		x=(RedBlackBSTNode<T>) root;
		
		//if root is null, set inserted data in root
		if(x.isNull()) {
			z.setParent(root);
			z = x;
		}
		//while x is not a null node
		while (!x.isNull()) {
			//sets y node to be x node
			y = x;
			//if inserted data smaller or equal to data of x
			if (d.compareTo(x.getData())<=0) {
				//sets x to be left child of x
				x = x.getLeft();
				//if insert data greater than data of x
			} else {
				//sets x to be right child of x
				x = x.getRight();
			}
		}
		//sets parent of z node to be y
		z.setParent(y);
		
		//if y null node,
		if (y.isNull()) {
			//sets z to be root of tree
			root = z;
			
		//else if y is not null and data is smaller or equal than data of y
		} 
		else if (d.compareTo(y.getData())<=0) {
			//sets z to be left of y
			y.setLeft(z);			
		} 
		//else if data d is greater than data of y
		else if (d.compareTo(y.getData())>0) {
			//sets z to be right of y
			y.setRight(z);
		}
		//calls fixup on z node
		this.fixup(z);
	}
	
	/**
	 * Balances the red black tree such as when data is inserted,
	 * red black tree properties are maintained
	 */
	public void fixup(RedBlackBSTNode<T> z) {
		//while node is not root and node parent is red
		while (z != root && z.getParent().isRed()) {
			//gets sibling of node's parent
			RedBlackBSTNode<T> sibling = z.getUncle();
			
			//if node's parent is left child of grand parent
			if (z.isParentLeftChild()) {
				
				//if sibling of node's parent is red
				if (sibling.isRed()) {
					//sets node's parent to black
					z.getParent().setBlack();
					//sets sibling of node's parent to black
					sibling.setBlack();
					//sets node's grandparent to red
					z.getGrandParent().setRed();
					//updates node to grand parent
					z = z.getGrandParent();
				}

				//if sibling of node's parent is black
				else {
					//if node is right child
					if (z == z.getParent().getRight()) {
						//sets node to node's parent
						z = z.getParent();
						//left rotates
						left_rotate(z);
					}
					//else, if node is left child

					//sets color of node's parent to black
					z.getParent().setBlack();
					//sets node's grandparent to red
					z.getGrandParent().setRed();
					//right rotates on node's grandparent
					right_rotate(z.getGrandParent());
				}
			}

			//else, if node's parent is right child of grand parent
			else {
				//if sibling of node's parent is red
				if (sibling.isRed()) {
					//sets node's parent to black
					z.getParent().setBlack();
					//sets sibling of node's parent to black
					sibling.setBlack();
					//sets node's grandparent to red
					z.getGrandParent().setRed();
					//updates node to grand parent
					z = z.getGrandParent();
				}

				//else, if sibling of node's parent is black
				else {
					//if node is left child
					if (z == z.getParent().getLeft()) {
						//sets node to be node's parent
						z = z.getParent();
						//right rotates
						right_rotate(z);
					}
					//else, if node is left child

					//sets node's parent to black
					z.getParent().setBlack();
					//sets node's grandparent to red
					z.getGrandParent().setRed();
					//left rotates on node's grandparent
					left_rotate(z.getGrandParent());
				}
			}
		}
		//sets root's color to black
		((RedBlackBSTNode<T>) root).setBlack();
	}

    public RedBlackBSTNode<T> getRoot() {

        return (RedBlackBSTNode<T>) this.root;
    }

    public boolean validateLeafNodesBlack() {

        return getRoot().validateLeafNodesBlack();
    }

    public boolean validateRedHasBlackChildren() {

        return getRoot().validateRedHasBlackChildren();
    }

    public boolean validateBlackHeight() {

        return (getRoot().validateBlackHeight() >= 0);
    }

    public boolean validateRootNodeBlack() {

        return getRoot().isBlack();
    }

    public boolean validate() {
        return ( this.validateRedHasBlackChildren() &&
                this.validateBlackHeight() &&
                this.validateLeafNodesBlack() &&
                this.validateRootNodeBlack() );
    }
}
