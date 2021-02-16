package Model;

public class BookType {

	private int id;
	private String BookTypeName;
	private String BookTypeDesc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookTypeName() {
		return BookTypeName;
	}
	public void setBookTypeName(String bookTypeName) {
		BookTypeName = bookTypeName;
	}
	public String getBookTypeDesc() {
		return BookTypeDesc;
	}
	public void setBookTypeDesc(String bookTypeDesc) {
		BookTypeDesc = bookTypeDesc;
	}
	public BookType() {
		
	}
	public BookType(String bookTypeName, String bookTypeDesc) {
		super();
		BookTypeName = bookTypeName;
		BookTypeDesc = bookTypeDesc;
	} 
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return BookTypeName;
	}
	
}
