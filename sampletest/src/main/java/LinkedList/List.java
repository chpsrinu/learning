package LinkedList;

public interface List<T extends Comparable<T>> {
	public Node<T> getMiddleNode();
	public void insert(T data);
	public void remove(T data);
	public void traversalList();
	public int size();
	public void reverse();
	public int sizeOfList();
	public boolean isCyclic();
}
