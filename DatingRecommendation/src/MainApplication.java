
public class MainApplication {

	public static void main(String[] args) {
		
		System.out.println("Hello");
		
		RecommendationEngine re = new RecommendationEngine();
		User u1 = new User("UserA", 25, Gender.Female);
		u1.addHobbi(Interest.Cricket);
		re.addUser(u1);
		User u2 = new User("UserB", 27, Gender.Male);
		u2.addHobbi(Interest.Cricket);
		u2.addHobbi(Interest.Football);
		u2.addHobbi(Interest.Movies);
		re.addUser(u2);

		User u3 = new User("UserC", 26, Gender.Male);
		u3.addHobbi(Interest.Cricket);
		u3.addHobbi(Interest.Football);
		u3.addHobbi(Interest.Movies);
		u3.addHobbi(Interest.Tennis);
		re.addUser(u3);


		User u4 = new User("UserD", 24, Gender.Female);
		u4.addHobbi(Interest.Football);
		u4.addHobbi(Interest.Badminton);
		u4.addHobbi(Interest.Tennis);
		re.addUser(u4);


		User u5 = new User("UserE", 32, Gender.Female);
		u5.addHobbi(Interest.Football);
		u5.addHobbi(Interest.Cricket);
		u5.addHobbi(Interest.Badminton);
		u5.addHobbi(Interest.Movies);
		re.addUser(u5);
		
		
		for(User u : re.getRecomndedUsers(u2, 2)) {
			System.out.println(u.name);
		}
			
	}

}
