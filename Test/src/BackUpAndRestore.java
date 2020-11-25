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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BackUpAndRestore {

	public static void main(String[] args) {
		
		StoreToDB();
		
	}
	
	
	public static void StoreToDB()
	{
		 Date dateFromDb = new Date();
		 boolean dbFlag=true;
		 String dateToCheck="";
		 Date date = new Date();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	     String today = sdf.format(date);
	     String sql1 = "update test2 set saved_date=\""+sdf.format(date)+"\",flag="+dbFlag+" where id = 1";
	     Connection con = null;
	     Statement smt = null;
	     ResultSet rs = null;
	     try {
	    	 Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","moviesForYou");
				smt = con.createStatement();
				String sql = "select * from test2";
				rs = smt.executeQuery(sql);
				while(rs.next())
				{
					dateFromDb = rs.getDate("saved_date");
					dbFlag = rs.getBoolean("flag");
				}
				System.out.println(sdf.format(dateFromDb));
				System.out.println(dbFlag);
				dateToCheck = sdf.format(dateFromDb);
				System.out.println("Date From DB="+dateToCheck);
				
				if(today.equals(dateToCheck) && dbFlag == false)
				{
					    System.out.println("Today and false");
						OperationBackupAndRestore();
						smt.execute(sql1);
						checkConnectivityAndDelete();
						System.out.println("Done");		
				}
				else if(today.equals(dateToCheck) && dbFlag == true)
				{
					    System.out.println("Today and true");
					    System.exit(0);
					    System.out.println("Done");
				}
				else if((!(today.equals(dateToCheck))) )
				{
					     System.out.println("Yesterday");
								OperationBackupAndRestore();
								smt.execute(sql1);
								checkConnectivityAndDelete();
								System.out.println("Done");
				}
				
	     }catch (Exception e) {
		
	    	 if(con!=null)
	    	 {
	    		 try {
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	 }
	    	 if(smt !=null) {
	    		 try {
					smt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	 }
	    	 if(rs!=null)
	    	 {
	    		 try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	 }
		}
		
		
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
	
	
	public static void restoreDbFile()
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
				checkConnectivityAndDownload();
			}
			}catch(Exception e)
			{
	           e.printStackTrace();
			}


	}
	
	public static void checkConnectivityAndDownload()
	{
			if(isConnected()==true)
			{
				fileDownload();
				
			}                   
			else
			{
				checkConnectivityAndDownload();
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
	
	public static boolean fileExists()
	{
		String path = "http://touringtalkiesmainserver.in/efe/tt.sql";
        
     try {
	 
    	 HttpURLConnection.setFollowRedirects(false);
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
	
	public static void checkConnectivityAndDelete()
	{
			if(isConnected()==true)
			{
				deleteDo();
				
			}
			else
			{
				checkConnectivityAndDelete();
			}

			
	}
	
	
	public static void OperationBackupAndRestore()
	{
		checkConnectivityAndDownload();
		restoreDbFile();
	}
	

	
	
}
