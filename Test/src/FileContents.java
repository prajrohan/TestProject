import java.io.File;

public class FileContents {

	
	public static void main(String[] args)
	{
		String path = "C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/docs";
		File file = new File(path);
		File [] files = file.listFiles();
		
		for(File f:files) {
			
			if(f.isDirectory()) {
			
				System.out.println(f.getName());
			}
		}
		
		
		
	}
	
}
