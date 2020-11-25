import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

public class Employee {

	private String name;
	private long id;
	private boolean b;
	private char c;
	private int salary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isB() {
		return b;
	}
	public void setB(boolean b) {
		this.b = b;
	}
	public char getC() {
		return c;
	}
	public void setC(char c) {
		this.c = c;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Employee(String name, long id, boolean b, char c, int salary) {
		super();
		this.name = name;
		this.id = id;
		this.b = b;
		this.c = c;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", b=" + b + ", c=" + c + ", salary=" + salary + "]";
	}

	
	public static void main(String[] args) {
		
		Employee e1 = new Employee("Prajwal",1,true,'S',12334);
		ObjectMapper om = new ObjectMapper();
		
		File f = new File("E://Downloads/emp.json");
		try {
			om.writeValue(f,e1);
			System.out.println("Done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
