/* Name: PhuongLinh Tran
 * File: LinkedBinaryTree.java
 * Desc: implements a binary tree data structure using a doubly linked 
 * list with the specified methods in BinaryTree interface.
 */
import java.util.*;
import java.io.*;

public class LinkedBinaryTree<E extends Comparable<E>>
    implements BinaryTree<E> {
    //Nested Node class of tree
    private static class Node<E> {
	private E data;// referrence to the object that the node holds
	private Node<E> left;// reference to the left child of the node
	private Node<E> right;// reference to the right child of the node

	/* constructs a tree node
	 * @param data The data that the node refers to
	 */
	public Node(E data) {
	    this.data = data;
	    left = right = null;
	}

	/* returns object that the node holds
	 * @return object that the node r4efers to
	 */
	public E getData() {
	    return data;
	}

	/* sets node to refer to specified object
	 * @param data Object to be refered to
	 */
	public void setData(E data) {
	    this.data =data;
	}

	/* returns the left child of the current node
	 * @return Left child of the current node
	 */
	public Node<E> getLeft() {
	    return left;
	}

	/* returns the right child of the current node
	 * @return Right child of the current node
	 */
	public Node<E> getRight() {
	    return right;
	}

	/* set the left child of the current node to specified node
	 * @param n Node to be set as left child
	 */
	public void setLeft(Node<E> n) {
	    left = n;
	}

	/* set the right child of the current node to specified node
	 * @param n Node to be set as right child
	 */
	public void setRight(Node<E> n) {
	    right = n;
	}
    }

    private int size;// number of nodes of tree
    private Node<E> root;// root of tree

    // constructs an empty binary tree
    public <E>LinkedBinaryTree() {
	root = null;
	size = 0;
    }

    /* returns data that root node refers to
     * @return Data referred to by root node
     */
    public E getRootElement() {
	return root.getData();
    }

    /* returns number of nodes or size of tree
     * @returns number of nodes in tree
     */
    public int size() {
	return size;
    }

    /* returns true if tree is empty and false otherwise
     * @return boolean indicating whether tree is empty or not
     */
    public boolean isEmpty() {
	return size == 0;
    }

    /* helper method that recursively checks whether tree contains specified
     * element or not.
     * @param current Current root of the subtree being considered
     * @param data Element to be searched
     * @return True if tree contains specified element and false otherwise
     */
    protected boolean containsRec(Node<E> current, E data) {
	if (current == null) {// if current subtree is empty
	    return false;
	}

	int comp = data.compareTo(current.getData());

	if (comp < 0) {// element searched is "less" than that of root
	    // recurses on left subtree
	    return containsRec(current.getLeft(), data);
	}
	else if (comp > 0) {// element searched is "greater" than that of root
	    // recurses on right subtree
	    return containsRec(current.getRight(), data);
	}
	else {// element search is "equal" to that of root
	    // returns current root
	    return true;
	}
    }

    /* calls containsRec on root of binary tree to look for specified element
     * @param data Element to be searched
     * @return True if tree contains element and false otherwise
     */    
    public boolean contains(E data) {
	return containsRec(root, data);
    }

    /* helper method that recursively insert an element into the tree
     * @param current Root of current subtree being considered
     * @param data Element to be searched
     * @return Root of current subtree
     */
    protected Node<E> insertRec(Node<E> current, E data) {
	if (current == null) {// subtree is null
	    // creates a new node as root for the tree
	    current = new Node<E>(data);
	}

	int comp = data.compareTo(current.getData());

	if (comp == 0) {// element searched and that of current root is "equal"
	    current.setData(data);// updates node
	}
	else if (comp < 0) {// element search is "less" than that of root
	    // recurses on left subtree
	    Node<E> currLeft = insertRec(current.getLeft(), data);
	    current.setLeft(currLeft);
	}

	else {// element search is "greater" than that of root
	    // recurses on right tree
	    Node<E> currRight = insertRec(current.getRight(), data);
	    current.setRight(currRight);
	}
	
	return current;
    }

    /* calls helper method insertRec() to insert element into the tree
     * @param data Element to be added
     */
    public void insert(E data) {
	root = insertRec(root, data);
	size++;// increments size
    }

    /* returns right-most minimum element of the tree
     * @param node Root of current subtree being considered
     * @return Right-most minimum element of subtree
     */ 
    protected Node<E> min(Node<E> node) {
	if (node.getLeft() != null) {
	    return min(node.getLeft());
	}
	return node;
    }

    /* helper method that removes a specified element recursively
     * @param node Root of current subtree being considered
     * @param data Element to be removed
     * return Root of current subtree
     */
    protected Node<E> removeRec(Node<E> node, E data) {
	if (node == null) {// subtree is empty
	    return root;
	}

	int comp = data.compareTo(node.getData());
	
	if (comp < 0) {// element removed is "less" than that of root
	    // recurses on left subtree
	    node.setLeft(removeRec(node.getLeft(), data));
	}

	else if (comp > 0) {// element removed is "greater" than that of root
	    // recurses on right subtree
	    node.setRight(removeRec(node.getRight(), data));
	}

	else {// element removed is "equal" to current root
	    // node has 1 child or 0 child
	    if (node.getLeft() == null) {
		return node.getRight();
	    }
	    else if (node.getRight() == null) {
		return node.getLeft();
	    }
	    // node has 2 children
	    // gets right-most minimum element
	    Node<E> minNode = min(node.getRight());
	    node.setRight(removeRec(node.getRight(), minNode.getData()));
	}
	return node;
    }

    /* returns true if element specified exists in the tree and is deleted,
     * false otherwise
     * @param data Element to be deleted
     * @return true if element exists and is deleted and false otherwise
     */
    public boolean remove(E data) {
	size--;// decrements size of tree
	if (!this.contains(data)) {// tree does not contain such element
	    return false;
	}
	else {// tree contains such element
	    root = removeRec(root, data);
	    return true;
	}
    }

    /* returns an inorder string representation of tree nodes 
     * @param node Root of current subtree
     * @return Inorder string representation of tree nodes
     */    
    protected String inOrder(Node<E> node) {
        if (node != null) {
	    return inOrder(node.getLeft()) + node.getData() + ", " +
		inOrder(node.getRight());
	}
	return "";
    }

    /* returns a preorder string representation of tree nodes 
     * @param node Root of current subtree
     * @return Preorder string representation of tree nodes
     */    
    protected String preOrder(Node<E> node) {
        if (node != null) {
	    return node.getData() + ", " + preOrder(node.getLeft()) +
		preOrder(node.getRight());
        }
	return "";
    }

    /* returns a postorder string representation of tree nodes 
     * @param node Root of current subtree
     * @return Postorder string representation of tree nodes
     */    
    protected String postOrder(Node<E> node) {
        if (node != null) {
	    return postOrder(node.getLeft()) + postOrder(node.getRight()) +
		node.getData()+ ", ";
	}
	return "";
    }

    /* returns an inorder string representation of tree
     * @return Inorder string representation of tree
     */  
    public String toStringInOrder() {
	String s = inOrder(this.root);
	return "(" + s.substring(0, s.length() - 2) + ")";
    }

    /* returns an preorder string representation of tree
     * @return Preorder string representation of tree
     */
    public String toStringPreOrder() {
	String s = preOrder(this.root);
	return "(" + s.substring(0, s.length() - 2) + ")";
    }

    /* returns an postorder string representation of tree
     * @return Postorder string representation of tree
     */
    public String toStringPostOrder() {
	String s = postOrder(this.root);
	return "(" + s.substring(0, s.length() - 2) + ")";
    }
}

