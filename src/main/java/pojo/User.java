package pojo;

public class User {

	private String Name;
	private String Job;
	public User(String Name, String Job)
	{
		this.Name = Name;
		this.Job = Job;
	}
	public String getName() {
		return Name;
	}
	
	public String getJob() {
		return Job;
	}
	
}
