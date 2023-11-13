package model;
import java.util.ArrayList;

/**
 * @author Mikkel
 */
public class FriendContainer
{
    private static FriendContainer instance;
    private ArrayList<Friend> friends;    
    private FriendContainer() {
        friends = new ArrayList<>();
    }
    
    public static FriendContainer getInstance() {
        if(instance == null) {
            instance = new FriendContainer();
        }
        return instance;
    }
    
    public ArrayList<Friend> findFriends(String identifier) {
        ArrayList<Friend> resultList = new ArrayList<>();
        for(Friend friend : friends) {
            if(friend.isMatch(identifier)) {
                resultList.add(friend);
            }
        }
        return resultList;
    }
    

    
    public Friend getFriend(int id) {
        Friend friend = null;
        boolean found = false;
        int i = -1;
        while(!found && ++i < friends.size()) {
            Friend currentFriend = friends.get(i);
            if(currentFriend.getId() == id) {
                friend = currentFriend;
            }
        }
        return friend;
    }
}
