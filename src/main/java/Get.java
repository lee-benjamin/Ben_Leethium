import twitter4j.Twitter;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.List;

public class Get {

    static final Twitter twitterInstance = TwitterFactory.getSingleton();
    static final int MIN_TWEETS = 3;

    public static void main(String[] args) throws TwitterException {
        if (args.length > 0) {
            System.out.println("Incorrect number of arguments. Usage: java Get");
            return;
        }
        printHomeTimeline();
    }

    public static void printHomeTimeline() throws TwitterException {
        List<Status> statuses = twitterInstance.getHomeTimeline();
        if (statuses.size() < MIN_TWEETS) {
            System.out.println("Less than 3 tweets on Home Timeline. Aborting.");
            return;
        }

        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ": " +
                               status.getText());
        } 
    }
}
