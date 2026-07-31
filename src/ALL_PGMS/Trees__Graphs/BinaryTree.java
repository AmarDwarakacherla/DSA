package ALL_PGMS.Trees__Graphs;
import java.util.*;

public class BinaryTree {
	private TreeNode root;
	private class TreeNode
	{
		private TreeNode left;
		private TreeNode right;
		private int data;
		private TreeNode(int data)
		{
			this.data = data;
		}
		
	}
	public void createBinaryTree()
	{
		TreeNode first = new TreeNode(1);
		TreeNode second = new TreeNode(2);
		TreeNode third = new TreeNode(3);
		TreeNode fourth = new TreeNode(4);
		TreeNode fifth = new TreeNode(15);
		root = first;
		root.left = second;
		root.right = third;
		second.left = fourth;
		second.right = fifth;
		
	}
	public void preorder()
	{
		if(root==null)
			return;
		Stack<TreeNode> stack = new Stack();
		stack.push(root);
		while(!stack.isEmpty())
		{
			TreeNode temp = stack.pop();
			System.out.print(temp.data+"-");
			
			if(temp.right!=null)
				stack.push(temp.right);
			if(temp.left!=null)
				stack.push(temp.left);
		}
	}
	public void Reccursionpreorder(TreeNode root)
	{
		if(root==null)
			return;
		System.out.print(root.data+"-");
		Reccursionpreorder(root.left);
		Reccursionpreorder(root.right);
		
	}
	public static void main(String[] args) {
		BinaryTree obj = new BinaryTree();
		obj.createBinaryTree();
		obj.Reccursionpreorder(obj.root);

	}

}
