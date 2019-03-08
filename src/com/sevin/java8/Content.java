package com.sevin.java8;

public class Content {

	private String bookId;

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public Content() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Content(String bookId) {
		super();
		this.bookId = bookId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Content [bookId=");
		builder.append(bookId);
		builder.append("]");
		return builder.toString();
	}
}
