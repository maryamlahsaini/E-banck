package ensa.com.metier;

import java.util.List;

import ensa.com.entity.Agent;

public interface AgentMetier {
 public Agent SaveAgent(Agent agent);
 public List<Agent> ListAgents();
 public Agent findByUsename(String username);
}
