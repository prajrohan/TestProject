import java.io.File;

public class TryCatch {

	public static void main(String[] args) {
		
		String path = "E:\\Downloads\\BackUp\\tt.sql";
		
		File f = new File(path);
		String execCmd = "mysql -uroot -pmoviesForYou backuptt < "+path;
		Process runTime;
		try {
			if(f.exists())
			{
			runTime = Runtime.getRuntime().exec(execCmd);
			System.out.println("Done");
			}
			else
			{
				display();
			}
			}catch(Exception e)
			{
	           e.printStackTrace();
			}	
	}
	
	public static void display() {
		System.out.println("Inside display()");
		System.out.println("Nothing");
	}
	
}
