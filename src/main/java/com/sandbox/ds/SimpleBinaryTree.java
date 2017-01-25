package com.sandbox.ds;

public class SimpleBinaryTree {

	public static void main(String... args) {

		Node rootNode = new Node(1);
		
		Node leftNode = new Node(2);
		leftNode.setLeftNode(new Node(4));
		leftNode.setRightNode(new Node(5));
		
		Node rightNode = new Node(3);
		rightNode.setLeftNode(new Node(6));
		rightNode.setRightNode(new Node(7));
		
		rootNode.setLeftNode(leftNode);
		rootNode.setRightNode(rightNode);
		
		System.out.println(rootNode.toString());

	}

}

class Node {

	private int key;

	private Node leftNode;

	private Node rightNode;

	private Node() {
		// Do nothing
	}

	public Node(int key) {
		this.key = key;
		this.leftNode = null;
		this.rightNode = null;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Node getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + key;
		result = prime * result + ((leftNode == null) ? 0 : leftNode.hashCode());
		result = prime * result + ((rightNode == null) ? 0 : rightNode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (key != other.key)
			return false;
		if (leftNode == null) {
			if (other.leftNode != null)
				return false;
		} else if (!leftNode.equals(other.leftNode))
			return false;
		if (rightNode == null) {
			if (other.rightNode != null)
				return false;
		} else if (!rightNode.equals(other.rightNode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Node [key=" + key + ", leftNode=" + leftNode + ", rightNode=" + rightNode + "]";
	}

}

enum Orientation {
	LEFT, RIGHT
}
