
public interface PhoneBookAdminSettings {
	
	public abstract int addEntry();
	public abstract int Edit();
	public abstract void sortById();
	public abstract int LinearSearchByPhoneNumber();
	public abstract void PrintUserInfo();
	public abstract PhoneBookEntry SearchIdBinarySearch(int id);
	public abstract int delete();
	
}