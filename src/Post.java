import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class Post {

    //static final Twitter twitterInstance = TwitterFactory.getSingleton();

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Incorrect number of arguments. Usage: java Post [tweet in quotes]");
            return;
        }

        String tweet = args[0];
        System.out.println(tweet);
    }

    public static boolean validateTweet(String tweet) {
        return true;
    }

    public static String updateStatus(String tweet) {
        if (validateTweet(tweet)) {
            //twitterInstance.updateStatus(tweet);
            return tweet;
        }
        return "Malformed tweet.";
    }

}
