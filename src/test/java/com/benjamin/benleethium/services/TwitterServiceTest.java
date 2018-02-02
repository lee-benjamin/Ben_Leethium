import org.junit.jupiter.api.Test;
import org.junit.Assert;

import com.benjamin.benleethium.services.TwitterService;

import twitter4j.Twitter;

@RunWith(MockitoJUnitRunner.class)
public class TwitterServiceTest {

    @Mock
    Twitter twitterInstance;

    @InjectMocks
    TwitterService twitterServiceInstance;

    @Test
    void testGetInstance() {
        twitterServiceInstance.getInstance();


    }

    @Test
    void testValidateTweet() {
    }

    @Test
    void testUpdateStatus() {
    }

    @Test
    void testGetHomeTimeline() {
    }

    @Test
    void searchHomeTimeline() {
    }
}
