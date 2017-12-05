package lab3;

import java.util.Date;

public class GuestBookEntry {
	static int count = 0;
	
	int id;
	String name;
	String message;
	Date created;
	
	public GuestBookEntry(int id, String name, String message){
		super();
		this.name = name;
		this.message = message;
		this.created = new Date();
		this.id = id;
	}
	
	public GuestBookEntry(String name, String message) {
		super();
		this.name = name;
		this.message = message;
		this.created = new Date();
		this.id = count++;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
}
