package ensa.com.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Inheritance;
@Component
@Entity
@XmlRootElement(name="Compte")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Compte implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long code;
	private double solde;
	@ManyToOne
	@JoinColumn(name="code_client")
	private Client client;
	private Date datecreation;
	@ManyToOne
	@JoinColumn(name="code_agent")
	private Agent agent;
	@OneToMany(mappedBy="compte" , fetch=FetchType.LAZY )
	private List<Operation > operations;
	public Compte() {
		super();
	}
	
	public Client getClient() {
		return client;
	}

	public Compte(Long code, double solde, Client client, Date datecreation, Agent agent) {
		super();
		this.code = code;
		this.solde = solde;
		this.client = client;
		this.datecreation = datecreation;
		this.agent = agent;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Long getCode() {
		return code;
	}
	@JsonBackReference
	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public void setCode(Long code) {
		this.code = code;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	public Date getDatecreation() {
		return datecreation;
	}
	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}
	

}
