package info.batey.examples.network;

import com.codahale.metrics.annotation.Timed;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.SocketOptions;
import com.datastax.driver.core.exceptions.NoHostAvailableException;
import com.datastax.driver.core.exceptions.ReadTimeoutException;
import org.apache.http.client.fluent.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/say-hello")
@Produces(MediaType.APPLICATION_JSON)
public class ExampleResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleResource.class);

    private final String dependencyHost;

    public ExampleResource(AppConfig config) {
        this.dependencyHost = String.format("http://%s:%d/name", config.getHost(), config.getHttpPort());
    }

    @GET
    @Timed
    public Response sayHello() throws Exception {
        try {
            String name = Request.Get(dependencyHost)
                    .socketTimeout(500)
                    .execute()
                    .returnContent()
                    .asString();

            return Response.ok(String.format("hello %s \n\n", name)).build();
        }
        catch (Exception e) {
            LOGGER.error("Darn blast I have NO idea what to do :-/", e);
            return Response.serverError().build();
        }
    }
}
