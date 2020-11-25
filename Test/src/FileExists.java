import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExists {

	public static void main(String[] args) {

	System.out.println(fileExists());

		
	}
	
	public static boolean fileExists()
	{
		String path = "http://touringtalkiesmainserver.in/efe/backUp.sql";
        
     try {
	 
    	 HttpURLConnection.setFollowRedirects(false);
         // note : you may also need
         //        HttpURLConnection.setInstanceFollowRedirects(false)
         HttpURLConnection con =
            (HttpURLConnection) new URL(path).openConnection();
         con.setRequestMethod("HEAD");
         return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
        }
     catch (Exception e) {
    	 e.printStackTrace();
    	 return false;
	}

	}
}
