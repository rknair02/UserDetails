package com.abn.db.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue
	private int Id;

	@NotEmpty(message = "please enter valid First name")
	private String first_name;

	@NotEmpty(message = "please enter valid Last name")
	private String last_name;

	@NotEmpty(message = "please enter valid Date")
	private String birthDate;

	private String Gender;

	@NotEmpty(message = "Please enter a valid email")
	private String email;

	private String hobbies;
	
	private String creation_datetime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());

	public Person() {

	}

	public Person(String first_name, String last_name, String gender, String birthDate, String email, String hobbies) {
		super();

		this.first_name = first_name;
		this.last_name = last_name;
		this.birthDate = birthDate;
		this.email = email;
		this.hobbies = hobbies;
		Gender = gender;
	}

	public Person(int id) {
		super();
		Id = id;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Person(int Id, String first_name, String last_name, String gender, String birthDate, String email,
			String hobby) {
		super();
		this.Id = Id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.birthDate = birthDate;
		this.email = email;
		this.hobbies = hobby;
		Gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobby) {
		this.hobbies = hobby;
	}

	public String getCreation_datetime() {
		return creation_datetime;
	}

	public void setCreation_datetime(String creation_datetime) {
		this.creation_datetime = creation_datetime;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	@Override
	public String toString() {
		return "Person [email=" + email + ", first_name=" + first_name + ", last_name=" + last_name + ", birthDate="
				+ birthDate + ", hobbies=" + hobbies + ", creation_datetime=" + creation_datetime + ", Gender=" + Gender
				+ "]";
	}

}