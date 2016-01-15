package soap;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface Teacher {

	@WebMethod String addTeacher(
			@WebParam(name="firstName") String firstName, 
			@WebParam(name="lastName") String lastName);
	
	@WebMethod ArrayList<models.Teacher> getTeachers(@WebParam(name="getAll") String getAll);
	
}
