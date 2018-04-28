import java.util.NoSuchElementException;

public class SearchIntTree {
	
	private IntTreeNode root;
	
	public void print() {
		print(root);
	}
	
	private void print(IntTreeNode node) {
		if(node != null) {
			print(node.left);
			System.out.print(node.data + " ");
			print(node.right);
		}
	}
	
	public void printSideways() {
		printSideways(root, "");
	}
	
	public boolean contains(int value) {
		return contains(root, value);
	}
	
	private boolean contains(IntTreeNode node, int value) {
		if(node == null) {
			return false;
		} else if(node.data == value) {
			return true;
		} else if(value < node.data) {
			return contains(node.left, value);
		} else {
			return contains(node.right, value);
		}
	}
	
	public void add(int value) {
		this.root = add(root, value);
	}
	
	private IntTreeNode add(IntTreeNode node, int value) {
		if(node == null) {
			node = new IntTreeNode(value);
		} else if(value < node.data) {
			node.left = add(node.left, value);
		} else if(value > node.data) {
			node.right = add(node.right, value);
		}
		return node;
	}
	
	public int getMin() {
		if(root == null) {
			throw new NoSuchElementException();
		}
		return getMin(root);
	}
	
	private int getMin(IntTreeNode node) {
		if(node.left == null) {
			return node.data;
		} else {
			return getMin(node.left);
		}
	}
	
	// Removes the given value from this BST, if it exists.
	public void remove(int value) {
	    this.root = remove(root, value);
	}

	private IntTreeNode remove(IntTreeNode root, int value) {
	    if (root == null) {
	        return null;
	    } else if (root.data > value) {
	        root.left = remove(root.left, value);
	    } else if (root.data < value) {
	        root.right = remove(root.right, value);
	    } else {  // root.data == value; remove this node
	        if (root.right == null) {
	            return root.left;    // no R child; replace w/ L
	        } else if (root.left == null) {
	            return root.right;   // no L child; replace w/ R
	        } else {
	            // both children; replace w/ min from R
	            root.data = getMin(root.right);
	            root.right = remove(root.right, root.data);
	        }
	    }
	    return root;
	}
	
	private void printSideways(IntTreeNode node, String indent) {
		if(node != null) {
			printSideways(node.right, indent+"   ");
			System.out.println(indent + node.data);
			printSideways(node.left, indent+"   ");
			
		}
	}
	
	public class IntTreeNode {
		public int data;
		public IntTreeNode left;
		public IntTreeNode right;
		
		public IntTreeNode(int data) {
			this(data, null, null);
		}
		
		public IntTreeNode(int data, IntTreeNode left, IntTreeNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
}
