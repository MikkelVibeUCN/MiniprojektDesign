package model;
import java.util.ArrayList;

/**
 * @author Mikkel
 */
public class FriendContainer
{
    private ArrayList<Friend> friends;    
    private static FriendContainer instance;

    private FriendContainer() {
        friends = new ArrayList<>();
    }

    public static FriendContainer getInstance() {
        if(instance == null) {
            instance = new FriendContainer();
        }
        return instance;
    }

    /**
     * findFriends() finds objects of type Friend who have at least one attribute matching the parameter
     * @param identifier is the search criteria in String form
     * @return returns an ArrayList of friends who all have at least one attribute matching the parameter
     */
    public ArrayList<Friend> findFriends(String identifier) {
        ArrayList<Friend> resultList = new ArrayList<>();
        for(Friend friend : friends) {
            if(friend.isMatch(identifier)) {
                resultList.add(friend);
            }
        }
        return resultList;
    }

    /**
     * getFriend() gets the friend from ID
     * @param id to search for
     * @return returns a Friend object with the id given in parameter
     */
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

    public void addFriend(Friend friend) {
        friends.add(friend);
    }
}
