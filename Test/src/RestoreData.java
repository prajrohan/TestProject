

public class RestoreData {

	public static  boolean restoreData() {
		
		    String dbUserName="root";
			String dbPassword="moviesForYou";
			String dbName="backUptt";
			String path="E:\\Downloads\\BackUp\\tt.sql";
			String executeCmd="mysql -u"+dbUserName+" -p"+dbPassword+" -f "+dbName+" < "+path;
			
			System.out.println(executeCmd);
			//mysql -uroot -pmoviesForYou -f backUptt < E:\Downloads\BackUp\tt.sql
			Process process;
			try {
				process = Runtime.getRuntime().exec(executeCmd);
				 int processComplete = process.waitFor();
				 
		            if (processComplete == 0) {
		                System.out.println("Restored Successfully");
		                return true;
		            } else {
		                System.out.println("Problem occured");
		            }
			}
		catch (Exception e) {
	        e.printStackTrace();
		}
     	return false;
	}
	
	public static void main(String[] args) {
		
		System.out.println(restoreData());
	}
}
