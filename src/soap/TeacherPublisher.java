package soap;

import javax.xml.ws.Endpoint;

public class TeacherPublisher {
	
	public static void main(String[] args) {
	   Endpoint.publish("http://localhost:9999/ws/school", new TeacherImpl());
    }

}
