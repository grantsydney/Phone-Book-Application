import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class PhoneBookApplication {

	public static void main(String[] args) throws IOException, FileNotFoundException {

		Scanner user_input = new Scanner(System.in);
		int admin_count = 0;
		int user_count = 0;

		// admin file scanner and text
		Scanner readAdminFile = new Scanner(new File("src/AdminInfo.txt"));
		String AdminfileText = readAdminFile.nextLine();
		Scanner readUserFile = new Scanner(new File("src/UserInfo.txt"));
		String UserfileText = readUserFile.nextLine();

		// variables for admin login
		boolean successful = false;
		String UserName = "";
		String Password = "";
		String Email = "";

		int success; // method completed if returns 1

		// create object of type PhoneBook
		PhoneBookAdmin admin = new PhoneBookAdmin();

		// read the admin file and split up the comma separated values
		int value = 0;
		for (int i = 0; i < AdminfileText.length(); i++) {
			// first value
			if (AdminfileText.charAt(i) != ',' && value == 0) {
				UserName += AdminfileText.charAt(i);
			}
			// move onto second value
			else if (AdminfileText.charAt(i) == ',' && value == 0) {
				value = 1;
			}
			// second value
			else if (AdminfileText.charAt(i) != ',' && value == 1) {
				Password += AdminfileText.charAt(i);
			}
			// move onto third value
			else if (AdminfileText.charAt(i) == ',' && value == 1) {
				value = 2;
			}
			// third value
			else if (AdminfileText.charAt(i) != ',' && value == 2) {
				Email += AdminfileText.charAt(i);
			}

		}
		// set admins login information
		admin.setUserName(UserName);
		admin.setPassword(Password);
		admin.setEmail(Email);

		// create object of type NormalUser
		NormalUser user = new NormalUser();

		// read the user file and split up the comma separated values
		String[] words = UserfileText.split(",");
		String User_UserName = words[0];
		user.setUserName(User_UserName);
		String User_Password = words[1];
		user.setPassword(User_Password);
		int User_ID = Integer.parseInt(words[2]);
		user.setId(User_ID);

		// ask the user to login
		// check if the user is an admin or a normal user
		// display the menu accordingly.

		System.out.println("Are you an (1) admin or a (2) user? ");
		int answer = user_input.nextInt();
		if (answer == 1) {

			while (successful == false) {
				// print out menu of options
				System.out.println("Enter UserName: ");
				String userName = user_input.next();
				System.out.println("Enter password: ");
				String pswd = user_input.next();
				System.out.println("Enter email: ");
				String login_email = user_input.next();

				if (userName.equals(UserName) && pswd.equals(Password) && login_email.equals(Email)) {
					System.out.println("Login successful");
					successful = true;
					// if login successful, display menu
					do {
						System.out.println("Choose from the following menu:");
						System.out.println("1: Print User Info");
						System.out.println("2: Add Phone Book Entry");
						System.out.println("3: Edit Phone Book Entry");
//						System.out.println("4: Sort Phone Book Entries");
						System.out.println("5: Search Phone Book Entries by Phone Number"); // linear search
						System.out.println("6: Search Phone Book Entries by ID"); // binary search
						System.out.println("7: Delete Phone Book Entry");
						System.out.println("8: Change Username");
						System.out.println("9: Change Password");
						System.out.println("10: Quit");

						int choice = user_input.nextInt();
						if (choice == 1) {
							// print admin's info
							admin.PrintUserInfo();
						} else if (choice == 2) {
							if (admin_count != 6) {
								// add entry to book if it does not already contain 6 entries
								System.out.println("Enter id: ");
								int id = user_input.nextInt();
								System.out.println("Enter first name: ");
								String firstName = user_input.next();
								System.out.println("Enter last name: ");
								String lastName = user_input.next();
								System.out.println("Enter email: ");
								String email = user_input.next();
								System.out.println("Enter zip code: ");
								int zipCode = user_input.nextInt();
								System.out.println("Enter phone number: ");
								long num = user_input.nextLong();
								PhoneBookEntry entry = new PhoneBookEntry(id, firstName, lastName, email, zipCode, num);
								admin.addEntry(entry);
								System.out.println("Add Successful!");
								admin_count++;
							} else {
								System.out.println("Phonebook full!");
							}

						} else if (choice == 3) {
							if (admin_count <= 0) {
								System.out.println("No entries to edit");
							} else {
							// edit an entry using first and last name
							System.out.println("Enter the first name of the entry you would like to edit: ");
							String fn = user_input.next();
							System.out.println("Enter the last name of the entry you would like to edit: ");
							String ln = user_input.next();
							success = admin.Edit(fn, ln);
							if (success == 1) {
								System.out.println("Entry edited");
							} else {
								System.out.println("Entry not edited");
							}
							}

						} else if (choice == 4) {
							if (admin_count <= 0) {
								System.out.println("No entries to sort");
							} else {
								// sort phone book entries
								admin.sortById();
							}
						} else if (choice == 5) {
							if (admin_count <= 0) {
								System.out.println("No entries to seaerch for");
							} else {
								// Search Phone Book Entries by Phone Number--linear search
								System.out.println("Enter Phone Number you'd like to search for: ");
								long NumLinSearch = user_input.nextLong();
								success = admin.LinearSearchByPhoneNumber(NumLinSearch);
								if (success == 1) {
									System.out.println("Phone number found!");
								} else {
									System.out.println("Sorry, but that phone number does not match any entries");
								}
							}

						} else if (choice == 6) {
							// Search Phone Book Entries by ID--binary search
							if (admin_count <= 0) {
								System.out.println("No entries to search for");
							} else {
								System.out.println("Enter ID you'd like to search for: ");
								int IDBinarySearch = user_input.nextInt();
								PhoneBookEntry foundEntry = admin.SearchIdBinarySearch(IDBinarySearch);
								System.out.println(foundEntry);
							}
						} else if (choice == 7) {
							// Delete Phone Book Entry
							if (admin_count <= 0) {
								System.out.println("No entries to delete");
							} else {
								System.out.println("Enter ID of entry you would like to delete: ");
								int idDelete = user_input.nextInt();
								success = admin.delete(idDelete);
								if (success == 1) {
									admin_count--;
									System.out.println("Entry deleted");
								} else {
									System.out.println("Entry not deleted");
								}
							}
						} else if (choice == 8) {
							// Change Username
							System.out.println("Enter new username: ");
							String newUsername = user_input.next();
							admin.setUserName(newUsername);
							System.out.println("New UserName is " + admin.getUserName());
						} else if (choice == 9) {
							// Change Password
							System.out.println("Enter new password: ");
							String nPswd = user_input.next();
							admin.setPassword(nPswd);
							System.out.println("New Password is " + admin.getPassword());
						} else if (choice == 10) {
							System.out.println("Goodbye!");
							break;
						}

					} while (answer != 10);
				} else {
					System.out.println("Try again!");
					successful = false;
				}
			}

		} else if (answer == 2) {
			while (successful == false) {
				// print out menu of options
				System.out.println("Enter UserName: ");
				String userName = user_input.next();
				System.out.println("Enter password: ");
				String pswd = user_input.next();
				System.out.println("Enter ID: ");
				int id = user_input.nextInt();

				if (userName.equals(User_UserName) && pswd.equals(User_Password) && id == User_ID) {
					System.out.println("Login successful");
					successful = true;
					// if login successful, display menu
					do {
						System.out.println("Choose from the following menu:");
						System.out.println("1: Print User Info");
						System.out.println("2: Add Phone Book Entry");
						System.out.println("3: Edit Phone Book Entry");
//						System.out.println("4: Sort Phone Book Entries");
						System.out.println("5: Search Phone Book Entries by Phone Number");
						System.out.println("6: Quit");

						int choice = user_input.nextInt();
						// print out user's info
						if (choice == 1) {
							user.PrintUserInfo();
						} else if (choice == 2) {
							// add entry to book if entry count does not = 6
							if (user_count != 6) {
								System.out.println("Enter id: ");
								int Uid = user_input.nextInt();
								System.out.println("Enter first name: ");
								String firstName = user_input.next();
								System.out.println("Enter last name: ");
								String lastName = user_input.next();
								System.out.println("Enter email: ");
								String email = user_input.next();
								System.out.println("Enter zip code: ");
								int zipCode = user_input.nextInt();
								System.out.println("Enter phone number: ");
								long num = user_input.nextLong();
								PhoneBookEntry entry = new PhoneBookEntry(Uid, firstName, lastName, email, zipCode,
										num);
								user.addEntry(entry);
								System.out.println("Add Successful!");
								user_count++;
							} else {
								System.out.println("Sorry, phone book full!");
							}
						} else if (choice == 3) {
							if (user_count <= 0) {
								System.out.println("No entries edit");
							} else {
							// edit entry with first and last name
							System.out.println("Enter the first name of the entry you would like to edit: ");
							String fn = user_input.next();
							System.out.println("Enter the last name of the entry you would like to edit: ");
							String ln = user_input.next();
							success = user.Edit(fn, ln);
							if (success == 1) {
								System.out.println("Entry edited");
							} else {
								System.out.println("Entry not edited");
							}
							}
						} else if (choice == 4) {
							if (user_count <= 0) {
								System.out.println("No entries to sort");
							} else {
							// sort phone book entries
							user.sortById();
							}
						} else if (choice == 5) {
							if (admin_count <= 0) {
								System.out.println("No entries to search for");
							} else {
							// Search Phone Book Entries by Phone Number--linear search
							System.out.println("Enter Phone Number you'd like to search for: ");
							long NumLinSearch = user_input.nextLong();
							success = user.LinearSearchByPhoneNumber(NumLinSearch);
							if (success == 1) {
								System.out.println("Phone number found!");
							} else {
								System.out.println("Sorry, but that phone number does not match any entries");
							}
							}
						} else if (choice == 6) {
							// exit program
							System.out.println("Goodbye!");
							break;
						}
					} while (answer != 6);
				} else {
					System.out.println("Try again!");
					successful = false;
				}

			}
		}

		// end of file--close Scanners
		readUserFile.close();
		readAdminFile.close();
		user_input.close();
	}
}