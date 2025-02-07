package Pratice;

import java.util.LinkedList;
import java.util.List;

import lombok.Data;

@Data
class Student{
	
	private String name;
	private int marks;
	private String standard;
	private String gender;
	
	public Student(String name, int marks, String standard, String gender) {
		super();
		this.name = name;
		this.marks = marks;
		this.standard = standard;
		this.gender = gender;
	}
	
	
	
}

public class MarksGreaterThanSixty {
	
	public static void main(String[] args) {
		
		List<Student> studentList = new LinkedList<>();
		studentList.add(new Student("G1",65,"Fifth","Female"));
		studentList.add(new Student("G2",70,"Sixth","Female"));
		studentList.add(new Student("B1",64,"Fifth","Male"));
		studentList.add(new Student("B2",69,"Fifth","Male"));
		studentList.add(new Student("G3",75,"Fifth","Female"));
		studentList.add(new Student("G4",50,"Tenth","Female"));

		
		studentList.stream().filter(student->student.getStandard().equals("Fifth"))
		.filter(t->t.getMarks()>60)
		.filter(u->u.getGender().equals("Female"))
		.forEach(System.out::println);

	}

}
