import java.util.Scanner;

public class PhoneBookDirectory {

	Scanner input = new Scanner(System.in);

	// an array of PhoneBookEntries
	private PhoneBookEntry[] book;
	private int count;

	// Creates an empty PhoneBook object.
	public PhoneBookDirectory() {
		book = new PhoneBookEntry[6];
		count = 0;
	}

	// Adds the entry into the current object
	public int addEntry(PhoneBookEntry entry) {
		if (count == 6) {
			return 0;
		} else {

			book[count] = entry;
			count++;
			return 1;
		}
	}

	// Prints out the entire object.
	public void printBook() {
		for (int i = 0; i < book.length; i++) {
			if (book[i] != null) {
				System.out.print(i + ":");
				book[i].printBookEntry();
			}
		}
	}

	//search for entry by phone number (linear search)
	public int LinearSearchByPhoneNumber(long PhoneNumber) {
		for (int i = 0; i < book.length; i++) {
			if (book[i].getNum() == PhoneNumber) {
				return 1;
			}
		}
		return 0;
	}

	// sort method (sort entries by id)
	public void sortById() {
		int minimumId;
		int mIndex;
		for (int i = 0; i < book.length; i++) {
			minimumId = book[i].getId();
			mIndex = i;
			for (int j = i + 1; j < book.length; j++) {
				if (book[j].getId() < minimumId) {
					minimumId = book[j].getId();
					mIndex = j;
				}
			}
			if (mIndex != i) {
				PhoneBookEntry temp = book[i]; 
				book[i] = book[mIndex];
				book[mIndex] = temp;
			}
		}
	}

	// binary search (search for entry with id)
	public PhoneBookEntry SearchIdBinarySearch(int id) {
		int low = 0;
		int high = book.length - 1;
		int mid = (low + high / 2);
		if (id < book[mid].getId()) {
			high = mid -1;
		} else if (id == book[mid].getId()) {
			return book[mid];
		} else {
			low = mid + 1;
		} return null;
		
	}

	// edit an entry
	public int Edit(String firstName, String lastName) {
		for (int i = 0; i < book.length; i++) {
			if (book[i].getFirstName().equals(firstName) && book[i].getLastName().equals(lastName)) {
				System.out.println(
						"Do you want to change (1) first name, (2) last name, (3) id, (4) email, (5) zip code, (6) phone number");
				int choice = input.nextInt();
				if (choice == 1) {
					System.out.println("New name: ");
					String name = input.next();
					book[i].setFirstName(name);
				} else if (choice == 2) {
					System.out.println("New last name: ");
					String name = input.next();
					book[i].setLastName(name);
				} else if (choice == 3) {
					System.out.println("New ID: ");
					int id = input.nextInt();
					book[i].setId(id);
				} else if (choice == 4) {
					System.out.println("New Email: ");
					String email = input.next();
					book[i].setEmail(email);
				} else if (choice == 5) {
					System.out.println("New Zip Code");
					int zipCode = input.nextInt();
					book[i].setZipCode(zipCode);
				} else if (choice == 6) {
					System.out.println("New Phone Number: ");
					long num = input.nextLong();
					book[i].setNum(num);
				} return 1;
			}
			
		} return 0;
	}

	//delete an entry of a given id
	public int DeleteEntry(int id) {
		for (int i = 0; i < book.length; i++) {
			if (book[i].getId() == id) {
				book[i].setId(0);
				book[i].setFirstName(null);
				book[i].setLastName(null);
				book[i].setId(0);
				book[i].setEmail(null);
				book[i].setZipCode(0);
				book[i].setNum(0);
				return 1;
			}
		}
		return 0;
	}

}
