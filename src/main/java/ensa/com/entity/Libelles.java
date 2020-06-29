package ensa.com.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;
@Component
@XmlRootElement(name="Libelles")
@Entity
public class Libelles implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long ID;
	String BanqueTitre;
	String AgenceTitre;
	String messageClientVirement;
	String messageClientVirsement;
	String messageClientRetrait;
	String messageAgentAddClient;
	String messageAgentDeleteClient;
	String messageAgentUpdateClient;
	String messageAgentBloqueClient;
	String messageAgentdeBloqueClient;
	public Libelles() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Libelles(String banqueTitre, String agenceTitre, String messageClientVirement, String messageClientVirsement,
			String messageClientRetrait, String messageAgentAddClient, String messageAgentDeleteClient,
			String messageAgentUpdateClient, String messageAgentBloqueClient, String messageAgentdeBloqueClient) {
		super();
		BanqueTitre = banqueTitre;
		AgenceTitre = agenceTitre;
		this.messageClientVirement = messageClientVirement;
		this.messageClientVirsement = messageClientVirsement;
		this.messageClientRetrait = messageClientRetrait;
		this.messageAgentAddClient = messageAgentAddClient;
		this.messageAgentDeleteClient = messageAgentDeleteClient;
		this.messageAgentUpdateClient = messageAgentUpdateClient;
		this.messageAgentBloqueClient = messageAgentBloqueClient;
		this.messageAgentdeBloqueClient = messageAgentdeBloqueClient;
	}
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getBanqueTitre() {
		return BanqueTitre;
	}
	public void setBanqueTitre(String banqueTitre) {
		BanqueTitre = banqueTitre;
	}
	public String getAgenceTitre() {
		return AgenceTitre;
	}
	public void setAgenceTitre(String agenceTitre) {
		AgenceTitre = agenceTitre;
	}
	public String getMessageClientVirement() {
		return messageClientVirement;
	}
	public void setMessageClientVirement(String messageClientVirement) {
		this.messageClientVirement = messageClientVirement;
	}
	public String getMessageClientVirsement() {
		return messageClientVirsement;
	}
	public void setMessageClientVirsement(String messageClientVirsement) {
		this.messageClientVirsement = messageClientVirsement;
	}
	public String getMessageClientRetrait() {
		return messageClientRetrait;
	}
	public void setMessageClientRetrait(String messageClientRetrait) {
		this.messageClientRetrait = messageClientRetrait;
	}
	public String getMessageAgentAddClient() {
		return messageAgentAddClient;
	}
	public void setMessageAgentAddClient(String messageAgentAddClient) {
		this.messageAgentAddClient = messageAgentAddClient;
	}
	public String getMessageAgentDeleteClient() {
		return messageAgentDeleteClient;
	}
	public void setMessageAgentDeleteClient(String messageAgentDeleteClient) {
		this.messageAgentDeleteClient = messageAgentDeleteClient;
	}
	public String getMessageAgentUpdateClient() {
		return messageAgentUpdateClient;
	}
	public void setMessageAgentUpdateClient(String messageAgentUpdateClient) {
		this.messageAgentUpdateClient = messageAgentUpdateClient;
	}
	public String getMessageAgentBloqueClient() {
		return messageAgentBloqueClient;
	}
	public void setMessageAgentBloqueClient(String messageAgentBloqueClient) {
		this.messageAgentBloqueClient = messageAgentBloqueClient;
	}
	public String getMessageAgentdeBloqueClient() {
		return messageAgentdeBloqueClient;
	}
	public void setMessageAgentdeBloqueClient(String messageAgentdeBloqueClient) {
		this.messageAgentdeBloqueClient = messageAgentdeBloqueClient;
	}
	

}
