package midterm;

public class Tutor {

	private static int seed = 100;
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String courseTeaching;
	
	public Tutor(String firstName, String lastName, String email, String courseTeaching){
		id = seed++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.courseTeaching = courseTeaching;
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

	public String getCourseTeaching() {
		return courseTeaching;
	}

	public void setCourseTeaching(String courseTeaching) {
		this.courseTeaching = courseTeaching;
	}
	
	
}
