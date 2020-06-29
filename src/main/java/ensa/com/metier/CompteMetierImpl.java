package ensa.com.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ensa.com.Repositary.AgentRepositary;
import ensa.com.Repositary.ClientRepositary;
import ensa.com.Repositary.CompteRepositary;
import ensa.com.entity.Agent;
import ensa.com.entity.Client;
import ensa.com.entity.Compte;
@Service
public class CompteMetierImpl implements CompteMetier {
	@Autowired
    private CompteRepositary compterepositary;
	@Autowired
	private AgentRepositary	agentrepositary;
	@Autowired
	private ClientRepositary clientrepositary;
	@Override
	public Compte SaveCompte(Compte cp,Long codeagent, Long codeclient) {
		
		
		Agent agent=agentrepositary.findById(codeagent).get();
		
		Client client=clientrepositary.findById(codeclient).get();
		cp.setDatecreation(new Date());
		cp.setAgent(agent);
		cp.setClient(client);
		
		return compterepositary.save(cp);
	}

	@Override
	public Compte getCompte(Long code) {
		// TODO Auto-generated method stub
		return compterepositary.getOne(code);
	}
	@Override
	public List<Compte> getComptesByClient(Long codeCli) {
		return compterepositary.getComptesByClient(codeCli);
	}

	@Override
	public List<Compte> getComptesByAgent(Long codeAgent) {
		// TODO Auto-generated method stub
		return compterepositary.getComptesByAgent(codeAgent);
	}

	@Override
	public List<Compte> listCompte() {
		// TODO Auto-generated method stub
		return compterepositary.findAll();
	}

	@Override
	public void modifierCompte(Compte compte) {
		
		 compterepositary.save(compte);
		
	}

	@Override
	public void SupprimerCompte(Long code) {
		Optional<Compte> compte = compterepositary.findById(code);
		if(compte.isPresent()) {
			compterepositary.delete(compte.get());
		}
		
	}
	@Override
	public Optional<Compte>getCompteById(Long code) {
		return compterepositary.findById(code);
	}



}
