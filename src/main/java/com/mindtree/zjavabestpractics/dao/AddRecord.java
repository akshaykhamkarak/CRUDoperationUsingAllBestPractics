package com.mindtree.zjavabestpractics.dao;

import java.util.List;

import com.mindtree.zjavabestpractics.entity.Author;
import com.mindtree.zjavabestpractics.entity.Book;
import com.mindtree.zjavabestpractics.exception.ConnectionUtilityException;
import com.mindtree.zjavabestpractics.exception.DaoInputException;
import com.mindtree.zjavabestpractics.exception.DaoOutputException;

public interface AddRecord {

boolean addRecordOfBook(Book book)throws DaoInputException,ConnectionUtilityException;

List<Book> displayAuthorDao() throws DaoOutputException;
}