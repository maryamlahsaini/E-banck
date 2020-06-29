package ensa.com.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ensa.com.Repositary.AgentRepositary;
import ensa.com.entity.Agent;
@Service
public class AgentMetierImpl implements AgentMetier {
	@Autowired 
	private AgentRepositary agentrepositary;

	@Override
	public Agent SaveAgent(Agent agent) {
		// TODO Auto-generated method stub
		return agentrepositary.save(agent) ;
	}

	@Override
	public List<Agent> ListAgents() {
		// TODO Auto-generated method stub
		return agentrepositary.findAll();
	}
	
	@Override
	public Agent findByUsename(String username) {
		
		return agentrepositary.findByUserName(username);
	}

}
