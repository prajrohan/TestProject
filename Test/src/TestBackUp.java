import java.io.IOException;

public class TestBackUp {

	public static void main(String[] args) {
		String dbUserName = "root";
		String dbPassword = "moviesForYou";
		String dbName = "tt";
		String path = "/var/www/html/efe/dbBackUp/tt.sql";
		String tableNames ="Announcement contentinbus customer_complaint deviceonoff EliteDeviceStatus customer_movie quiz_user";
		String executeCmd ="mysqldump -u"+dbUserName+" -p"+dbPassword+" -t --compact --insert-ignore "+dbName+" "+tableNames+" -r "+ path;

		System.out.println(executeCmd);
	}
//	mysqldump -uroot -pmoviesForYou rohan -r /tmp/rohan.sql

}
