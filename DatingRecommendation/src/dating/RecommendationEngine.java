package dating;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class RecommendationEngine {
	
	public List<User> femaleData;
	public List<User> maleData;
	
	
	
	
	
	public RecommendationEngine() {
		super();
		femaleData = new ArrayList<User>();
		maleData = new ArrayList<User>();
	}
	
	public boolean addUser(User user) {
		if (user == null) {
			return false;
		}
		
		if (user.gender == Gender.Male) {
			maleData.add(user);
		}else {
			femaleData.add(user);
		}
		
		return true;
	}

	public List<User> getRecomndedUsers(User user, int matchCount){
		
			if (user == null  || matchCount <=0 ) {
				return null;
			}
			
			if (user.gender == Gender.Male) {
				return getRecomndedUsersList(user, femaleData, matchCount);				
			}
			return getRecomndedUsersList(user, maleData, matchCount);
						
	}
	
	
	public List<User> getRecomndedUsersList(User user, List<User> users, int matchCount){
		
		if (user == null  || matchCount <=0 ) {
			return null;
		}
		
		List<User> result = new ArrayList<>();
		
		
		PriorityQueue<User> matchQ = new PriorityQueue<User>((a, b) -> user.hobbies.stream().filter(a.hobbies::contains).count() == user.hobbies.stream().filter(b.hobbies::contains).count() ?
				 Math.abs(user.age - a.age) -  Math.abs(user.age - b.age) : (user.hobbies.stream().filter(a.hobbies::contains).count() > user.hobbies.stream().filter(b.hobbies::contains).count()) ? Math.abs(user.age - a.age) - Math.abs(user.age - b.age) : Math.abs(user.age - b.age) - Math.abs(user.age - a.age));
			
		
		
		for (User u : users) {
			matchQ.offer(u);
		}
		
		
		int i = 0;
		while(!matchQ.isEmpty()) {
			
			result.add(matchQ.poll());
			i++;
			if (i== matchCount) {
				break;
			}
		}
		
		return result;
	
}
	
	

}
