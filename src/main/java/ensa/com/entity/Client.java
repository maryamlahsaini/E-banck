package ensa.com.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;
@Component
@XmlRootElement(name="Client")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Client implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long code;
	private String nom;
	private String prenom ; 
	@NotEmpty
	@Column(unique = true)
	private String Username;
	private String password; 
	private String tel;
	@Email
	private String email;
	@OneToMany(mappedBy="client", fetch=FetchType.LAZY)
	private List<Compte> comptes;
	public Client() {
		super();
	}
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@JsonBackReference
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	public Client(Long code, String nom, String prenom, String username, String password, String tel, String email,
			List<Compte> comptes) {
		super();
		this.code = code;
		this.nom = nom;
		this.prenom = prenom;
		Username = username;
		this.password = password;
		this.tel = tel;
		this.email = email;
		this.comptes = comptes;
	} 
	
	
	

}

