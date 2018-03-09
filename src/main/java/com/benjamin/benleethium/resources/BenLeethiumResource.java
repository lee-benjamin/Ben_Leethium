package com.benjamin.benleethium.resources;

import com.benjamin.benleethium.models.Status;
import com.benjamin.benleethium.models.UpdateStatusRequest;
import com.benjamin.benleethium.api.ErrorResponse;
import com.benjamin.benleethium.services.TwitterService;
import com.codahale.metrics.annotation.Timed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import twitter4j.TwitterException;

@Path("/api/1.0/twitter")
@Produces(MediaType.APPLICATION_JSON)
public class BenLeethiumResource {

    final Logger logger = LoggerFactory.getLogger(BenLeethiumResource.class);
    private TwitterService twitterService;

    @Inject
    public BenLeethiumResource(TwitterService twitterService) {
        this.twitterService = twitterService;
    }

    @GET
    @Path("/timeline/user")
    @Timed
    public Response getUserTimeline() {
        try {
            List<Status> userTimelineTweets = twitterService.getUserTimeline();
            logger.debug("Got user timeline.");
            return Response.ok(userTimelineTweets).build();
        } catch (TwitterException e) {
            logger.error("Unable to fetch user timeline.", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorResponse("An error has occurred. Please try again later."))
                .build();
        }
    }

    @GET
    @Path("/timeline/home")
    @Timed
    public Response getHomeTimeline() {
        try {
            List<Status> homelineTweets = twitterService.getHomeTimeline();
            logger.debug("Got home timeline.");
            return Response.ok(homelineTweets).build();
        } catch (TwitterException e) {
            logger.error("Unable to fetch home timeline.", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorResponse("An error has occurred. Please try again later."))
                .build();
        }
    }

//    @POST
//    @Path("/tweet")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Timed
//    public Response replyToStatus(UpdateStatusRequest updateStatusRequest) throws IOException {
//        try {
//            Status status = twitterService.updateStatus(updateStatusRequest.getMessage());
//            logger.debug("Successfully posted tweet.");
//            return Response.ok(status).build();
//        } catch (TwitterException|NoSuchElementException e) {
//            logger.error("Unable to post the tweet.", e);
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
//                .entity(new ErrorResponse("An error has occurred. Please try again later."))
//                .build();
//        } catch (RuntimeException e) {
//            logger.debug(e.getMessage());
//            return Response.status(Response.Status.BAD_REQUEST)
//                 .entity(new ErrorResponse("Malformed tweet. Ensure your tweet isn't empty or exceeds " + TwitterService.MAX_CHAR_LIMIT + " characters"))
//                 .build();
//        }
//    }

    @POST
    @Path("/tweet")
    @Consumes(MediaType.APPLICATION_JSON)
    @Timed
    public Response updateStatus(UpdateStatusRequest updateStatusRequest) throws IOException {
        try {
            Status status = twitterService.updateStatus(updateStatusRequest.getMessage());
            logger.debug("Successfully posted tweet.");
            return Response.ok(status).build();
        } catch (TwitterException|NoSuchElementException e) {
            logger.error("Unable to post the tweet.", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorResponse("An error has occurred. Please try again later."))
                .build();
        } catch (RuntimeException e) {
            logger.debug(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST)
                 .entity(new ErrorResponse("Malformed tweet. Ensure your tweet isn't empty or exceeds " + TwitterService.MAX_CHAR_LIMIT + " characters"))
                 .build();
        }
    }

    @GET
    @Path("/tweet/filter")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Timed
    public Response searchHomeTimeline(@QueryParam("keyword") String keyword) {
        try {
            List<Status> searchResults = twitterService.searchHomeTimeline(keyword);
            logger.debug("Search returned.");
            return Response.ok(searchResults).build();
        } catch (TwitterException e) {
           logger.error("Unable to search for query " + keyword + ".", e);
          return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
              .entity(new ErrorResponse("An error has occurred. Please try again later."))
              .build();
        }
    }
}
