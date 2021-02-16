package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.BookType;
import Tools.String_Tool;

public class BookTypeDao {

	public int add(Connection conn,BookType booktype) throws Exception {
		
		String sql="insert into bm_BookType values(null,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, booktype.getBookTypeName());
		pstmt.setString(2, booktype.getBookTypeDesc());
		
		return pstmt.executeUpdate();
		
	}
	
	public ResultSet list(Connection conn,BookType bt)throws Exception {
		StringBuffer sb=new StringBuffer("select * from bm_booktype");
		if(String_Tool.isNotEmpty(bt.getBookTypeName())) {
			sb.append(" and BookTypeName like '%"+bt.getBookTypeName()+"%'");
		}
		PreparedStatement pstmt=conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	public int delete(Connection conn,String id)throws Exception {
		
		String sql="delete from bm_booktype where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	public int update(Connection conn,BookType bt)throws Exception {
		String sql="update bm_booktype set BookTypeName=?,BookTypeDesc=? where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);		
		pstmt.setString(1, bt.getBookTypeName());
		pstmt.setString(2, bt.getBookTypeDesc());
		pstmt.setInt(3, bt.getId());
		return pstmt.executeUpdate();
	}
	
}
