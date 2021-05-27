package com.mindtree.zjavabestpractics.utility;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.mindtree.zjavabestpractics.exception.InputException;

public class InputUtility {
static Scanner sc=new Scanner(System.in);
	public static int getChoice()throws InputException {
		
		int choice=0;
		try {
			System.out.println("Enter your choice");
			choice=sc.nextInt();
		} catch (InputMismatchException e) {
		throw new InputException("Inter the correct number in valid format..");
		}
		return choice;
	}

	
}
