package com.benjamin.benleethium.resources;

import com.benjamin.benleethium.api.TwitterResponse;
import com.benjamin.benleethium.Get;
import com.benjamin.benleethium.Post;
import com.codahale.metrics.annotation.Timed;

import twitter4j.TwitterException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class BenLeethiumResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public BenLeethiumResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public TwitterResponse getHomeTimeline(@QueryParam("name") Optional<String> name) throws TwitterException {
        //final String value = String.format(template, name.orElse(defaultName));
        final String value = Get.main(new String[0]);
        // construct new Response object with TwitterResponse inside
        // return back Response
        // point of Response is so we can set the HTTP status code ourself
        
        return new TwitterResponse(counter.incrementAndGet(), value);
    }
}
