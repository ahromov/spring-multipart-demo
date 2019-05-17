package ua.lviv.lgs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	private String firstName;
	private String lastName;
	private Integer age;

	@OneToOne
	@JoinColumn(name = "photo_id")
	private Photo file;

	public User() {
	}

	public User(String firstName, String lastName, Integer age, Photo file) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.file = file;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Photo getFile() {
		return file;
	}

	public void setFile(Photo file) {
		this.file = file;
	}

}
