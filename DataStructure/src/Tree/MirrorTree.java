package Tree;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class MirrorTree {
	TreeNode curr = null;
	public static TreeNode root = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root = new TreeNode(6);
		MirrorTree mt = new MirrorTree();
		mt.curr = root;
		mt.add(4, root);
		mt.add(10, root);
		mt.add(5, root);
		mt.add(3, root);
		mt.add(7, root);
		mt.add(8, root);
		mt.add(1, root);
		mt.add(9, root);
		mt.displayInorder(root);
	}

	private void displayInorder(TreeNode root) {
		if (root != null) {
			displayInorder(root.left);
			System.out.println(root.data);
			displayInorder(root.right);
		}
	}

	private TreeNode add(int data, TreeNode curr) {

		if (curr == null) {
			curr = new TreeNode(data);
		} else {
			if (data <= curr.data) {
				curr.left = add(data, curr.left);
			} else {
				curr.right = add(data, curr.right);
			}
		}
		return curr;
	}

}
