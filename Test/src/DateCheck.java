
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCheck {

	public static void main(String[] args) {
		System.out.println(toDate());
		String date = toDate();
		String time = "18:15:30";
		if(date.endsWith(time))
		{
			System.out.println("Success");
		}
		else
		{
			System.out.println("Failure");
		}
	}
	
	public static String toDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();    
        return dateFormat.format(date).toString();
    }	
	
}
