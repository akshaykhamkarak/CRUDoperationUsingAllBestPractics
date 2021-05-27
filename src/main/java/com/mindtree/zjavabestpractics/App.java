package com.mindtree.zjavabestpractics;

import java.util.Scanner;

import com.mindtree.zjavabestpractics.exception.DaoOutputException;
import com.mindtree.zjavabestpractics.exception.InpuFormatEcxeption;
import com.mindtree.zjavabestpractics.exception.InputException;
import com.mindtree.zjavabestpractics.service.InputInterface;
import com.mindtree.zjavabestpractics.service.impl.InputInterfaceImpl;
import com.mindtree.zjavabestpractics.utility.InputUtility;

/**
 * Hello world!
 *
 */
public class App 
{
	static InputInterface ip=new InputInterfaceImpl();
//	public App() {
//		super();
//		ip=new InputInterfaceImpl();
//		
//	}
    public static void main( String[] args )throws InputException, InpuFormatEcxeption,InpuFormatEcxeption, DaoOutputException
    {
    	boolean condition = false;
    	
     
      do {
    	  Options.displayMenu();
    	  try {
    		  int choice=InputUtility.getChoice();
    		  switch (choice) {
			case 1:
				try {
				ip.addMethod();
				}
				catch (InpuFormatEcxeption e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				Options.exit();
				condition=true;
				break;
			case 3:
				ip.displayAuthorDetails();
				break;
			default:
				System.out.println("You enter wrong choice please enter correct choice..");
				break;
			}
    		  
    		  
  	  }
    	  catch (InputException e) {
    		  condition=true;
    		System.out.println(e.getMessage());
		}
    	 
      }while(!condition);
      
      
    }
}
