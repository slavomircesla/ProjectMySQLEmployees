package io.dropwizard.archetypes.resources;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.archetypes.db.MySQL;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/employees")
public class Employees
{

    @POST
    @Path("/salary")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPopulation(Employer emplo)
    {
        String salary = new MySQL().getSalary(emplo.name);
        return salary;


    }

    public static class Employer
    {
        @JsonProperty("name")
        public String name ;


    }


}
