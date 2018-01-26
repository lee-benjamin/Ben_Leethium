package com.benjamin.benleethium.resources;

import com.benjamin.benleethium.api.GetResponse;
import com.benjamin.benleethium.api.PostResponse;
import com.benjamin.benleethium.Get;
import com.benjamin.benleethium.Post;
import com.codahale.metrics.annotation.Timed;

import twitter4j.TwitterException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/api/1.0/twitter")
@Produces(MediaType.APPLICATION_JSON)
public class BenLeethiumResource {
    private final String template;

    public BenLeethiumResource(String template) {
        this.template = template;
    }

    @GET
    @Path("/timeline")
    @Timed
    public GetResponse getHomeTimeline() throws TwitterException {
        final List<String> homelineTweets = Get.getHomeTimeline();
        // construct new Response object with TwitterResponse inside
        // return back Response
        // point of Response is so we can set the HTTP status code ourself
        
        return new GetResponse(homelineTweets);
    }

    @POST
    @Path("/tweet")
    @Timed
    public PostResponse updateStatus(@QueryParam("message") String message) throws TwitterException {
        final String status = Post.updateStatus(message);
        return new PostResponse(status);
    }

}
