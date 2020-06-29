package ensa.com.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Id;
@Component
@XmlRootElement(name="Agent")
@Entity
public class Agent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long code;
	
	private String nom;
	private String prenom;
	private String Username ;
	private String password;
	@Email
	private String email;
	@ManyToOne
	@JoinColumn(name="code_agence")
	private Agence agence;
	@OneToMany(mappedBy="agent" , fetch=FetchType.LAZY)
	private List<Compte> compte ;
	@OneToMany(mappedBy="agent" , fetch=FetchType.LAZY )
	private List<Operation > operations;
	@JsonBackReference(value="list-operations")
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	public Agence getAgence() {
		return agence;
	}
	public void setAgence(Agence agence) {
		this.agence = agence;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public Agent() {
		super();
	}
	public Agent(String nom, String prenom, String username, String password, String email, Agence agence,
			List<Compte> compte) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		Username = username;
		this.password = password;
		this.email = email;
		this.agence = agence;
		this.compte = compte;
	}
	@JsonBackReference(value="list-comptes")
	public List<Compte> getCompte() {
		return compte;
	}
	public void setCompte(List<Compte> compte) {
		this.compte = compte;
	}
	
	
	

}

