import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class Post {

    static final Twitter twitterInstance = TwitterFactory.getSingleton();
    static final int MAX_CHAR_LIMIT = 280;

    public static void main(String[] args) throws TwitterException {
        if (args.length != 1) {
            System.out.println("Incorrect number of arguments. Usage: java Post [tweet in quotes]");
            return;
        }

        String tweet = args[0];
        updateStatus(tweet);
        System.out.println(tweet);
    }

    public static boolean validateTweet(String tweet) {
        if (tweet.length() > MAX_CHAR_LIMIT) return false;
        return true;
    }

    public static String updateStatus(String tweet) throws TwitterException {
        if (validateTweet(tweet)) {
            twitterInstance.updateStatus(tweet);
            return tweet;
        }
        return "Malformed tweet, maximum character length is 280 characters.";
    }

}