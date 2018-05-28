
public class PhoneBookAdmin extends User implements PhoneBookAdminSettings {
	private String email;

	public PhoneBookAdmin() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//print method overrides print method in User class
	public void PrintUserInfo() {
		System.out.println("Username: " + UserName);
		System.out.println("Password: " + password);
		System.out.println("Email: " + email);
	}
	
	//inherits add, edit, sort, and search methods from User class
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
	
	//ADDED METHODS that PhoneBookAdmin DOES NOT inherit from User Class
	
	// search using Binary Search
	public PhoneBookEntry SearchIdBinarySearch(int id) {
		book.sortById();
		return book.SearchIdBinarySearch(id);
		
	}
	
	//delete by id or delete by first and last name?
		public int delete(int id) {
			return book.DeleteEntry(id);
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


	@Override
	public int delete() {
		return 0;
	}
	
}
