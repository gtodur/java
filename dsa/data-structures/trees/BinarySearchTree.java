package practice.trees;

import practice.trees.BinaryTree.TreeNode;

public class BinarySearchTree<T> {
private TreeNode<T> root;
	
	public BinarySearchTree() {
		this.root = null;
	}
	
	public TreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}
	
	public void insert(int value) {
		this.root = insert(root, value);
	}
	
	private TreeNode insert(TreeNode root, int data) {
		if(root == null) {	//base case
			root = new TreeNode<>(data);
			return root;
		}
		if(data < (Integer)root.getData()) {
			root.setLeft(insert(root.getLeft(), data));
		} else {
			root.setRight(insert(root.getRight(), data));
		}
		
		return root;
	}
	
	public void printInOrder() {
		inOrder(root);
	}
	
	public void inOrder(TreeNode root) {
		if(root == null) return;
		
		inOrder(root.getLeft());
		System.out.print(root.getData() + " ");
		inOrder(root.getRight());
	}
	
	public TreeNode search(int key) {
		return search(root, key);
	}
	
	private TreeNode search(TreeNode root, int key) {
		if(root == null || (Integer)root.getData() == key) {
			return root;
		}
		if(key < (Integer)root.getData()) {
			return search(root.getLeft(), key);
		} else {
			return search(root.getRight(), key);
		}
	}
	
	static class TreeNode<T> {
		private TreeNode<T> left;
		private TreeNode<T> right;
		private T data;
		
		public TreeNode(T data) {
			this.left = null;
			this.right = null;
			this.data = data;
		}

		public TreeNode<T> getLeft() {
			return left;
		}

		public void setLeft(TreeNode<T> left) {
			this.left = left;
		}

		public TreeNode<T> getRight() {
			return right;
		}

		public void setRight(TreeNode<T> right) {
			this.right = right;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}
	}
}
