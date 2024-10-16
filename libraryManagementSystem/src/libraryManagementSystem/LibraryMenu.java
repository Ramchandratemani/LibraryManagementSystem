package libraryManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryMenu {
	
	private ArrayList<Book> books;
	private String user;
	Scanner sc;
	
	public LibraryMenu() {
		this.books = new ArrayList<>();
		this.sc = new Scanner(System.in);
	}
	
	//To delete the book using book Id
	public void DeleteBook() {
		
		System.out.println("Please enter the book id to delete a book");		
		String bookId = sc.nextLine();
		
		Book book = findBookByID(bookId);
		
		if(book != null) {
			books.remove(book);
			System.out.println("Book successfully deleted!!");
		}
		else {
			System.out.println("");
			System.out.println("Please enter correct Book ID, Book was not found.");
		}
	}
		
	
	//To search the book using book name
	public void SearchBook() {
		
		System.out.println("Enter book name to search for a book: ");
		String bookName = sc.nextLine();
		System.out.println("");
		
		Book book = findBookByTitle(bookName);
		
		if(book == null) {
			System.out.println("Book was not found!!");
		}
		else {
			System.out.println(book);
		}
		
	}
	
	//To return the book using book name
	public void ReturnBook() {
		
		System.out.println("Enter a book name to return: ");
		String bookName = sc.nextLine();
		String search = "";
		
		Book book = findBookByTitle(bookName);
		
		if(book == null) {
			System.out.println("Book was not found!!");
		}
		else if("borrowed".equalsIgnoreCase(book.getStatus())) {
			if (search.contains("Book Status: borrowed")) {
				
				System.out.println("Do you wish to Return the book Y/N ?");
				String decision = sc.next();
	
				if(decision.equalsIgnoreCase("Y") ) {
					System.out.println("Enter your username: ");
					user = sc.next();
					book.setStatus("available");
					System.out.println("You have successfully returned the book: " + bookName);
			     }
			}
		}		
		else {
			System.out.println("");
			System.out.println("Book is already available.");
		}
	}
	
	//To borrow the book using book name
	public void BorrowBook() {
		
		System.out.println("Enter a book name to borrow: ");
		String bookName = sc.nextLine();
		
		Book book = findBookByTitle(bookName);
		
		if(book == null) {
			System.out.println("Book was not found!!");
		}
		else if("available".equalsIgnoreCase(book.getStatus())) {
			
			System.out.println("Book is available to borrow.");		
			System.out.println("Do you wish to borrow Y/N ?");
			String decision = sc.next();
			
			if(decision.equalsIgnoreCase("Y") ) {
				System.out.println("Enter your username: ");
				user = sc.next();
				book.setStatus("borrowed");
				System.out.println("You have successfully borrowed the book: " + bookName);    
			}
		}
		else {
			System.out.println("");
			System.out.println("Book is already borrowed and is not available.");
		}
	}

	//To view all the books present in the library
	public void ViewBook() {
		
		System.out.println("");
		System.out.println("Books in Library");
		System.out.println("");
		if(books.isEmpty()) {
			System.out.println("There are no books added, Library is empty.");
		}
		else {
			for(Book str : books) {
				System.out.println(str);
			}
		}
	}

	// To add the books in library with the limit of 1000 and validation for empty inputs
	public void AddBook() {
		
		System.out.println("Enter details to add a book: ");
		System.out.println("");
		
		System.out.println("Please add Book ID: ");
		String bookid = sc.nextLine();
		
		if(bookid.isEmpty()) {
			System.out.println("Please enter a valid book ID");
			bookid = sc.nextLine();
		}
		else if(isBookIdExist(bookid)) {
			System.out.println("Book ID already exist, Please enter differnt ID: ");
			bookid = sc.nextLine();
		}
		
		System.out.println("Please enter book title");
		String title = sc.nextLine();
		if(title.isBlank()) {
			System.out.println("Please enter a valid title");
			title = sc.nextLine();
		}
		
		System.out.println("Please enter book author");
		String author = sc.nextLine();
		if(author.isBlank()) {
			System.out.println("Please enter a valid author");
			author = sc.nextLine();
		}
		
		System.out.println("Please enter book status:  Available or Borrowed");
		String status = sc.nextLine();
		if(status.isEmpty() || !status.equalsIgnoreCase("available") && !status.equalsIgnoreCase("borrowed")) {
			System.out.println("Please enter a valid book status");
			status = sc.nextLine();
		}
		
		Book newBook = new Book(bookid, title, author, status);
		
		if(books.size() < 1000) {
		books.add(newBook);
		System.out.println("");
		System.out.println("Book successfully added!!");
		}
		else {
			System.out.println("");
			System.out.println("Cannot add more books, library has reached it's limit of 1000 books.");
		}
	}
	
	private boolean isBookIdExist(String bookid) {
		return findBookByID(bookid) != null; 
	}
	
	private Book findBookByID(String bookid) {

		for(Book book : books) {
			if(book.getBookID().equals(bookid)){
				return book;
			}
		}
		return null;
	}
	
	private Book findBookByTitle(String title) {
	
		for(Book book : books) {
			if(book.getTitle().equalsIgnoreCase(title)){
				return book;
			}
		}
		return null;
	}
	
}
