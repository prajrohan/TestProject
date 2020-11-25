import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CheckDate {

	
 public static void main(String[] args) {
	
	 String x = "1576813332000";

			 DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

			 long milliSeconds= Long.parseLong(x);
			 System.out.println(milliSeconds);

			 Calendar calendar = Calendar.getInstance();
			 calendar.setTimeInMillis(milliSeconds);
			 System.out.println(formatter.format(calendar.getTime()));  
}
}
