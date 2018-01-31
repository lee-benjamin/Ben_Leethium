package com.benjamin.benleethium.resources;

import com.benjamin.benleethium.models.Message;
import com.benjamin.benleethium.api.ErrorResponse;
import com.benjamin.benleethium.services.TwitterService;
import com.codahale.metrics.annotation.Timed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import twitter4j.TwitterException;

@Path("/api/1.0/twitter")
@Produces(MediaType.APPLICATION_JSON)
public class BenLeethiumResource {

    final Logger logger = LoggerFactory.getLogger(BenLeethiumResource.class);
    private TwitterService twitterInstance;
    public BenLeethiumResource() {
        twitterInstance = TwitterService.getInstance();
    }

    @GET
    @Path("/timeline")
    @Timed
    public Response getHomeTimeline() {
        try {
            List<Message> homelineTweets = twitterInstance.getHomeTimeline();
            return Response.ok(homelineTweets ).build();
        } catch (TwitterException e) {
            logger.error("Unable to fetch home timeline.", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorResponse("An error has occurred. Please try again later"))
                .build();
        }
    }

    @POST
    @Path("/tweet")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Timed
    public Response updateStatus(@FormParam("message") String status) {
        try {
            Message message = twitterInstance.getInstance().updateStatus(status);
            return Response.ok(message).build();
        } catch (RuntimeException e) {
            logger.debug(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST)
                 .entity(new ErrorResponse("Malformed tweet. Ensure your tweet isn't empty or exceeds " + TwitterService.MAX_CHAR_LIMIT + " characters"))
                 .build();
        } catch (TwitterException e) {
            logger.error("Unable to post the tweet.", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorResponse("An error has occurred. Please try again later"))
                .build();
        }
    }

}
