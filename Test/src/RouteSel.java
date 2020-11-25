import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RouteSel {

	
	public static void main(String[] args) throws IOException {
		
		 /*FileWriter writer = new FileWriter("D:\\testout.txt");  
		    BufferedWriter buffer = new BufferedWriter(writer);  
		    buffer.write("Welcome to javaTpoint.");  
		    buffer.close();  
		    System.out.println("Success");*/
		
		String path = "c:/var/www/html/gps/efe/system32/manualAnnoucement/stopNames/abc";
				
		
		BufferedWriter bw = null;
		
		try {
			File f = new File(path);
			if(!f.exists()) {
				f.mkdir();
			}
			path = path + "/501stopname.txt";
			bw = new BufferedWriter(new FileWriter(path));
			bw.write("1:generalMessages-abc");
			System.out.println("Success");
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		finally {
			
			if(bw!=null) {
				
				bw.close();
			}
		}
		
	    
	}
	
}
