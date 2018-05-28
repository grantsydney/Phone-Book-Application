
public class PhoneBookEntry {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private int zipCode;
	private long num;
	
	//default constructor
	public PhoneBookEntry() {
		
	}
	//constructor that takes in all attributes
	public PhoneBookEntry(int id, String firstName, String lastName, String email, int zipCode, long num) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.zipCode = zipCode;
		this.num = num;
		
	}
	//Constructor that takes in firstName and num
	public PhoneBookEntry(String firstName, long num) {
		this.firstName = firstName;
		this.num = num;
	}
	
	//constructor that take in firstName
	public PhoneBookEntry(String firstName) {
		this.firstName = firstName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}
	//method to print out PhoneBookEntry
	public void printBookEntry() {
		System.out.println(firstName+ "\t" + lastName);
		System.out.println("ID: " + id);
		System.out.println((num / 10000000) + "-" + (num % 10000000));
		System.out.println("Email: " + email);
		System.out.println("Zip Code: " + zipCode);
	}

}
