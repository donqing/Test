package com.zqd.struct.impl;

import java.util.ArrayList;
import java.util.List;

import com.zqd.struct.TreeNode;

public class BinaryTree {

	private TreeNode root;
	//路径字符串
	private StringBuffer strPath = new StringBuffer();
	
	private List<String> paths = new ArrayList<>();
	//叶子结点个数
	private int countLeaf=0;
	
	 List<String> result = new ArrayList<String>();

	public BinaryTree() {

	}

	public BinaryTree(TreeNode root) {
		this.root = root;
	}
	/**
	 * 返回二叉树从根结点到叶子结点的所有路径
	 * @param root
	 * @return
	 */
//	public List<String> binaryTreePaths(TreeNode root) {
//		
//		if (root == null) {
//			return null;
//		}
//		strPath.append(String.valueOf(root.getVal()+" "));
//		paths.add(strPath.toString());
//		binaryTreePaths(root.getLeft());
//		binaryTreePaths(root.getRight());
//		return paths;
//	}
	//向二叉树中添加结点
	public void add(TreeNode node){
		if (root == null) {
			root = new TreeNode();
		}
		
	}
	public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return result;
    }
	public void dfs(TreeNode node, String path) {
        if(node == null)
            return;
        path = path + node.getVal();
        if(isLeaf(node))
            result.add(path);
        //将其作为参数传进去，每次都能改变
        path = path + "->";
        dfs(node.getLeft(), path);
        dfs(node.getRight(), path);
    }

	//获得二叉树叶子结点的个数
	public void getLeaf(TreeNode root){
		if (root == null) {
			return ;
		}
		TreeNode temp = root;
		if (isLeaf(temp)) {
			countLeaf++;
		}
		getLeaf(temp.getLeft());
		getLeaf(temp.getRight());
		
	}
	public int getCountLeaf(){
		getLeaf(root);
		return this.countLeaf;
	}
	private boolean isLeaf(TreeNode node) {
		if (node == null) {
			return false;
		}
		if (node.getLeft() == null && node.getRight() == null)
			return true;
		else
			return false;
	}
	
}
