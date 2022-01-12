import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
		Connection 연결 = null;		 
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        연결=DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/db1?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC", // DB URL
	                    "root", "1234");  // USER_NAME과 PASSWORD
	        
	        
	        
	        Statement 명령=연결.createStatement();
	        
	        for(int i=1; i<=332;i++) {
	        	String sql=String.format("insert into board(title,contents) values('title%d','contents%d')", i, i);
	        명령.executeUpdate(sql);
	        }
	        
	            //DB조작
	        연결.close();
	   }
	   catch(Exception ex){ ex.printStackTrace(); }		

	}

}
