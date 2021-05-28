package com.mindtree.zjavabestpractics.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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

			result = addrec.addRecordOfBook(book);

			if (result == true) {
				System.out.println("Success..");

			} else
				System.out.println("Fail to add");
		}
		catch (Exception e) {
			throw new DaoInputException("Input must be check...");
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

	public void displyAllRecord() {

	}

}
