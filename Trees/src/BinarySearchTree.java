import java.util.Scanner;

class Node {
	int item;
	Node left;
	Node right;
}

public class BinarySearchTree {

	static Node root = null;

	public static void main(String[] args) {

		int n, i;
		System.out.println("Enter no of iemsto insert: ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		BinarySearchTree bst = new BinarySearchTree();
		for (i = 0; i < n; i++) {
			bst.add(root,sc.nextInt());
		}
		Node rootTemp=root;
		bst.displayInorder(rootTemp);
		
	}

	private void displayInorder(Node root) {
		// TODO Auto-generated method stub
		if(root!=null) {
			displayInorder(root.left);
			System.out.println(root.item);
			displayInorder(root.right);
		}
	}

	

	private Node add(Node root,int item) {
		// TODO Auto-generated method stub
		if (root == null) {
			Node temp = new Node();
			temp.item = item;
			temp.left = null;
			temp.right = null;
			root = temp;
			if(BinarySearchTree.root==null)
			BinarySearchTree.root=root;
			return root;

		} else if (item < root.item) {
			root.left = add(root.left, item);
			return root;

		} else
			root.right = add(root.right, item);
		return root;
		

	}

	
}
