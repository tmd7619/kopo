package kr.ac.kopo.library.library;

import java.util.Date;

public class BookVO {

	private int bookNum;
	private String bookName;
	private String author;
	private String publisher;
	private Date publicDate;
	private int bookStock;
	//  날짜형 데이터 타입 지정은 어떻게?
	
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getPublicDate() {
		return publicDate;
	}
	public void setPublicDate(Date publicDate) {
		this.publicDate = publicDate;
	}
	public int getBookStock() {
		return bookStock;
	}
	public void setBookStock(int bookStock) {
		this.bookStock = bookStock;
	}

	public int plusBookStock() {
		return bookStock++;
	}
	public int minusBookStock() {
		return bookStock--;
	}
	
}
