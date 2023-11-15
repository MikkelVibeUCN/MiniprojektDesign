package tui;
import controller.FriendController;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author Mikkel
 */
public class FriendUI
{
    private static FriendUI instance;
    private FriendController friendController;
    private FriendUI() {
        friendController = FriendController.getInstance();
    }

    public static FriendUI getInstance() {
        if(instance == null) {
            instance = new FriendUI();
        }
        return instance;
    }

    public int findFriendID() {
        int friendID = -1;
        Scanner keyboard = new Scanner(System.in);

        boolean isCompleted = false;
        while(!isCompleted) {
            System.out.println("Type an identifier of the friend or type \"quit\" to quit ");
            String friendIdentifier = keyboard.nextLine();
            
            if(friendIdentifier.toLowerCase().equals("quit")) {
                isCompleted = true;
            }
            else {
                ArrayList<String> friendOptions = friendController.friendMatches(friendIdentifier);
                if(friendOptions.size() > 0) {
                    System.out.println("Friend(s) matching your search: ");
                    for(String friendOption : friendOptions) {
                        System.out.println(friendOption);
                    }
                    friendID = getFriendID();
                    if(friendID == -1) {
                        System.out.println("Quitting...");
                    }
                    else {
                        System.out.println("ID selected.");
                    }
                    isCompleted = true;
                }
                else {
                    System.out.println("No friends with the identifier: " + friendIdentifier + " was found.");
                }
            }
        }
        return friendID;
    }

    private int getFriendID() {
        int id = -1;
        Scanner keyboard = new Scanner(System.in);

        boolean success = false;
        while(!success) {
            System.out.println("Select one of the friend(s) by typing their id or quit by typing \"quit\".");
            if(keyboard.hasNextInt()) {
                id = keyboard.nextInt();
                if(friendController.friendWithIdExists(id)) {
                    System.out.println("Friend with id: " + id + " was selected");
                    success = true;
                }
                else {
                    System.out.println("No friend with the id: " + id + " exists.");
                }
            }
            else if(keyboard.nextLine().equals("quit")) {
                success = true;
            }
            else {
                System.out.println("Not a valid number.");
            }
        }
        return id;
    }
    
    public void createFriend(String name, String address, String phone, String city, String postalCode) {
        friendController.createFriend(name, address, phone, city, postalCode);
    }
}