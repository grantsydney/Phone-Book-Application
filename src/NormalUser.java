
public class NormalUser extends User implements NormalUserSettings {

	private int id;
	protected PhoneBookDirectory book;
	
	public NormalUser() {
		
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PhoneBookDirectory getBook() {
		return book;
	}

	public void setBook(PhoneBookDirectory book) {
		this.book = book;
	}

	public int Edit(String firstName, String lastName) {
		super.Edit(firstName, lastName);
		return 1;
	}
	public void sortById() {
		
		super.sortById();
		
	}
	public int LinearSearchByPhoneNumber(long PhoneNumber) {
		
		super.LinearSearchByPhoneNumber(PhoneNumber);
		
		return 1;
	}

	
	public int addEntry(PhoneBookEntry entry) {
		
		super.addEntry(entry);
		
		
		return 1;
	}
	
	//inherits add, edit, sort, and search methods from User class
	
	//Print user's info (overrides print method in User class)
	public void PrintUserInfo() {
		System.out.println("Username: " + UserName);
		System.out.println("Password: " + password);
		System.out.println("ID: " + id);
	}


	@Override
	public int addEntry() {
		return 0;
	}


	@Override
	public int Edit() {
		return 0;
	}


	@Override
	public int LinearSearchByPhoneNumber() {
		return 0;
	}
	
}
