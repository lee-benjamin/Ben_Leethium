# Welcome to Leethium 

Have you ever wanted to send a tweet via your command line? Fetch your home timeline? Look no further-- the answers to your questions lie below.

# Compile and Set-Up

After cloning this repo into the directory of your choosing, run `javac *.java`.

Create a Twitter Application. You will need a `twitter4j.properties` file in the same directory. It should look like this:

```
oauth.consumerKey=""
oauth.consumerSecret=""
oauth.accessToken=""
oauth.accessTokenSecret=""
```
You can find these values in the settings page of your Twitter Application.

# Status Update

To send a tweet run `java Post [tweet]`.

# Get Home Timeline

To get your home timeline, run `java Get`.

