# Welcome to Leethium

Have you ever wanted to send a tweet via your command line? Fetch your home timeline? Look no further-- the answers to your questions lie below.

### Add your Twitter account credentials
Create a Twitter Application at https://apps.twitter.com/app/new. You will need to create a `twitter4j.properties` file and place it in the top level directory of your project. This should be the root directory after cloning this repo (next step). The file should look like this:

```
oauth.consumerKey=****
oauth.consumerSecret=******
oauth.accessToken=********
oauth.accessTokenSecret=******
```
You can find these values in the settings page of your Twitter Application.

## Running with Maven

Clone this repo into the directory of your choice and run `mvn package`.

Now an uber jar has been generated in the `target` directory. To get your home timeline tweets, run `java -cp target/Ben_Leethium-XXX.jar Get`.

