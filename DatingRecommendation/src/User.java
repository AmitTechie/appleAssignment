import java.util.HashSet;
import java.util.Set;

public class User {
	
	
	String name;
	int age;
	Gender gender;
	Set<Interest> hobbies;
	public User(String name, int age, Gender gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		hobbies = new HashSet<Interest>();
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public Gender getGender() {
		return gender;
	}
	public Set<Interest> getHobbies() {
		return hobbies;
	}
	public void setHobbies(Set<Interest> hobbies) {
		this.hobbies = hobbies;
	}	
	public void addHobbi(Interest hobbi) {
		this.hobbies.add(hobbi);
	}	
	
}
