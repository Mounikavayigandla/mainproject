package register.bean;

public class DoctorBean {
	private String FirstName;
	private String table;
	public String getTable() {
	return table;
}
public void setTable(String table) {
	this.table = "register";
}
		public DoctorBean() {
		super();
	}
		public DoctorBean(String firstName, String lastName, int age, String gender, long contactNumber,
			String emailAddress, String city, String state, String userId, String password) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Age = age;
		Gender = gender;
		ContactNumber = contactNumber;
		EmailAddress = emailAddress;
		this.city = city;
		this.state = state;
		UserId = userId;
		Password = password;
	}
		public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public long getContactNumber() {
		return ContactNumber;
	}
	public void setContactNumber(long contactNumber) {
		ContactNumber = contactNumber;
	}
	public String getEmailAddress() {
		return EmailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
		private String LastName;
	private int Age;
	private  String Gender;
	private long ContactNumber;
	private String EmailAddress;
	private String city;
	private String state;
	private String UserId;
	private String Password;
	
	
}
