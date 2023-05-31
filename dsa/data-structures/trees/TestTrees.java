package practice.trees;

import java.util.Scanner;

import practice.trees.BinarySearchTree.TreeNode;

public class TestTrees {

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.insert(5);
		bst.insert(25);
		bst.insert(16);
		bst.insert(67);
		bst.insert(72);
		bst.insert(45);
		
		//inorder traversal print
		bst.printInOrder();
		
		System.out.println();
		
		TreeNode node = bst.search(67);
		System.out.println("Prints null if key not found, else prints the key");
		System.out.println(node == null ? null : node.getData());
		
		
	}

}
