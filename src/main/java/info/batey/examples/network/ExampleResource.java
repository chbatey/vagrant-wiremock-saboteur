package info.batey.examples.network;

import com.codahale.metrics.annotation.Timed;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/say-hello")
@Produces(MediaType.APPLICATION_JSON)
public class ExampleResource {

    private String dependencyHost;

    public ExampleResource(String dependencyHost) {
        this.dependencyHost = dependencyHost;
    }

    @GET
    @Timed
    public String sayHello() throws Exception {
        try {
            Response response = Request.Get(dependencyHost)
                    .connectTimeout(100)
                    .socketTimeout(100)
                    .execute();

            String name = response.returnContent().asString();

            return String.format("hello %s", name);
        } catch (Exception e) {
            return "Exception: " + e.getMessage();
        }
    }
}
