package cryptull.resttest;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.junit.Before;
import org.junit.Test;

import cryptull.restserver.model.Doctor;

public class RestServiceTest {

	private static final String TARGET_URI = "http://localhost:8080/setup";
	private static final String ID = "12345";
	private static final String EXPECTED = "ID, " + ID + "!";
	private static final String EXPECTED_JSON = "{\"id\":\"" + EXPECTED + "\"}";
	
	private WebTarget target;
	
	@Before
	public void setUp() {
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(JacksonFeature.class);
		Client client = ClientBuilder.newClient(clientConfig);
		
		target = client.target(TARGET_URI);
	}
	
	@Test
	public void testSetUJson() {
			
		String result = (String) target.path(ID).request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
		
		assertThat(result, is(equalTo(EXPECTED_JSON)));
	}
	
	@Test
	public void testDoctorObject() {
		Doctor result = (Doctor) target.path(ID).request(MediaType.APPLICATION_JSON_TYPE).get(Doctor.class);
		
		assertThat(result.id, is(equalTo(EXPECTED)));
	}
	
}
