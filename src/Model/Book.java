package Model;

public class Book {
	
	private int Id;
	private String BookName;
	private String Author;
	private String Sex;
	private String BookDesc;
	private float price;
	private Integer BookTypeId;
	private String BookTypeName;
	public int getId() {
		return Id;
	}
	public Book(String bookName, String author, String sex, String bookDesc, float price, int bookTypeId) {
		super();
		BookName = bookName;
		Author = author;
		Sex = sex;
		BookDesc = bookDesc;
		this.price = price;
		BookTypeId = bookTypeId;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getBookDesc() {
		return BookDesc;
	}
	public void setBookDesc(String bookDesc) {
		BookDesc = bookDesc;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Integer getBookTypeId() {
		return BookTypeId;
	}
	public void setBookTypeId(int bookTypeId) {
		BookTypeId = bookTypeId;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
