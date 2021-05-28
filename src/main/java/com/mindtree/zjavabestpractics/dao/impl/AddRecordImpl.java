package com.mindtree.zjavabestpractics.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.zjavabestpractics.dao.AddRecord;
import com.mindtree.zjavabestpractics.entity.Author;
import com.mindtree.zjavabestpractics.entity.Book;
import com.mindtree.zjavabestpractics.exception.ConnectionUtilityException;
import com.mindtree.zjavabestpractics.exception.DaoInputException;
import com.mindtree.zjavabestpractics.exception.DaoOutputException;
import com.mindtree.zjavabestpractics.exception.DataNotFound;
import com.mindtree.zjavabestpractics.utility.JDBCUtility;



public class AddRecordImpl implements AddRecord {

	 
	
	public boolean addRecordOfBook(Book book) throws DaoInputException, ConnectionUtilityException {
		boolean result = false;
		Connection con = null;
		// Author author = new Author();
		PreparedStatement ps = null, ps2 = null,ps3=null;
		int i = 0;

		try {
			con = JDBCUtility.getConnection();
			ps = con.prepareStatement("insert into book1 (bookid,title,price) values(?,?,?)");
			ps.setInt(1, book.getId());
			ps.setString(2, book.getTitle());
			ps.setInt(3, book.getPrice());
			int count = ps.executeUpdate();
			
			
			ps2 = con.prepareStatement("insert into author1 (authorid,name) values(?,?)");
			ps3 = con.prepareStatement("insert into lookup (bid,aid) values(?,?)");
			//System.out.println(book.getAuthors());
			for (Author author : book.getAuthors()) {
				ps2.setInt(1, author.getId());
				ps2.setString(2, author.getName());
			
				ps2.executeUpdate();
			}
				for (Author author : book.getAuthors()) {
				ps3.setInt(1,book.getId());
				ps3.setInt(2, author.getId());
				ps3.executeUpdate();
			//	i++;
			}
//			if (i % 1000 == 0 || i == book.getAuthors().size()) {
//				ps2.executeBatch();
//			}
			System.out.println(count);
			if (count > 0) {
				result = true;
			}

		} catch (Exception e) {
			throw new DaoInputException("Data insertion fail..");
		}

		finally {
			try {
				con.close();
				ps.close();
			} catch (SQLException e) {
			}

		}

		return result;
	}

	public List<Book> displayAuthorDao() throws DaoOutputException {
		List<Book> list = new ArrayList<Book>();
	
		Connection con=null;
		//PreparedStatement ps=null;
		
		try {
			con=JDBCUtility.getConnection();
			   Statement stmt = con.createStatement();
			   ResultSet rs = stmt.executeQuery("select * from book");
			//ps=con.prepareStatement
			//ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
			 Book b=new Book();
			  int id = rs.getInt("bookid");
	            String name = rs.getString("title");
	           int price = rs.getInt("price");
	          //  System.out.println(id+"   "+name+"    "+job);
//				b.setId(rs.getString(1));
//				b.setTitle(rs.getString(2));
//				b.setPrice(rs.getInt(3));
//		
	            b.setId(id);
	        
	            b.setPrice(price);
	            
	            b.setTitle(name);
//	            System.out.println(b.getId());
//	            System.out.println(b.getTitle());
//	            System.out.println(b.getPrice());
				list.add(b);
			}
		}
	catch (Exception e) {
		throw new DaoOutputException("Data not available...");
	}
		finally {
			try {
				con.close();
				//ps.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
		}
		
		return list;
	}

	public List<Author> displayAuthorDetailsDao() throws DaoOutputException {
		Connection con=null;
		PreparedStatement ps=null;
		ArrayList<Author>list=new ArrayList<Author>();
		try {
			con=JDBCUtility.getConnection();
			ps=con.prepareStatement("select * from author");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Author author=new Author();
				author.setId(rs.getInt(1));
				author.setName(rs.getString(2));
				author.setBookid(rs.getInt(3));
				list.add(author);
			}
			
		}
		catch (Exception e) {
			throw new DaoOutputException("author data not get from table");
		}
		finally {
			try {
				con.close();
				ps.close();
				
			} catch (SQLException e) {}
		}
		return list;
	}

	public boolean deleteBookDao(Book book) throws DataNotFound, SQLException {
    boolean result=false;
    Connection con=null;
    PreparedStatement ps=null;
    try {
    	con=JDBCUtility.getConnection();
    	ps=con.prepareStatement("delete from lookup where bid=?");
    	ps.setInt(1, book.getId());
    	int count=ps.executeUpdate();
    	if(count>0)
    		result=true;
    	
    }catch (Exception e) {
		throw new DataNotFound("Record not found exception..");
	}
    finally {
		con.close();
		
	}
		return result;
	}

	

}
