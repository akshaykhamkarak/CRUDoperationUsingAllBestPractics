package com.mindtree.zjavabestpractics.service;

import com.mindtree.zjavabestpractics.exception.DaoInputException;
import com.mindtree.zjavabestpractics.exception.DaoOutputException;
import com.mindtree.zjavabestpractics.exception.DataNotFound;
import com.mindtree.zjavabestpractics.exception.InpuFormatEcxeption;

public interface InputInterface {

	void addMethod() throws InpuFormatEcxeption,DaoInputException;

	void displayAuthorDetails() throws DaoOutputException;

	void displayAuthor() throws DaoOutputException;

	void deleteBookByBookId()throws DataNotFound;

	void displyAllRecord();



	



}
