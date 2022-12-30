package tn.essat.response;

import java.util.List;

import tn.essat.model.Role;

public class Authresponse {
	private Integer id;
	private String nom;
	private String email;
	private String username;
	private String organisation;
	private String Token;
	private List<Role> role;
	
	public Authresponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Authresponse(Integer id, String nom, String email, String username, String organisation,
			String token, List<Role> role) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.username = username;
		this.organisation = organisation;
		Token = token;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}
	

}
