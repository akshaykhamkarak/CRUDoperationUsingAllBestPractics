package com.mindtree.zjavabestpractics.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mindtree.zjavabestpractics.dao.AddRecord;
import com.mindtree.zjavabestpractics.dao.impl.AddRecordImpl;
import com.mindtree.zjavabestpractics.entity.Author;
import com.mindtree.zjavabestpractics.entity.Book;
import com.mindtree.zjavabestpractics.exception.DaoInputException;
import com.mindtree.zjavabestpractics.exception.DaoOutputException;
import com.mindtree.zjavabestpractics.exception.InpuFormatEcxeption;
import com.mindtree.zjavabestpractics.exception.InputException;
import com.mindtree.zjavabestpractics.service.InputInterface;

public class InputInterfaceImpl implements InputInterface {
	
	static AddRecord addrec;
	public InputInterfaceImpl() {
		super();
		addrec=new AddRecordImpl();
	}
Scanner sc=new Scanner(System.in);
	public void addMethod() throws InpuFormatEcxeption{
		String id="",title="";
		int price=0;
		
		List<Author> authors = new ArrayList<Author>();
		String aid="";
		String aname="";
		
		boolean result=false;
		try {
		
			System.out.println("Enter the book id");
			id=sc.next();
			System.out.println("Enter the book title");
			title=sc.next();
			System.out.println("Enter the book price");
			price=sc.nextInt();
			System.out.println("how many auther have");
			int authcount=sc.nextInt();
			for (int i = 0; i < authcount; i++) {
				Author author=new Author();
				System.out.println("Enter the auth id: ");
				aid=sc.next();
				author.setId(aid);
				System.out.println("Enter auther name");
				aname=sc.next();
				author.setName(aname);
				
			   authors.add(author);
			}
			Book book=new Book(aid, title, price, authors);
			result=addrec.addRecordOfBook(book);
			
			if(result==true) {
				System.out.println("Success..");
				
			}
			else
				System.out.println("Fail to add");
		}
		catch (Exception e) {
			throw new InpuFormatEcxeption("Data is not enter in proper format..");
		}

	}
	public void displayAuthorDetails() throws DaoOutputException {
		List<Book>list=new ArrayList<Book>();
	try {
		list=addrec.displayAuthorDao();
		System.out.println(list.size());
	}
	catch (DaoOutputException e) {
		System.err.println(e.getMessage());
	}
	
		for(Book b:list) {
			System.out.print(" "+b.getId());
			System.out.print(" "+b.getPrice());
			System.out.print(" "+b.getTitle());
		}
		
	
	}

}
