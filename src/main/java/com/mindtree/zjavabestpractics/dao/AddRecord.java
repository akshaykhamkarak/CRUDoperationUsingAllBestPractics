package com.mindtree.zjavabestpractics.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.mindtree.zjavabestpractics.entity.Author;
import com.mindtree.zjavabestpractics.entity.Book;
import com.mindtree.zjavabestpractics.exception.ConnectionUtilityException;
import com.mindtree.zjavabestpractics.exception.DaoInputException;
import com.mindtree.zjavabestpractics.exception.DaoOutputException;
import com.mindtree.zjavabestpractics.exception.DataNotFound;

public interface AddRecord {

boolean addRecordOfBook(Book book)throws DaoInputException,ConnectionUtilityException;

List<Book> displayAuthorDao() throws DaoOutputException;

List<Author> displayAuthorDetailsDao()throws DaoOutputException;

boolean deleteBookDao(Book book)throws DataNotFound,SQLException;

Map<Integer, String> getAuthorData()throws DaoOutputException ;


}