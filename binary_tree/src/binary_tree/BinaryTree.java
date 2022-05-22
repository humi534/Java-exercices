package binary_tree;

public class BinaryTree<T> {
	
	private Node<T> root;
	private int depth;
	
	public BinaryTree(T payload) {
		this.root = new Node<T>(true, payload);
	}
	
	public BinaryTree<T> combined (BinaryTree<T> t1, BinaryTree<T> t2) {
		
		//Check that t1 and t2 have disjoint sets of nodes
		Node<T>[] t1List = new Node<T>[];
		
		
		
		
		//Creation of new Tree
		
		Node<T> newRoot = new Node<>(false);
		BinaryTree<T> newTree = new BinaryTree<>(newRoot);
		
		newRoot.setLeft(t1.root);
		newRoot.setRight(t2.root);
		
		return newTree;
	}
	
	
	public boolean checkIfNodeInTree(BinaryTree<T> tree, Node<T> node) {
		
		
		return false;
	}
	
	
	
	public int getNumberOfNodes() {
		if(this.root == null){
			return 0;
		}
		
		return Rec_Nodes(this.root);
	}
	
	public int Rec_Nodes(Node<T> node){
		
		if(!node.isLeaf())
			return 1;
		
		return Rec_Nodes(node.getLeft()) + Rec_Nodes(node.getRight());
	}
}







