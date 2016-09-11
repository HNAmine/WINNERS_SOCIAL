package org.winners.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idUser;

	@Column(name = "FIRST_NAME")
	String firstName;
	@Column(name = "LAST_NAME")
	String lastName;
	Date birth;
	boolean sexe;

	@OneToOne(mappedBy = "user")
	Compte compte;

	public User() {
	}

	public User(Long idUser, String firstName, String lastName, Date birth, boolean sexe) {
		super();
		this.idUser = idUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birth = birth;
		this.sexe = sexe;
	}

	public User(String firstName, String lastName, Date birth, boolean sexe) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birth = birth;
		this.sexe = sexe;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
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

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public boolean isSexe() {
		return sexe;
	}

	public void setSexe(boolean sexe) {
		this.sexe = sexe;
	}

	@JsonIgnore
	public Compte getCompte() {
		return compte;
	}

	@JsonSetter
	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}
