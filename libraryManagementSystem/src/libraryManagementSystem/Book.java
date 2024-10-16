package libraryManagementSystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Book {

	private String bookid, title, author, status, timeStamp;
	
	public Book(String bookid, String title, String author, String status) {
		this.bookid = bookid;
		this.title = title;
		this.author = author;
		this.status = status;
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		this.timeStamp = dateTime.format(formatter);
	}
	
	public String getBookID() {
		return bookid;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getTimeStamp() {
		return timeStamp;
	}
	
	@Override
	public String toString() {
		return "BookId: " + bookid + "," + " Title: " + title + "," + " Author: " + author + "," + 
				" Book Status: " + status + "," + " Date Added: " + timeStamp;
	}
	
	
}
