package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="teacher")
@XmlAccessorType(XmlAccessType.FIELD)
public class Teacher {

	@XmlAttribute(required=true)
	protected long id;
	
	@XmlAttribute(required=true)
	protected String firstName;
	
	@XmlAttribute(required=true)
	protected String lastName;
	
	public Teacher() { }
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
