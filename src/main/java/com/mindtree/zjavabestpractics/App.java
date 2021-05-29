package com.mindtree.zjavabestpractics;

import java.util.Scanner;

import com.mindtree.zjavabestpractics.exception.DaoInputException;
import com.mindtree.zjavabestpractics.exception.DaoOutputException;
import com.mindtree.zjavabestpractics.exception.DataNotFound;
import com.mindtree.zjavabestpractics.exception.InpuFormatEcxeption;
import com.mindtree.zjavabestpractics.exception.InputException;
import com.mindtree.zjavabestpractics.service.InputInterface;
import com.mindtree.zjavabestpractics.service.impl.InputInterfaceImpl;
import com.mindtree.zjavabestpractics.utility.InputUtility;

/**
 * Hello world!
 *
 */
public class App {
	static InputInterface ip = new InputInterfaceImpl();

//	public App() {
//		super();
//		ip=new InputInterfaceImpl();
//		
//	}
	public static void main(String[] args)
			throws InputException, InpuFormatEcxeption, DaoOutputException, DataNotFound {
		boolean condition = false;

		do {
			Options.displayMenu();
			try {
				int choice = InputUtility.getChoice();
				switch (choice) {
				case 1:

					try {
						ip.addMethod();
					} catch (DaoInputException e) {

						System.err.println(e.getMessage());
					}
					break;
				case 2:
					ip.displayAuthorDetails();
					break;
				case 3:
					ip.displayAuthor();
					break;
				case 4:
					Options.exit();
					condition = true;
					break;
				case 5:
					ip.deleteBookByBookId();
					break;
				case 6:
					ip.displyAllRecord();
					break;
				default:
					System.out.println("You enter wrong choice please enter correct choice..");
					break;
				}

			} catch (InputException e) {
				
				condition = true;
				System.out.println(e.getMessage());
			}

		} while (!condition);

	}
}
