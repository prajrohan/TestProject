import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
public class InternetCheck {

public static void main(String[] args) {

}

public static boolean isConnected()
{
     try {
		URL url = new URL("http://www.google.co.in"); 
		URLConnection connection = url.openConnection();
		connection.connect();
		return true;
	}catch (Exception e) {
        e.printStackTrace();
        return false;
	}
	
}

public static void fileDownload()
{
	String path = "http://touringtalkiesmainserver.in/efe/backUp.sql";
	String path1 = "E:\\Downloads\\BackUp\\tt.sql";
	try {
		ReadableByteChannel readChannel = Channels.newChannel(
		new URL(path).openStream());
		FileOutputStream fileOS = new FileOutputStream(path1);
		FileChannel writeChannel = fileOS.getChannel();
        writeChannel.transferFrom(readChannel, 0, Long.MAX_VALUE);
        System.out.println("Done");
        
} catch (Exception e) {
    e.printStackTrace();
}
}

public static void restoreDb()
{

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
		   finalMethodCall();
		}
		}catch(Exception e)
		{
           e.printStackTrace();
		}


}

public static void finalMethodCall()
{
	for(;;)
	{
		if(isConnected()==true)
		{
			fileDownload();
			break;
		}                   
		else
		{
			isConnected();
		}
	}
}


public static void deleteDo() {
	 String path="http://touringtalkiesmainserver.in:9090/tt/aws/backupFileDelete.do?file=backUp.sql";
		
		try {
			URL obj = new URL(path);
			HttpURLConnection con =(HttpURLConnection) obj.openConnection();
			con.setRequestMethod("DELETE");
			int responseCode = con.getResponseCode();
			System.out.println(responseCode +"  Deleted");
		    } catch (Exception e) 
		    {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Not Deleted");
	    	}
}

}


