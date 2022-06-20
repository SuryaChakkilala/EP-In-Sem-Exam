package insemlab;

import java.util.Scanner;

public class Main {
	
	public static void displayMenu() {
		System.out.println("---MENU---");
		System.out.println("1. Create Table Hospital");
		System.out.println("2. Insert 1 record");
		System.out.println("3. Insert 4 records");
		System.out.println("4. Display patients data");
		System.out.println("5. Delete a patient data");
		System.out.println("6. Update patient data");
		System.out.println("Enter any other option to stop the process.");
	}
	
	public static void main(String[] args) {
		boolean isRunning = true;
		Scanner sc = new Scanner(System.in);
		while(isRunning) {
			displayMenu();
			int id, age;
			String name, contactno;
			int choice = sc.nextInt();
			switch(choice) {
			case 1: DBOperations.createTable();
			break;
			case 2: 
				System.out.println("Enter the id");
				id = sc.nextInt();
				System.out.println("Enter the name");
				name = sc.next();
				System.out.println("Enter the age");
				age = sc.nextInt();
				System.out.println("Enter the contact no");
				contactno = sc.next();
				DBOperations.insertRecord(id, name, age, contactno);
				break;
			case 3:
				for(int i=0;i<4;i++) {
					System.out.println("Enter the id");
					id = sc.nextInt();
					System.out.println("Enter the name");
					name = sc.next();
					System.out.println("Enter the age");
					age = sc.nextInt();
					System.out.println("Enter the contact no");
					contactno = sc.next();
					DBOperations.insertRecord(id, name, age, contactno);
				}
				break;
			case 4:
				DBOperations.displayRecords();
				break;
			case 5:
				System.out.println("Enter the ID of the entry to delete");
				id = sc.nextInt();
				DBOperations.deleteRecord(id);
				break;
			case 6:
				System.out.println("Enter the id of entry to update");
				id = sc.nextInt();
				System.out.println("Enter the name of the entry to update");
				name = sc.next();
				System.out.println("Enter the age of the entry to update");
				age = sc.nextInt();
				DBOperations.updateRecord(id, name, age);
				break;
			default:
				isRunning = false;
				sc.close();
			}
		}
	}

}
