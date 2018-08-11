package practise.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CollectionTest1 {
	public static void main(String[] args) {
		Set<Employee> set = new HashSet<Employee>();
		Employee employee = new Employee(1, "张三", 20, "2018-3-10");
		Employee employee1 = new Employee(2, "李四", 22, "2018-3-11");
		Employee employee2 = new Employee(3, "王五", 23, "2018-3-12");
		set.add(employee);
		set.add(employee1);
		set.add(employee2);
		Iterator<Employee> iterator = set.iterator();
		while(iterator.hasNext()) {
			Employee emplyee3 = iterator.next();
			System.out.println(emplyee3.getName());
		}
		
	}
}
class Employee{
	private int id;
	private String name;
	private int age;
	private String entryDate;
	
	public Employee(int id, String name, int age, String entryDate) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.entryDate = entryDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
	
}