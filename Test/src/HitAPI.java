

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
public class HitAPI {
 
	
	public static void main(String[] args) {
		
	    String path="http://touringtalkiesmainserver.in:9090/tt/aws/backupFileDelete.do?file=backUp.sql";
		
		try {
			
			URL obj = new URL(path);
			HttpURLConnection con =(HttpURLConnection) obj.openConnection();
			con.setRequestMethod("DELETE");
			int responseCode = con.getResponseCode();
			System.out.println(responseCode +"  Deleted");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Not Deleted");
		}
		
		
	}
	
}
