package com.mindtree.zjavabestpractics.service;

import com.mindtree.zjavabestpractics.exception.DaoOutputException;
import com.mindtree.zjavabestpractics.exception.InpuFormatEcxeption;

public interface InputInterface {

	void addMethod() throws InpuFormatEcxeption;

	void displayAuthorDetails() throws DaoOutputException;

	



}
