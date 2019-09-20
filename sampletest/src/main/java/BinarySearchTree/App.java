package BinarySearchTree;

public class App {
	
	public static void main(String[] args) {

//		Tree<Integer> tree = new BinarySearchTree<>();
//		
//		tree.insert(10);
//		tree.insert(5);
//		tree.insert(15);
//		tree.insert(3);
//		tree.insert(7);
//		
//		tree.traversal();
//		tree.delete(10);
//		tree.traversal();
		
		Tree<Person> bst = new BinarySearchTree<Person>();
		
		bst.insert(new Person("Adam", 47));
		bst.insert(new Person("Kevin", 21));
		bst.insert(new Person("Joe", 55));
		bst.insert(new Person("Arnold", 20));
		bst.insert(new Person("Noel", 34));
		bst.insert(new Person("Marko", 68));
		bst.insert(new Person("Susan", 23));
		bst.insert(new Person("Rose", 38));
		
		System.out.println(bst.getAgesSum());
		
		
	}

}
