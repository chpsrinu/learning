package learning;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ComparatorExamples2 {

	public static void main(String[] args) {
		List<Student> list = getStudentList();
		Collections.sort(list, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return (o1.getName()).compareTo(o2.getName());
			}});
		
		System.out.println("sorted oputput : "+ list);
		
		Map<String, String> file = new TreeMap<String, String>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});

		file.put("python", ".py");
		file.put("c++", ".cpp");
		file.put("kotlin", ".kt");
		file.put("goLang", ".go");
		file.put("java", ".java");
		
		System.out.println("sorted map : "+ file);
		
	}
	
	public static List<Student> getStudentList() {
		ComparatorExamples2 comp =  new ComparatorExamples2();
		Student s1 = comp.new Student("Ram", 85.5, "SJV"); 
        Student s2 = comp.new Student("Shyam", 83.25, "MSH"); 
        Student s3 = comp.new Student("Mohan", 86.55, "SJV"); 
        Student s4 = comp.new Student("Sohan", 81.00, "MSH"); 
        Student s5 = comp.new Student("Rabi", 55.6, "SJV"); 
        List<Student> list = Arrays.asList(s1, s2, s3, s4, s5);
        return list;
	}
	
	class Student {
		private String name;
		private double precentageMarks;
		private String school;
		
		public Student(String name, double percentage, String school) {
			this.name = name;
			this.precentageMarks = percentage;
			this.school = school;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getPrecentageMarks() {
			return precentageMarks;
		}

		public void setPrecentageMarks(double precentageMarks) {
			this.precentageMarks = precentageMarks;
		}

		public String getSchool() {
			return school;
		}

		public void setSchool(String school) {
			this.school = school;
		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", precentageMarks=" + precentageMarks + ", school=" + school + "]";
		}
		
		
	}
}
