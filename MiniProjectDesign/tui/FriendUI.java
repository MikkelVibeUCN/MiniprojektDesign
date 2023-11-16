package tui;
import controller.FriendController;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * FriendUI holder styr på alt UI som har med Friend at gøre.
 * @author Mikkel
 */
public class FriendUI
{
    private FriendController friendController;
    private static FriendUI instance;

    private FriendUI() {
        friendController = FriendController.getInstance();
    }

    public static FriendUI getInstance() {
        if(instance == null) {
            instance = new FriendUI();
        }
        return instance;
    }
    /**
     * findFriendID() directs the user into finding the Friend who wants to loan
     * @return returns the id of the friend or -1 if the friend is not found or if the method is quit.
     */
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
                    friendID = selectFriendID();
                    if(friendID == -1) {
                        System.out.println("Quitting...");
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
    
    /**
     * selectFriendID() is a helper method that helps the user select the friend
     * @return returns the id of the friend or -1 if the method is either abandonded or if no friend with the id exists
     */
    private int selectFriendID() {
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