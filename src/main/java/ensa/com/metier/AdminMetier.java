package ensa.com.metier;

import java.util.List;

import org.springframework.stereotype.Component;
import ensa.com.entity.Agence;
import ensa.com.entity.Agent;
import ensa.com.entity.Compte;
import ensa.com.entity.Libelles;
import ensa.com.entity.Parameters;
public interface AdminMetier {
	public Agent CreateAgent(Agent t,Long code);
	public Agent FindAgent(Long code);
	public void UpdateAgent(Agent t,Long code);
	public void DeleteAgent(Long code);
	public List<Agent> ListAgents();
	public List<Agence> ListAgences();
	public void SetParameters(Parameters p);
	public Parameters ListParameters() ;
	public void SetLibelles(Libelles l);
	public Libelles ListLibelles() ;
	public Agence CreateAgence(Agence a,Long code);
	public void UpdateAgence(Agence a);
	public void DeleteAgence(Long code);
	public List<Compte> getComptes();
	public Agent findByUsename(String username);

}
