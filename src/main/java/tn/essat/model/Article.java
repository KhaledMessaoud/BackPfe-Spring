package tn.essat.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String type;
	@Lob
	private byte[] data;
	private LocalDate submission_date;
	@ManyToMany
	private List<Theme> theme;
	@ManyToOne
	@JoinColumn(name = "etat_id")
	private EtatArticle etat_article;
	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article(String name, String type, byte[] data, LocalDate submission_date, List<Theme> theme,
			EtatArticle etat_article) {
		super();
		this.name = name;
		this.type = type;
		this.data = data;
		this.submission_date = submission_date;
		this.theme = theme;
		this.etat_article = etat_article;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public LocalDate getSubmission_date() {
		return submission_date;
	}

	public void setSubmission_date(LocalDate submission_date) {
		this.submission_date = submission_date;
	}

	public List<Theme> getTheme() {
		return theme;
	}

	public void setTheme(List<Theme> theme) {
		this.theme = theme;
	}

	public EtatArticle getEtat_article() {
		return etat_article;
	}

	public void setEtat_article(EtatArticle etat_article) {
		this.etat_article = etat_article;
	}

	public Integer getId() {
		return id;
	}
	
	
	
	
	

}
