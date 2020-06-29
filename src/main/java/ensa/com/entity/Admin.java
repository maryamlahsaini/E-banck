package ensa.com.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Component
@XmlRootElement(name="Admin")
@Entity
public class Admin implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long code;
	private String nom;
	private String prenom;
	private String Username;
	private String password;
	@OneToMany(mappedBy="admin" ,fetch=FetchType.LAZY)
	private List<Agence> agence;
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@JsonBackReference
	public List<Agence> getAgence() {
		return agence;
	}
	public void setAgence(List<Agence> agence) {
		this.agence = agence;
	}
	public Admin() {
		super();
	}
	public Admin(String nom, String prenom, String username, String password, List<Agence> agence) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		Username = username;
		this.password = password;
		this.agence = agence;
	}
	
	
}
