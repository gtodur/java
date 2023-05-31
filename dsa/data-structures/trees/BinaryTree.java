package practice.trees;

import java.util.Scanner;

import practice.stack.StackAsLinkedList;

public class BinaryTree<T> {

	private TreeNode<T> root;
	
	public BinaryTree() {
		this.root = null;
	}
	
	public TreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}
	
	public static TreeNode createTree() {
		TreeNode root = null;
		System.out.println("Enter data");
		int data = sc.nextInt();
		
		if(data == -1) {
			return null;
		}
		
		root = new TreeNode(data);
		
		System.out.println("Enter left for : " + data);
		root.setLeft(createTree());
		
		System.out.println("Enter right for : " + data);
		root.setRight(createTree());
		
		return root;
	}
	
	public static void recursiveInOrderTraversal(TreeNode root) {
		if(root == null) return;
		
		recursiveInOrderTraversal(root.getLeft());
		System.out.print(root.getData() + " ");
		recursiveInOrderTraversal(root.getRight());
	}
	
	public static void recursivePreOrderTraversal(TreeNode root) {
		if(root == null) return;
		
		System.out.print(root.getData() + " ");
		recursivePreOrderTraversal(root.getLeft());
		recursivePreOrderTraversal(root.getRight());
	}
	
	public static void recursivePostOrderTraversal(TreeNode root) {
		if(root == null) return;
		
		recursivePostOrderTraversal(root.getLeft());
		recursivePostOrderTraversal(root.getRight());
		System.out.print(root.getData() + " ");
	}
	
	public static void iterativeInOrderTraversal(TreeNode root) {
		if(root == null) {
			return;
		}
		StackAsLinkedList<TreeNode> stack = new StackAsLinkedList<>();
		TreeNode temp = root;
		
		while(!stack.isEmpty() || temp != null) {
			if(temp != null) {
				stack.push(temp);
				temp = temp.getLeft();
			} else {
				temp = stack.pop();
				System.out.print(temp.getData() + " ");
				temp = temp.getRight();
			}
		}
	}
	
	public static void iterativePreOrderTraversal(TreeNode root) {
		if(root == null) {
			return;
		}
		StackAsLinkedList<TreeNode> stack = new StackAsLinkedList<>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			System.out.print(temp.getData() + " ");
			if(temp.getRight() != null) {
				stack.push(temp.getRight());
			}
			if(temp.getLeft() != null) {
				stack.push(temp.getLeft());
			}
		}
	}
	
	public static void iterativePostOrderTraversal(TreeNode root) {
		TreeNode current = root;
		StackAsLinkedList<TreeNode> stack = new StackAsLinkedList<>();
		
		while(current != null || !stack.isEmpty()) {
			if(current != null) {
				stack.push(current);
				current = current.getLeft();
			} else {
				TreeNode temp = stack.peek().getRight();
				if(temp == null) {
					temp = stack.pop();
					System.out.print(temp.getData() + " ");
					while(!stack.isEmpty() && temp == stack.peek().getRight()) {
						temp = stack.pop();
						System.out.print(temp.getData() + " ");
					}
				} else {
					current = temp;
				}
			}
		}
	}
	
	public static boolean isValidBST(TreeNode root) {
	    return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);    
	}
	 
	/*
	 * check for valid BST via recursive method
	 */
	public static boolean isValidBST(TreeNode root, Integer min, Integer max){
	    if(root==null) 
	        return true;
	 
	    if((Integer)root.getData() <= min || (Integer)root.getData() >= max)
	        return false;
	 
	    boolean left = isValidBST(root.getLeft(), min, (Integer)root.getData());
	    if(left) {
	    	boolean right = isValidBST(root.getRight(), (Integer)root.getData(), max);
	    	return right;
	    }
	    return false;
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
	
	static Scanner sc = null;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
//		//create Binary Tree
//		TreeNode root = createTree();
//		System.out.println("Root -> " + root.getData());
//		
//		System.out.println("RECURSIVE TRAVERSALS");
//		
//		//Recursive Traversals
//		System.out.print("InOrder traversal - ");
//		recursiveInOrderTraversal(root);
//		
//		System.out.println();
//		
//		System.out.print("PreOrder traversal - ");
//		recursivePreOrderTraversal(root);
//		
//		System.out.println();
//		
//		System.out.print("PostOrder traversal - ");
//		recursivePostOrderTraversal(root);
//		
//		System.out.println();
//		System.out.println("ITERATIVE TRAVERSALS");
//		
//		//Iterative Traversals
//		System.out.print("InOrder traversal - ");
//		iterativeInOrderTraversal(root);
//		
//		System.out.println();
//		
//		System.out.print("PreOrder traversal - ");
//		iterativePreOrderTraversal(root);
//		
//		System.out.println();
//		
//		System.out.print("PostOrder traversal - ");
//		iterativePostOrderTraversal(root);
		
		/*
		 * Test for binary tree being a binary search tree
		 */
						TreeNode bstCheckRoot = createTree();
			System.out.println("Prints yes if BST else no");
			System.out.println(isValidBST(bstCheckRoot));
	}
	
}
