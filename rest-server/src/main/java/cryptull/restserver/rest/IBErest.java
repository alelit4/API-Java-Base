package cryptull.restserver.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cryptull.restserver.model.Doctor;


@Path("/setup")
public class IBErest {
	
	private static final String TEMPLATE = "ID, %s!";
	
	@GET
	@Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Doctor setUp(@PathParam("id") String id) {		
		return new Doctor(String.format(TEMPLATE, id));
    }
}
