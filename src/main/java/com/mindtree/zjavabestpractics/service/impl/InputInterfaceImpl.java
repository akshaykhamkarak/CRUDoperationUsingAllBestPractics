package com.mindtree.zjavabestpractics.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.mindtree.zjavabestpractics.dao.AddRecord;
import com.mindtree.zjavabestpractics.dao.impl.AddRecordImpl;
import com.mindtree.zjavabestpractics.entity.Author;
import com.mindtree.zjavabestpractics.entity.Book;
import com.mindtree.zjavabestpractics.exception.ConnectionUtilityException;
import com.mindtree.zjavabestpractics.exception.DaoInputException;
import com.mindtree.zjavabestpractics.exception.DaoOutputException;
import com.mindtree.zjavabestpractics.exception.DataNotFound;
import com.mindtree.zjavabestpractics.exception.InpuFormatEcxeption;
import com.mindtree.zjavabestpractics.exception.InputException;
import com.mindtree.zjavabestpractics.service.InputInterface;

public class InputInterfaceImpl implements InputInterface {

	static AddRecord addrec;

	public InputInterfaceImpl() {
		super();
		addrec = new AddRecordImpl();
	}

	Scanner sc = new Scanner(System.in);

	public void addMethod() throws InpuFormatEcxeption, DaoInputException {
		String title = "";
		int price = 0, id;

		List<Author> authors = new ArrayList<Author>();
		int aid = 0;
		String aname = "";

		boolean result = false;
		try {

			System.out.println("Enter the book id");
			id = sc.nextInt();
			System.out.println("Enter the book title");
			title = sc.next();
			System.out.println("Enter the book price");
			price = sc.nextInt();
			System.out.println("how many auther you want to add with this book");
			int authcount = sc.nextInt();
			for (int i = 0; i < authcount; i++) {
				Author author = new Author();
				System.out.println("Enter the auth id: ");
				aid = sc.nextInt();
				author.setId(aid);
				System.out.println("Enter auther name");
				aname = sc.next();
				author.setName(aname);

				authors.add(author);
			}
			Book book = new Book(id, title, price, authors);

			try {
				result = addrec.addRecordOfBook(book);
			} catch (ConnectionUtilityException e) {

				System.out.println(e.getMessage());
			}

			if (result == true) {
				System.out.println("Success..");

			}
		} catch (DaoInputException e) {
			System.out.println(e.getMessage());
		}
	}

	public void displayAuthorDetails() throws DaoOutputException {
		List<Book> list = new ArrayList<Book>();
		try {
			list = addrec.displayAuthorDao();
			System.out.println(list.size());
		} catch (DaoOutputException e) {
			System.err.println(e.getMessage());
		}
		System.out.println("============Book-detalis==============");
		System.out.println("BookID " + "BookPrice " + "BookTitle");
		for (Book b : list) {

			System.out.print(" " + b.getId());
			System.out.print("\t  " + b.getPrice());
			System.out.print("\t  " + b.getTitle() + "\n");

		}
		System.out.println("=======================================");

	}

	public void displayAuthor() throws DaoOutputException {
		List<Author> list = new ArrayList<Author>();
		try {
			list = addrec.displayAuthorDetailsDao();
			System.out.println("============Author-detalis==============");
			System.out.println("AuthorID " + "AuthorName " + "BookId");
			for (Author b : list) {

				System.out.print(" " + b.getId());
				System.out.print("\t  " + b.getName());
				System.out.print("\t  " + b.getBookid() + "\n");

			}
			System.out.println("=======================================");
		} catch (DaoOutputException e) {
			System.err.println(e.getMessage());
		}

	}

	public void deleteBookByBookId() throws DataNotFound {
		System.out.println("Enter the Book id which you want to delete:");
		int bookid = 0;
		bookid = sc.nextInt();

		boolean result = false;
		Book book = new Book();
		book.setId(bookid);
		try {
			result = addrec.deleteBookDao(book);
			if (result)
				System.out.println("Element delete success");
			else
				System.out.println("record not found..");
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void displyAllRecord() throws DaoOutputException {

		Map<Integer, String>map=new HashMap<Integer, String>();
		try {
		map=addrec.getAuthorData();
		//only print data of author
		Iterator<Integer>it=map.keySet().iterator();
		while(it.hasNext())  
		{  
		int key=(int)it.next();  
		System.out.println("Author Id:  "+key+"     name:   "+map.get(key));  
		}  
		
		//sorted with Name
	      ValueComparator bvc = new ValueComparator(map);
	        TreeMap<Integer, String> sorted_map = new TreeMap<Integer, String>(bvc);
	        sorted_map.putAll(map);
	      System.out.println("=======================================");
	        Iterator<Integer>it1=sorted_map.keySet().iterator();
	        while(it1.hasNext()) {
	        	int key=(int)it1.next();
	        	System.out.println("sort Author Id:  "+key+"     sort name:   "+map.get(key));
	        }
	       System.out.println("results: " + sorted_map);
		
		}catch (DaoOutputException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
