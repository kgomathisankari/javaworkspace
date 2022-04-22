import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamDemo {

	static List<Employee> empList = new ArrayList<Employee>();
	
	public static void main(String args[]) {
		
		empList.add(new Employee( 10, "Ajay Kumar", 22, "Male", "HR",  2010, 25000.0));
		empList.add(new Employee( 12, "Bala Muruga", 42, "Male", "Sales",  2020, 45000.0));
		empList.add(new Employee( 13, "Carl France", 35, "Male", "Marketing",  2014, 37000.0));
		empList.add(new Employee( 14, "Eliza Jose", 42, "Female", "Software",  2007, 250000.0));
		empList.add(new Employee( 15, "Fazul Rose", 50, "Male", "Accounts",  2010, 25000.0));
		empList.add(new Employee( 16, "Gayathri Nayak", 32, "Female", "Sales",  2011, 60000.0));
		empList.add(new Employee( 22, "Hema Vimal", 24, "Female", "Marketing",  2015, 45000.0));
		empList.add(new Employee( 22, "Arun Vijay", 46, "Female", "Marketing",  2010, 95000.0));
		empList.add(new Employee( 24, "Bavna Sampath", 33, "Female", "HR",  2006, 50000.0));
		empList.add(new Employee(26, "Karun Kannan", 40, "Male", "HR",  2000, 70000.0));
		
		method1();
		method2();
		method3();
		method4();
		method5();
		method6();
		method7();
		method8();
		method9();
		method10();
		method11();
		method12();
		method13();
		method14();
		method15();
	}
	
	
	
	private static void method1() {
		
		System.out.println("Q1.Howmany Male and Female Employess in the Organization?");
		Map<String,Long> noOfMaleFemaleEmp = empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
		System.out.println(noOfMaleFemaleEmp);
	
	}
	
	private static void method2() {
		
		System.out.println("\nQ2.Print the name of all departments in the organization");
		empList.stream()
				.map(Employee::getDepartment)
				.distinct()
				.forEach(System.out::println);
		
	}
	
	private static void method3() {
		System.out.println("\nQ3.What is the average age of male and female employees");
		double average = empList.stream()
				.collect(Collectors.averagingInt(Employee::getAge));
		System.out.println("Average age of all the Employees:"+ average);
		
		Map<String, Double> aveMaleandFemaleAge = empList.stream()
		.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		System.out.println(aveMaleandFemaleAge);
	
	}
	
	private static void method4() {
		System.out.println("\nQ4.Get the Details of highest paid Employee");
		Optional<Employee> emp = empList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
		System.out.println(emp);
	
	}
	
	private static void method5() {
		System.out.println("\nQ5.Get the names of all Employess joined after 2015");
		empList.stream()
		.filter(e -> e.getYearOfJoining() >2015)
		.map(Employee::getName)
		.forEach(System.out::println);
	
	}
	
	private static void method6() {
		System.out.println("\nQ6.Count the number of Employees in each Department");
		empList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
				.entrySet()
				.forEach(System.out::println);
	
	}
	
	private static void method7() {
		System.out.println("\nQ7.Average salary for each Department");
		Map<String, Double> averageSalary = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(averageSalary);
	}
	
	private static void method8() {
		System.out.println("\nQ8. Youngest male employee in HR Department");
		
		Optional<Employee> emp= empList.stream()
		.filter(e->e.getDepartment().equals("HR") && e.getGender().equals("Male"))
		.min(Comparator.comparingInt(Employee::getAge));
		System.out.println(emp);
	}
	
	
	private static void method9() {
		System.out.println("\nQ9. Who is the most experienced candidate ?");
		
		Optional<Employee> emp =empList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
		System.out.println(emp);
	}
	
	private static void method10() {
		System.out.println("\nQ10. How many male and female employees are there in sales team");
		
		Map<String,Long> emp = empList.stream()
		.filter(e->e.getDepartment().equals("Sales"))
		.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		
		System.out.println(emp);
	}
	
	
	private static void method11() {
		System.out.println("\nQ11. What is the avereage salary of male and female employees");
		
		Map<String,Double> emp = empList.stream()
		.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(emp);
	}

	private static void method12() {
		System.out.println("\nQ12. List down the name of all employees in each department");
		
		empList.stream()
		.collect(Collectors.groupingBy(Employee::getDepartment))
		.entrySet().forEach(entry -> {
            String key = (String) entry.getKey();
            List<Employee> value = (ArrayList) entry.getValue();
            System.out.println("THE DEPARTMENT NAME IS " + key +"\n The Employee Names are");
            value.forEach(e -> System.out.println(e.getName()));
		});
       
 	}
	private static void method13() {
		System.out.println("\nQ13. Average Salary and Total Salary of the whole organization");
		DoubleSummaryStatistics sumOfSalary = empList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println("Sum of Salary.."+sumOfSalary.getSum());
		System.out.println("Average of Salary.."+sumOfSalary.getAverage());
	}
	
	private static void method14() {
		System.out.println("\nQ14. Seperate the employees who are younger or equal to 25 years to those who are elder and above 25");
		empList.stream().collect(Collectors.partitioningBy(e->e.getAge() > 25))
		.entrySet()
		.forEach(entry -> {
			Boolean key = (Boolean) entry.getKey();
            List<Employee> value = (ArrayList) entry.getValue();
            if(key) {
            	System.out.println("Employees age Greater Than 25 List");
            }
            else {
            	System.out.println("Employees age Below 25 List");
            }
            
            value.forEach(e-> System.out.println(e.getName()));
		}); 
	}
	
	private static void method15() {
		System.out.println("\nQ15.Who is the Oldest employee his age and department");
		Optional<Employee> emp = empList.stream().max(Comparator.comparingInt(Employee::getAge));
		System.out.println("Oldest Employee Name "+emp.get().getName()+" Age "+emp.get().getAge()+" Department "+emp.get().getDepartment());
	}
}
