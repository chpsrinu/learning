package learning;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueSample {

	public static void main(String[] args) {
		// PriorityQueue<Integer> queue = new PriorityQueue<>();
		// queue.add(100);
		// queue.add(20);
		// queue.add(15);
		//
		// System.out.println(queue.peek());
		// System.out.println(queue.poll());
		// System.out.println(queue.peek());
		// PriorityQueue<String> queue = new PriorityQueue<>();
		// queue.add("C");
		// queue.add("C++");
		// queue.add("JAVA");
		// queue.add("PYTHON");
		//
		// System.out.println("Head value useing peek function : "+
		// queue.peek());
		//
		// System.out.println("print all elements:");
		// Iterator<String> itr = queue.iterator();
		// while(itr.hasNext()) {
		// System.out.println(itr.next());
		// }
		PriorityQueue<Student> queue = new PriorityQueue<Student>(5, new StudentComparator());
		queue.add(new Student("Nandini", 3.2));
		queue.add(new Student("Anmol", 3.6));
		queue.add(new Student("Palak", 4.0));
		System.out.println("System served in proiorty order:");
		while (!queue.isEmpty()) {
			System.out.println(queue.poll().getName());
		}

	}
}

class StudentComparator implements Comparator<Student> {
	public int compare(Student s1, Student s2) {
		if (s1.cgpa < s2.cgpa) {
			return 1;
		} else if (s1.cgpa > s2.cgpa) {
			return -1;
		} else {
			return 0;
		}
	}
}

class Student {
	public String name;
	public double cgpa;

	public Student(String name, double cgpa) {
		this.name = name;
		this.cgpa = cgpa;
	}

	public String getName() {
		return this.name;
	}
}
