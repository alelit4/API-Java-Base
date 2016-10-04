package cryptull.restserver.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Doctor {
	
	public String id;
	
	public Doctor() {
		
	}
	
	public Doctor(String id) {
		this.id = id;
	}
}
