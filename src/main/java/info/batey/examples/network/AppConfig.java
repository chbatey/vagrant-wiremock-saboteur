package info.batey.examples.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;

public class AppConfig extends Configuration {
    @JsonProperty
    @NotEmpty
    private String host;

    @Min(1024)
    private int httpPort;

    @Min(1024)
    private int cassandraPort;

    public String getHost() {
        return host;
    }

    public int getHttpPort() {
        return httpPort;
    }

    public int getCassandraPort() {
        return cassandraPort;
    }
}
