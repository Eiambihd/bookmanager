package Tools;
import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	private String url="jdbc:mysql://localhost:3306/aaa";
	private String name="root";
	private String pwd="ldk19990527";
	private String jdbcname="com.mysql.jdbc.Driver";
	
	public Connection getCon() throws Exception{
		Class.forName(jdbcname);
		Connection conn=DriverManager.getConnection(url, name, pwd);
		return conn;
	}
	
	public void close(Connection conn)throws Exception{
		if(conn!=null) {
			conn.close();
		}
	}
	public static void main(String[] args) {
		DB d=new DB();
		try {
			d.getCon();
			//System.out.println("11111111111111111111");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
