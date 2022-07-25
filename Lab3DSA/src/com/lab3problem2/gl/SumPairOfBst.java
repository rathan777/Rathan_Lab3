package com.lab3problem2.gl;

import java.util.HashSet;

public class SumPairOfBst {
 static class Node{
	 int data;
	 Node leftNode,rightNode;	 
 };
 
 public static Node NewNode(int data) {
	Node temp=new Node();
	temp.data=data;
	temp.leftNode=null;
	temp.rightNode=null;
	return temp;
 }
 
 public Node insert (Node root,int key)
 {
	 if(root==null)
		 return NewNode(key);
	 if(key<root.data)
		 root.leftNode=insert(root.leftNode,key);
	 else
		 root.rightNode=insert(root.rightNode,key);
	 return root;
	 
 }
 public boolean findpairUtil(Node root, int sum,HashSet<Integer> set)
	{
		if (root == null)
			return false;

		if (findpairUtil(root.leftNode, sum, set))
			return true;

		if (set.contains(sum - root.data)) {
			System.out.println("Pair is found ("
					+ (sum - root.data) + ", "
					+ root.data + ")");
			return true;
		}
		else
			set.add(root.data);

		return findpairUtil(root.rightNode, sum, set);
	}
	

public void findPairWithGivenSum(Node root, int sum) {
	HashSet<Integer> set = new HashSet<Integer>();
	if(!findpairUtil(root,sum,set))
		System.out.println("Pairs do not exist"+"\n");
}
public static void main(String args[]) {
	Node root= null;
	SumPairOfBst sumpair= new SumPairOfBst();
	root= sumpair.insert(root, 40);
	root= sumpair.insert(root, 20);
	root= sumpair.insert(root, 60);
	root= sumpair.insert(root, 10);
	root= sumpair.insert(root, 30);
	root= sumpair.insert(root, 50);
	root= sumpair.insert(root, 70);
	
	int sum=20;
	sumpair.findPairWithGivenSum(root, sum);			
}
	
}

