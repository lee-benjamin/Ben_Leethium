# Welcome to Leethium

Have you ever wanted to send a tweet via your command line? Fetch your home timeline? Look no further-- the answers to your questions lie below.

## Compile and Set-Up

This set-up assumes you are on a \*nix machine. For Windows users, use the `set` command to set your classpath instead of `export`.

### Download twitter4j

[Twitter4j](http://twitter4j.org/en/) is an open-source unofficial Java library for the Twitter API. Download the latest stable version. In the directory where you have unzipped the archive run this command: 

`export CLASSPATH=$CLASSPATH:~/path/to/twitter4j/twitter4j-core-XXX.jar`. 

Be sure to fill in the version number and the path to twitter4j.

### Download Java source

After cloning this repo into the directory of your choosing, run `javac *.java`.

If you want to run the program outside the directory in which you have compiled the java files run the following command:

`export CLASSPATH=$CLASSPATH:~/path/to/src/Post.class:~/path/to/src/Get.class`

### Add your Twitter account credentials
Create a Twitter Application at https://apps.twitter.com/app/new. You will need to create a `twitter4j.properties` file and place it inside `src/`, at the same level as the java files. It should look like this:

```
oauth.consumerKey=****
oauth.consumerSecret=******
oauth.accessToken=********
oauth.accessTokenSecret=******
```
You can find these values in the settings page of your Twitter Application.
## How to Run 

### Status Update

To send a tweet run `java Post [tweet]`.

### Get Home Timeline

To get your home timeline, run `java Get`.
