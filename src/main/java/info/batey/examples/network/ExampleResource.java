package info.batey.examples.network;

import com.codahale.metrics.annotation.Timed;
import org.apache.http.client.fluent.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/say-hello")
@Produces(MediaType.APPLICATION_JSON)
public class ExampleResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleResource.class);

    private String dependencyHost;

    public ExampleResource(String dependencyHost) {
        this.dependencyHost = dependencyHost;
    }

    @GET
    @Timed
    public Response sayHello() throws Exception {
        try {
            String name = Request.Get(dependencyHost)
                    .execute()
                    .returnContent()
                    .asString();

            return Response.ok(String.format("hello %s\n\n", name)).build();

        } catch (Exception e) {
            LOGGER.info("Darn blast", e);
            return Response.serverError().build();
        }
    }
}
