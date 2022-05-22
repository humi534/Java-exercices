package binary_tree;

public class Node<T> {
	private boolean isLeaf;
	private final T payload;
	private Node<T> left;
	private Node<T> right;
	
	public Node(boolean isLeaf) {
		this.payload = null;
		this.left = null;
		this.right = null;
		this.isLeaf = isLeaf;
	}
	
	public Node(boolean isLeaf, T payload) {
		this.left = null;
		this.right = null;
		this.isLeaf = isLeaf;
		this.payload = payload;
	}
	
	
	public boolean isLeaf() {
		return this.isLeaf;
	}
	
	public Node<T> getLeft() {
		return this.left;
	}
	
	public Node<T> getRight() {
		return this.right;
	}
	
	public void setLeft(Node<T> left) {
		this.left = left;
	}
	
	public void setRight(Node<T> right) {
		this.right = right;
	}
	
	public T getPayload() {
		return this.payload;
	}
	
	public boolean hasLeft() {
		return this.left != null;
	}
	
	public boolean hasRight() {
		return this.right != null;
	}
	
	
	
	
	
	
}
