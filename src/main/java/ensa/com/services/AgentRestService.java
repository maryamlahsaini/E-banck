package ensa.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ensa.com.entity.Agent;
import ensa.com.metier.AgentMetier;

@RestController
@CrossOrigin("*")
public class AgentRestService {
	@Autowired
	private AgentMetier agentmetier;
	@RequestMapping(value="/agents",method=RequestMethod.POST)
	public Agent SaveAgent(@RequestBody Agent agent) {
		return agentmetier.SaveAgent(agent);
	}
	@RequestMapping(value="/agents",method=RequestMethod.GET)
	public List<Agent> ListAgents() {
		return agentmetier.ListAgents();
	}

}
