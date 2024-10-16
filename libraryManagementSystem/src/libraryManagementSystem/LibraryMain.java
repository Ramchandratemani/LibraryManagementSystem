package libraryManagementSystem;

import java.util.Scanner;

public class LibraryMain {

	public static void main(String[] args) {
		
		LibraryMenu lm =  new LibraryMenu();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to Library Management System!!");
		
		while(true) {
			System.out.println("");
			System.out.println("1. Add a new book");
			System.out.println("2. View all books");
			System.out.println("3. Borrow a book");
			System.out.println("4. Return a book");
			System.out.println("5. Search a book");
			System.out.println("6. Delete a book");
			System.out.println("7. Exit");
			
			System.out.println("");
			System.out.println("Enter your choice: ");
			int choice = sc.nextInt();
		
			switch(choice) {
				
			case 1: 
				lm.AddBook();
				break;
			case 2: 
				lm.ViewBook();
				break;
			case 3: 
				lm.BorrowBook();
				break;
			case 4: 
				lm.ReturnBook();
				break;
			case 5:
				lm.SearchBook();
				break;
			case 6:
				lm.DeleteBook();
				break;
			case 7:
				System.out.println("Thank you for visting!!");
				System.exit(0);
				break;
			default:
				System.out.println("Please enter a correct choice!!");
			}
		}

	}

}
