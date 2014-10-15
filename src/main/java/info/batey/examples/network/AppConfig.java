package info.batey.examples.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class AppConfig extends Configuration {
    @JsonProperty
    @NotEmpty
    private String host;

    public String getHost() {
        return host;
    }
}
