
public class FreeMemory {

	
	public static void main(String[] args) {
		
		Runtime r = Runtime.getRuntime();
		System.out.println("Free space = "+r.freeMemory());
		System.out.println("Total space = "+r.totalMemory());
		
	}
	
}
