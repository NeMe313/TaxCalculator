package com.sales.taxes.service;

import java.util.Scanner;

/**
 * The class is used to give a user a console choice on which input version
 * he/she would like to add to his virtual shopping cart
 * 
 */
public class Chooser {

	public static String getUserChoice() {

		Scanner scan = new Scanner(System.in);

		String fileName = "";
		boolean inputVal = true;

		// Asking for user choice until he/she enters a correct number (between 1-3)
		while (inputVal) {

			System.out.println("Please select a file number to read:\n" + "1\n2\n3\n");
			int choice = scan.nextInt();

			switch (choice) {

			case 1:
				fileName = "input1.txt";
				inputVal = false;
				break;
			case 2:
				fileName = "input2.txt";
				inputVal = false;
				break;
			case 3:
				fileName = "input3.txt";
				inputVal = false;
				break;
			default:
				System.out.println("Please type an integer: 1, 2, or 3");
				scan.nextInt();
			}
		}
		scan.close();
		return fileName;
	}

}
