package io.dropwizard.archetypes;

import io.dropwizard.Application;
import io.dropwizard.archetypes.resources.Employees;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class EmplserverApplication extends Application<EmplserverConfiguration> {

    public static void main(final String[] args) throws Exception {
        new EmplserverApplication().run(args);
    }

    @Override
    public String getName() {
        return "Emplserver";
    }

    @Override
    public void initialize(final Bootstrap<EmplserverConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final EmplserverConfiguration configuration,
                    final Environment environment) {

        environment.jersey().register(new Employees());

    }

}
