
public class PhoneBook {

	public static void main(String[] args) {

		//create John object by calling PhoneBookEntry constructor with all parameters
		PhoneBookEntry John = new PhoneBookEntry(5, "John", "Smith", "jsmith@gmail.com", 20037, 2023334444);

		//create James object with firstName and num constructor
		PhoneBookEntry James = new PhoneBookEntry("James", 2023443444);
		
		//create Sarah object with firstName constructor
		PhoneBookEntry Sarah = new PhoneBookEntry("Sarah");
	
		//use setter to change John Smith's phone #
		John.setNum(2025555555);
		
		//print out John's info using print method
		John.printBookEntry();
		
		//set James' zip code to John's
		James.setZipCode(John.getZipCode());
		
		
		
	}

}