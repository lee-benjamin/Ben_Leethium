# Welcome to Leethium

Have you ever wanted to send a tweet via your command line? Fetch your home timeline? Look no further-- the answers to your questions lie below.

### Add your Twitter account credentials
Create a Twitter Application at https://apps.twitter.com/app/new. You will need to create a `benleethium.yml` file and place it in the top level directory of your project. This should be the root directory after cloning this repo (next step). The file should look like `benleethium-example.yml`. For your convenience it has been pasted below:

```
twitter4jConfiguration:
    consumerKey: **********************************
    consumerSecret: **********************************
    accessToken: **********************************
    accessTokenSecret: **********************************
```
You can find these values in the settings page of your Twitter Application.

## Running with Maven

Clone this repo into the directory of your choice and run `mvn package`.

Now an fat/uber jar has been generated in the `target` directory. To start the server, run `java -jar target/Ben_Leethium-1.0=SNAPSHOT.jar server benleethium.yml`

### API Endpoints

#### Get Homeline Tweets

http://localhost:8080/api/1.0/twitter/timeline

#### Tweet a Message

http://localhost:8080/api/1.0/twitter/tweet?message=YOUR-TWEET-HERE

#### Healthcheck

http://localhost:8081/healthcheck

#### Metrics

http://localhost:8081/metrics


#### Logging

Should you want to change the logging level refer to the following example and replace the level with whatever you desire.

`java -Ddw.logging.level=DEBUG target/Ben_Leethium-1.0-SNAPSHOT.jar server benleethium.yml`

It defaults to INFO.
