import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class FileFromURL {

	public static boolean isConnected()
	{
		boolean b = false;
		String path = "http://www.google.co.in";
	     try {
			URL url = new URL(path); 
			URLConnection connection = url.openConnection();
			connection.connect();
			b = true;
			return b;
			
		}catch (Exception e) {
	        e.printStackTrace();
	        while(b==false) {
	        	isConnected();
	        }
	        return b;
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
	public static void main(String[] args) {
		
		if(isConnected())
		{
	       fileDownload();
		}
		else
		{
			isConnected();
		}
		
	}
}








