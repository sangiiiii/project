package project;

import java.util.Scanner;

public class DriverClass {
	/* 
	 * main method
	 * object created for laptopmanagement , laptopmanagement type memory allocated
	 * Scanner is used to get input from user 
	 */
	public static void main(String args[]) {     
		Laptopmanagement obj = new Laptopmanagement();  
		Scanner scan = new Scanner(System.in); 
	    
		int enterChoice;  
		/*
		 * Local varriable- enterchoice
		 * Do while loop is used to execute the program atleast once
		*/
		do{
			enterChoice = scan.nextInt();
			// switch cases
			switch(enterChoice) {
			case 1:  
				obj.toAdd();
				break;
			case 2 :
				obj.toDisplay();
				break;
			case 3:
				obj.toSearch(obj);
				break;
			case 4:
				obj.toDelete(obj);			
				break;
			case 5:
		       obj.toUpdate(obj);
				break;
			case 6:
				break;
			}
		}
		while(enterChoice !=6);
		scan.close();
	}

}

