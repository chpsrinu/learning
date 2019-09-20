package BinarySearchTree;

public interface Tree<T> {
	public int getAgesSum();
	public Node<T> getKSmallest(Node<T> node, int k);
	public Node<T> getRoot(); 
	public void traversal();
	public void delete(T data);
	public T getMax();
	public T getMin();
	public void insert(T data);
}
