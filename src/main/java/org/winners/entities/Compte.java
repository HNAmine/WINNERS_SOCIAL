package org.winners.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.winners.enumerations.Activity;
import org.winners.enumerations.Visiblite;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Compte implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idCompte;

	String login;
	@Column(unique = true)
	String email;
	String password;
	Date created;

	Visiblite visiblite;
	Activity activity;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	User user;

	public Compte() {
	}

	public Compte(String email, String password, Date created) {
		super();
		this.email = email;
		this.password = password;
		this.created = created;
	}

	public Compte(Long idCompte, String email, String password, Date created) {
		super();
		this.idCompte = idCompte;
		this.email = email;
		this.password = password;
		this.created = created;
	}

	@ApiModelProperty(position = 1, required = true, value = "Compte Id")
	public Long getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}

	@ApiModelProperty(position = 2, required = true, value = "Compte Email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ApiModelProperty(position = 3, required = true, value = "Compte Password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@ApiModelProperty(position = 4, required = true, value = "Compte created dtae")
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@ApiModelProperty(position = 5, required = true, value = "Compte Visibilite")
	public Visiblite getVisiblite() {
		return visiblite;
	}

	public void setVisiblite(Visiblite visiblite) {
		this.visiblite = visiblite;
	}

	@ApiModelProperty(position = 6, required = true, value = "User")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ApiModelProperty(position = 7, required = true, value = "Compte Activity")
	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	@ApiModelProperty(position = 8, required = true, value = "Compte Login")
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
