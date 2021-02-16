package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.Book;
import Tools.String_Tool;

public class BookDao {
	
	public int add(Connection conn,Book b)throws Exception{
		
		String sql="insert into bm_Book values(null,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, b.getBookName());
		pstmt.setString(2, b.getAuthor());
		pstmt.setString(3, b.getSex());
		pstmt.setFloat(4, b.getPrice());
		pstmt.setInt(5, b.getBookTypeId());
		pstmt.setString(6, b.getBookDesc());
		return pstmt.executeUpdate();
	}
	
	public ResultSet list(Connection conn,Book b)throws Exception{
		StringBuffer sb=new StringBuffer("select * from bm_Book b,bm_booktype bt where b.BookTypeId=bt.id");
		if(String_Tool.isNotEmpty(b.getBookName())) {
			sb.append(" and b.BookName like '%"+b.getBookName()+"%'");
		}
		if(String_Tool.isNotEmpty(b.getAuthor())) {
			sb.append(" and b.Author like '%"+b.getAuthor()+"%'");
		}
		if(b.getBookTypeId()!=null&&b.getBookTypeId()!=-1){
			sb.append(" and b.BookTypeId like '%"+b.getBookTypeId()+"%'");
		}
		PreparedStatement pstmt=conn.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	
	public int DeleteBook(Connection conn,String bid)throws Exception {
		String sql="delete from bm_book where Id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, bid);
		return pstmt.executeUpdate();
	}
	
	public int UpdateBook(Connection conn,Book b)throws Exception{
		String sql="update bm_book set BookName=?,Author=?,Sex=?,price=?,BookTypeId=?,BookDesc=? where Id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, b.getBookName());
		pstmt.setString(2, b.getAuthor());
		pstmt.setString(3, b.getSex());
		pstmt.setFloat(4, b.getPrice());
		pstmt.setInt(5, b.getBookTypeId());
		pstmt.setString(6, b.getBookDesc());
		pstmt.setInt(7, b.getId());
		return pstmt.executeUpdate();
	}
	
	public boolean ExistBookByBookTypeId(Connection conn,String btid)throws Exception{
		String sql="select * from bm_book where BookTypeId=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, btid);
		ResultSet rs=pstmt.executeQuery();
		return rs.next();
	}
	
}
