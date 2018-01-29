package com.benjamin.benleethium.resources;

import com.benjamin.benleethium.Get;
import com.benjamin.benleethium.Post;
import com.codahale.metrics.annotation.Timed;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/1.0/twitter")
@Produces(MediaType.APPLICATION_JSON)
public class BenLeethiumResource {

    public BenLeethiumResource() {}

    @GET
    @Path("/timeline")
    @Timed
    public Response getHomeTimeline() {
        return Get.getHomeTimeline();
    }

    @POST
    @Path("/tweet")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Timed
    public Response updateStatus(@FormParam("message") String message) {
        return Post.updateStatus(message);
    }

}
