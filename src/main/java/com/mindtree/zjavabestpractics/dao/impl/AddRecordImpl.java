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
import com.mindtree.zjavabestpractics.utility.JDBCUtility;



public class AddRecordImpl implements AddRecord {

	public boolean addRecordOfBook(Book book) throws DaoInputException, ConnectionUtilityException {
		boolean result = false;
		Connection con = null;
		// Author author = new Author();
		PreparedStatement ps = null, ps2 = null;
		int i = 0;

		try {
			con = JDBCUtility.getConnection();
			ps = con.prepareStatement("insert into bookrecord (id,title,price) values(?,?,?)");
			ps.setString(1, book.getId());
			ps.setString(2, book.getTitle());
			ps.setInt(3, book.getPrice());
			int count = ps.executeUpdate();
			ps2 = con.prepareStatement("insert into author (id,name) values(?,?)");
			for (Author author : book.getAuthors()) {
				ps2.setString(1, author.getId());
				ps2.setString(2, author.getName());
				ps2.addBatch();
				i++;
			}
			if (i % 1000 == 0 || i == book.getAuthors().size()) {
				ps2.executeBatch();
			}
			System.out.println(count);
			if (count > 0) {
				result = true;
			}

		} catch (Exception e) {
			throw new DaoInputException("Problem in code..");
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
			   ResultSet rs = stmt.executeQuery("select * from bookrecord");
			//ps=con.prepareStatement
			//ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Book b=new Book();
			    String id = rs.getString("id");
	            String name = rs.getString("title");
	           int job = rs.getInt("price");
	          //  System.out.println(id+"   "+name+"    "+job);
//				b.setId(rs.getString(1));
//				b.setTitle(rs.getString(2));
//				b.setPrice(rs.getInt(3));
//		
	            b.setId(id);
	        
	            b.setPrice(job);
	            
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

}
