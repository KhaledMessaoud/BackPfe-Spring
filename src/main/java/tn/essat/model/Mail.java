package tn.essat.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Mail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String sujet;
	private String contenu;
	@ManyToOne
	@JoinColumn(name = "user_send_id")
	private User user_send;
	@ManyToOne
	@JoinColumn(name = "user_receive_id")
	private User user_receive;
	public Mail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mail(Integer id, String sujet, String contenu, User user_send, User user_receive) {
		super();
		this.id = id;
		this.sujet = sujet;
		this.contenu = contenu;
		this.user_send = user_send;
		this.user_receive = user_receive;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public User getUser_send() {
		return user_send;
	}
	public void setUser_send(User user_send) {
		this.user_send = user_send;
	}
	public User getUser_receive() {
		return user_receive;
	}
	public void setUser_receive(User user_receive) {
		this.user_receive = user_receive;
	}
	
	
}
