package Dao;

import java.sql.Connection;
import java.sql.*;
import Model.User;

public class UserDao {
	
	public User login(Connection conn,User user)throws Exception{
		User resultUser=null;
		
		String sql="select * from bm_user where name=? and pwd=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, user.getName());
		pstmt.setString(2, user.getPwd());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			resultUser=new User();
			resultUser.setId(rs.getString("id"));
			resultUser.setName(rs.getNString("name"));
			resultUser.setPwd(rs.getNString("pwd"));
		}
		return resultUser;
	}
	
}
