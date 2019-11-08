/* Name: PhuongLinh Tran
 * File: BinaryTree.java
 * Desc: Binary tree interface with following specified methods.
 *
 */
public interface BinaryTree<E extends Comparable<E>> {
    E getRootElement();
    int size();
    boolean isEmpty();
    boolean contains(E element);
    void insert(E element);
    boolean remove(E element);
	
    String toStringInOrder();
    String toStringPreOrder();
    String toStringPostOrder();	
}
