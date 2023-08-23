package nested;

public class FriendApp {

	Friend[] friends = new Friend[10];

	class FriendExe {

		void addFriend(Friend friend) {
			for (int i = 0; i < friends.length; i++) {
				if (friends[i] == null) {
					friends[i] = friend;
					break;
				}
			}
		}

		void editFriend(Friend friend) {
			for (int i = 0; i < friends.length; i++) {
				if (friends[i] == null && friends[i].getName().equals(friend.getName())) {
					friends[i].setPhone(friend.getPhone());
					break;
				}
			}
		}
		
		void delFriend() {
			
		}//
		
	}
	
	void start() {
		FriendExe exe = new FriendExe();
		
		boolean run = true;
		while(run) {
			
		}
	} 
}
