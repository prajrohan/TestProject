package com.fin.tt;

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
import java.util.Date;

public class BackUpRestore {

	public static void main(String[] args) {
	
		StoreToDB();
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
				fileDownloadFromAws();
			}
			}catch(Exception e)
			{
				System.out.println("Exited from restoreDbFile()");
			   System.exit(0);
	           e.printStackTrace();
			}

	}
	
	public static void fileDownloadFromAws()
	{
		String path = "http://touringtalkiesmainserver.in/efe/backUp.sql";
		String path1 = "E:\\Downloads\\BackUp\\tt.sql";
		try {
			if(fileExistsInAws()==true)
			{
			ReadableByteChannel readChannel = Channels.newChannel(
			new URL(path).openStream());
			FileOutputStream fileOS = new FileOutputStream(path1);
			FileChannel writeChannel = fileOS.getChannel();
	        writeChannel.transferFrom(readChannel, 0, Long.MAX_VALUE);
	        System.out.println("Done");
	        restoreDbFile();
			}
	} catch (Exception e) {
		System.out.println("Exited from fileDownloadFromAws()");
		System.exit(0);  //Program will stop
	    e.printStackTrace();
	}
	}
	
	public static boolean isConnected()
	{
	     try {
	    	 System.out.println("Checking Connectivity");
			URL url = new URL("http://www.google.co.in"); 
			URLConnection connection = url.openConnection();
			connection.connect();
			return true;

	     	}catch (Exception e) {
	        e.printStackTrace();
	        return false;
	        }
		
	}
	public static void checkConnectivityAndDownload()
	{
			if(isConnected()==true)
			{
			
			System.out.println("Connected");	
			fileDownloadFromAws();
			}                 
			else
			{
				checkConnectivityAndDownload();
			}
		
	}
	
	
	public static boolean fileExistsInAws()
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
	
	public static void StoreToDB()
	{
		 Date dateFromDb = new Date();
		 boolean dbFlag=true;
		 boolean dbFlagfalse=false;
		 String dateToCheck="";
		 Date date = new Date();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	     String today = sdf.format(date);
	     String sql1 = "update database_stored set modified_date=\""+sdf.format(date)+"\",flag="+dbFlag+" where id = 1";
	     String sql2 = "update database_stored set flag="+dbFlagfalse+" where id = 1";
	     Connection con = null;
	     Statement smt = null;
	     ResultSet rs = null;
	     try {
	    	 Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tt","root","moviesForYou");
				smt = con.createStatement();
				String sql = "select * from database_stored";
				rs = smt.executeQuery(sql);
				while(rs.next())
				{
					dateFromDb = rs.getDate("modified_date");
					dbFlag = rs.getBoolean("flag");
				}
				System.out.println(sdf.format(dateFromDb));
				System.out.println(dbFlag);
				dateToCheck = sdf.format(dateFromDb);
				System.out.println("Date From DB="+dateToCheck);
				
				if(today.equals(dateToCheck) && dbFlag == false)
				{
					if(fileExistsInAws()==true)
					{
						
					    System.out.println("Today and false");
					    checkConnectivityAndDownload();
					    smt.execute(sql1);
					    deleteDo();
						System.out.println("Done Back up");
						

					}
					else
					{
						smt.execute(sql2);
						System.out.println("Exited 1");
						System.exit(0);
					}
				}
				else if(today.equals(dateToCheck) && dbFlag == true)
				{
					    System.out.println("Today and true");
					    System.out.println("Exited 2");
					    System.exit(0);
					    System.out.println("Done");
				}
				else if((!(today.equals(dateToCheck))) && dbFlag == true)
				{
					if(fileExistsInAws()==true)
					{
					            System.out.println("Yesterday and true");
					            checkConnectivityAndDownload();
							    smt.execute(sql1);
							    deleteDo();
								System.out.println("Done");
								
					}
					else
					{
						smt.execute(sql2);
						System.out.println("Exited 3");
						System.exit(0);
					}
				}
				else if((!(today.equals(dateToCheck))) && dbFlag == false)
				{
					if(fileExistsInAws()==true)
					{
					            System.out.println("Yesterday and false");
					            checkConnectivityAndDownload();
							    smt.execute(sql1);
							    deleteDo();
								System.out.println("Done");
								
					}
					else
					{
						smt.execute(sql2);
						System.out.println("Exited 4");
						System.exit(0);
					}
				}
				
	     }catch (Exception e) {
	    	 System.out.println("Exited 'Exception'");
	    	 System.exit(0);
	    	 e.printStackTrace(); 
		}
	finally {
		
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
		
	} //finally
	
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
			    System.out.println("Exited from deleteDo()");
			    System.exit(0);
				e.printStackTrace();
		    	}
	}
	
	
}
