
public class User {
	protected String UserName;
	protected String password;
	protected PhoneBookDirectory book;
	
	public User() {
		book = new PhoneBookDirectory();
	}
	
	public User(String UserName, String password) {
		this.UserName = UserName;
		this.password = password;
		book = new PhoneBookDirectory();
		
	}
	
	public void setUserName(String userName) {
		UserName = userName;
	}
	
	public String getUserName() {
		return UserName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PhoneBookDirectory getBook() {
		return book;
	}

	public void setBook(PhoneBookDirectory book) {
		this.book = book;
	}
	
	public void PrintBook() {
		book.printBook();
	}
	
	public void PrintUserInfo() {
		System.out.println("Username: " + UserName);
		System.out.println("Password: " + password);
	}
	
	//add a phone entry
	public int addEntry(PhoneBookEntry entry) {
		//int successful =
		return book.addEntry(entry);
	}
	
	//edit a phone entry of a given first name and last name
	public int Edit(String firstName, String lastName) {
		return book.Edit(firstName, lastName);
	}
	
	//sort the PhoneBookDirectory
	public void sortById() {
		book.sortById();
	}
	
	//search using Linear Search
	public int LinearSearchByPhoneNumber(long PhoneNumber) {
		return book.LinearSearchByPhoneNumber(PhoneNumber);
	}
	
}
