import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;




public class SaveDb {
 
	
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		String sql="";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/backuptt","root","moviesForYou");
			stmt = con.createStatement();
			sql = "create table if not exists saveDataBackUp(Saved_date datetime, Message varchar(255))";
            stmt.executeUpdate(sql);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String d = sdf.format(date);
			sql = "insert into saveDataBackUp values(?,?)";
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, d);
			pstmt.setString(2, "Success");
			pstmt.executeUpdate();
			
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
			if(stmt!=null)
			{
				try {
					stmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(pstmt!=null) {
				
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}
	
	
}
