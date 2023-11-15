package controller;
import model.FriendContainer;
import model.Friend;
import java.util.ArrayList;

/**
 * @author Mikkel
 */
public class FriendController
{
    private FriendContainer friendContainer;
    private static FriendController instance;
    private FriendController() {
        friendContainer = FriendContainer.getInstance();
    }

    public static FriendController getInstance() {
        if(instance == null) {
            instance = new FriendController();
        }
        return instance;
    }

    /**
     * friendMatches() creates an arraylist of type string with all the friends who match the identifier
     * @param identifier to search for
     * @return An ArrayList<String> with the information strings inside. Returns empty list if no friends match the identifier. 
     */
    public ArrayList<String> friendMatches(String identifier) {
        ArrayList<String> resultingList = new ArrayList<>();
        for(Friend friend : friendContainer.findFriends(identifier)) {
            resultingList.add(friend.infoString());
        }
        return resultingList;
    }

    /**
     * friendWithIdExists() finds out if a friend with the id from parameter exists in the system
     * @param id to look for
     * @return false if no friends with that id exists true if it exists
     */
    public boolean friendWithIdExists(int id) {
        boolean success = false;
        if(friendContainer.getFriend(id) != null) {
            success = true;
        }
        return success;
    }

    public Friend getFriendFromId(int id) {
        return friendContainer.getFriend(id);
    }

    public void createFriend(String name, String address, String phone, String city, String postalCode) {
        Friend newFriend = new Friend(name, address, phone, city, postalCode);
        friendContainer.addFriend(newFriend);
    }
}