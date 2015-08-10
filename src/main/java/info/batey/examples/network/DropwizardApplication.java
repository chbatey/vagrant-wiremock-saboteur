package info.batey.examples.network;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropwizardApplication extends Application<AppConfig> {
    public static void main(String[] args) throws Exception {
        new DropwizardApplication().run(args);
    }

    @Override
    public String getName() {
        return "example-app";
    }

    @Override
    public void initialize(Bootstrap<AppConfig> bootstrap) {

    }

    @Override
    public void run(AppConfig configuration,
                    Environment environment) {
        environment.jersey()
                   .register(new ExampleResource(configuration));
    }
}
