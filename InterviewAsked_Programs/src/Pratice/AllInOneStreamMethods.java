package Pratice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

class Employee {
	int id;

	String name;

	int age;

	String gender;

	String department;

	int yearOfJoining;

	double salary;

	public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getDepartment() {
		return department;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Id : " + id + ", Name : " + name + ", age : " + age + ", Gender : " + gender + ", Department : "
				+ department + ", Year Of Joining : " + yearOfJoining + ", Salary : " + salary;
	}
}

public class AllInOneStreamMethods {

	public static void main(String[] args) {

		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		// How many male and female employees are there in the organization?
		Map<String, Long> maleFemaleCount = employeeList.stream()
				.collect(Collectors.groupingBy(emp -> emp.getGender(), Collectors.counting()));
		System.out.println(maleFemaleCount);

		System.out.println("--------------------------------------------------------------------------------");

		// Print the name of all departments in the organization?
		employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

		System.out.println("--------------------------------------------------------------------------------");

		// What is the average age of male and female employees?
		Map<String, Double> averageAgeMaleAndFemale = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
		System.out.println(averageAgeMaleAndFemale);

		System.out.println("--------------------------------------------------------------------------------");

		// Get the details of highest paid employee in the organization?
		employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary)).ifPresent(System.out::println);
		employeeList.stream().max((a, b) -> (int) (a.getSalary() - b.getSalary())).ifPresent(System.out::println);

		System.out.println("--------------------------------------------------------------------------------");

		// Get the names of all employees who have joined after 2015?
		employeeList.stream().filter(emp -> emp.getYearOfJoining() > 2015).forEach(System.out::println);
		employeeList.stream().filter(emp -> emp.getYearOfJoining() > 2015).map(Employee::getName)
				.forEach(System.out::println);

		System.out.println("--------------------------------------------------------------------------------");

		// Count the number of employees in each department?
		Map<String, Long> employeeCountByDepartment = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		Set<Entry<String, Long>> entrySet = employeeCountByDepartment.entrySet();

		for (Entry<String, Long> entry : entrySet) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		System.out.println("--------------------------------------------------------------------------------");

		// What is the average salary of each department?
		employeeList.stream()
				.collect(
						Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
				.entrySet().forEach(a -> System.out.println(a.getKey() + " " + a.getValue()));

		System.out.println("--------------------------------------------------------------------------------");

		// Get the details of youngest male employee in the product development
		// department?
		Employee youngestMaleEmployeeInProductDevelopmentWrapper = employeeList.stream()
				.filter(emp -> emp.getDepartment().equals("Product Development") && emp.getGender().equals("Male"))
				.min(Comparator.comparingInt(Employee::getAge)).get();
		System.out.println(youngestMaleEmployeeInProductDevelopmentWrapper);

		System.out.println("--------------------------------------------------------------------------------");

		// Who has the most working experience in the organization?
		Employee seniorMostEmployee = employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining))
				.findFirst().get();
		System.out.println(seniorMostEmployee);

		System.out.println("--------------------------------------------------------------------------------");

		// How many male and female employees are there in the sales and marketing team?

		Map<String, Long> countMaleFemaleEmployeesInSalesMarketing = employeeList.stream()
				.filter(e -> e.getDepartment() == "Sales And Marketing")
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		System.out.println(countMaleFemaleEmployeesInSalesMarketing);

		Map<String, Long> employeeCountByGender = employeeList.stream()
				.filter(emp -> emp.getDepartment().equals("Sales And Marketing"))
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(employeeCountByGender);

		System.out.println("--------------------------------------------------------------------------------");

		System.out.println("--------------------------------------------------------------------------------");
	}
}
