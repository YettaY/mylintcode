package Search;

public class DFS {
	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
	//����1���ݹ�
	public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // do something with root
        traverse(root.left);
        // do something with root
        traverse(root.right);
        // do something with root
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
