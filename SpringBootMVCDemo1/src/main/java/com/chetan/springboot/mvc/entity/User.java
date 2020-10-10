package com.chetan.springboot.mvc.entity;



//import java.sql.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@Column
	@Size(min = 3, max = 50)
    private String name;
     
    @NotBlank
    @Email(message = "Please enter a valid e-mail address")
    private String email;
     
    @NotBlank
    @Size(min = 8, max = 15)
    private String password;
     
    @NotBlank
    private String gender;
     
    @Size(max = 100)
    private String note;
     
    @AssertTrue
    private boolean working;
     
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    //@Temporal(TemporalType.DATE)
    private Date birthday;
     
    @NotBlank
    private String profession;
 
	
		public User() {
			super();
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getProfession() {
			return profession;
		}
		public void setProfession(String profession) {
			this.profession = profession;
		}
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
		}
		public Date getBirthday() {
			return birthday;
		}
		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}
		public boolean isWorking() {
			return working;
		}
		public void setWorking(boolean working) {
			this.working = working;
		}

		@Override
		public String toString() {
			return "User [name=" + name + ", email=" + email + ", gender=" + gender + ", password=" + password
					+ ", profession=" + profession + ", note=" + note + ", working=" + working + "]";
		}
	    
	    

}
