public class BinaryTree {

	private static Node root;

	public BinaryTree() {
		root = null;
	}

	public boolean add(int i) {
		Node newNode = new Node(i);
		Node focus = root;
		if (root == null) {
			root = newNode;
			return true;
		} else {
			while (true) {
				if (newNode.val >= focus.val) {
					if (focus.rchild == null) {
						focus.rchild = newNode;
						return true;
					} else
						focus = focus.rchild;
				} else if (newNode.val < focus.val) {
					if (focus.lchild == null) {
						focus.lchild = newNode;
						return true;
					} else
						focus = focus.lchild;
				}
			}
		}
	}
	
	private boolean inOrderTraversal(Node root2) {
		if (root2 == null) {
			//do something
		} else {
			inOrderTraversal(root2.lchild);
			System.out.print(String.valueOf(root2.val) + " ");
			inOrderTraversal(root2.rchild);
		}
		return true;
	}
	
	private boolean preOrderTraversal(Node root2) {
		if (root2 == null) {
			//do something
		} else {
			System.out.print(String.valueOf(root2.val) + " ");
			inOrderTraversal(root2.lchild);
			inOrderTraversal(root2.rchild);
		}
		return true;
	}

	public void inOrderTraversal() {
		inOrderTraversal(root);
	}
	
	public void preOrderTraversal() {
		preOrderTraversal(root,"");
	}

}
