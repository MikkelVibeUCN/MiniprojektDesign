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
    
    public ArrayList<String> friendMatches(String identifier) {
        ArrayList<String> resultingList = new ArrayList<>();
        for(Friend friend : friendContainer.findFriends(identifier)) {
            resultingList.add(friend.infoString());
        }
        return resultingList;
    }
    
}