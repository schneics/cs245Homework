import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTree<E extends Comparable<E>> {
	private BSTNode<E> root; // root of overall tree
	private int numElements;

	// post: constructs an empty search tree
	public BinarySearchTree() {
		this.root = null;
		this.numElements = 0;
	}

	// post: value added to tree so as to preserve binary search tree
	public void add(E value) {
		root = add(root, value);
		numElements++;
	}

	// post: value added to tree so as to preserve binary search tree
	private BSTNode<E> add(BSTNode<E> node, E value) {
		if (node == null) {
			node = new BSTNode<E>(value);
		} else if (node.data.compareTo(value) > 0) {
			node.left = add(node.left, value);
		} else if (node.data.compareTo(value) < 0) {
			node.right = add(node.right, value);
		} else if (node.data.compareTo(value) == 0) {
			numElements--;
		}
		return node;
	}

	// post: returns true if tree contains value, returns false otherwise
	public boolean contains(E value) {
		return contains(root, value);
	}

	// post: returns true if given tree contains value, returns false otherwise
	private boolean contains(BSTNode<E> node, E value) {
		if (node == null) {
			return false;
		} else {
			int compare = value.compareTo(node.data);
			if (compare == 0) {
				return true;
			} else if (compare < 0) {
				return contains(node.left, value);
			} else { // compare > 0
				return contains(node.right, value);
			}
		}
	}

	public void remove(E value) {
		this.root = remove(root, value);
		numElements--;
	}

	private BSTNode<E> remove(BSTNode<E> node, E value) {
		if (node == null) {
			numElements++;
			return null;
		} else if (node.data.compareTo(value) > 0) {
			node.left = remove(node.left, value);
		} else if (node.data.compareTo(value) < 0) {
			node.right = remove(node.right, value);
		} else {
			if (node.right == null) {
				return node.left;
			} else if (node.left == null) {
				return node.right;
			} else {
				node.data = getMax(node.left);
				node.left = remove(node.left, node.data);
			}
		}
		return node;
	}

	public void clear() {
		numElements = 0;
		root = null;
	}

	public boolean isEmpty() {
		if (numElements == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int size() {
		return numElements;
	}

	public E[] toArray() {
		List<E> list = new ArrayList<>(size());
		toArray(root, list);
		return (E[]) list.toArray();

	}

	private void toArray(BSTNode<E> node, List<E> aList) {
		

	}

	public Iterator<E> iterator() {
		return new Iterator(root);
	}

	private E getMax(BSTNode<E> node) {
		if (node.right == null) {
			return node.data;
		} else {
			return getMax(node.right);
		}
	}

	public static class Iterator<E> {
		private Stack<BSTNode<E>> stack;

		public Iterator(BSTNode<E> node) {
			stack = new Stack<>();
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
		}

		public boolean hasNext() {
			return !stack.isEmpty();
		}

		public E next() {
			BSTNode<E> node = stack.pop();
			E data = node.data;
			if (node.right != null) {
				node = node.right;
				stack.push(node);
				while (node.left != null) {
					node = node.left;
					stack.push(node);
				}
			}
			return data;
		}
	}

	private static class BSTNode<E> {
		public E data;
		public BSTNode<E> left;
		public BSTNode<E> right;

		public BSTNode(E data) {
			this(data, null, null);
		}

		public BSTNode(E data, BSTNode<E> left, BSTNode<E> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
}
