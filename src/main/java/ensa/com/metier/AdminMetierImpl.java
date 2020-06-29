package ensa.com.metier;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ensa.com.Repositary.AdminRepository;
import ensa.com.Repositary.AgenceRepository;
import ensa.com.Repositary.AgentRepositary;
import ensa.com.Repositary.CompteRepositary;
import ensa.com.Repositary.LibellesRepository;
import ensa.com.Repositary.ParametersRepository;
import ensa.com.Repositary.RoleRepository;
import ensa.com.Repositary.UserRepository;
import ensa.com.entity.Admin;
import ensa.com.entity.Agence;
import ensa.com.entity.Agent;
import ensa.com.entity.Compte;
import ensa.com.entity.Libelles;
import ensa.com.entity.Parameters;
import ensa.com.entity.Role;
import ensa.com.entity.RoleName;
import ensa.com.entity.User;
@Service("adminMetierImpl")
public class AdminMetierImpl implements AdminMetier {
	@Autowired
	private AgentRepositary em;
	@Autowired
	private AgenceRepository mm;
	@Autowired
	private ParametersRepository ep;
	@Autowired
	private LibellesRepository el;
	@Autowired
	private CompteRepositary cp;
	@Autowired
	private AdminRepository ad;
	
	@Autowired
	private UserRepository userr;
	
	@Autowired
	private RoleRepository role;

	@Override
	@Transactional
	public Agent CreateAgent( Agent t, Long code) {
		Agence agence=mm.findById(code).get();
		if(agence==null) throw new RuntimeException("Agence "+code+" introuvable!");
		t.setAgence(agence);
		em.save(t);
		User user=new User();
		user.setEmail(t.getEmail());
		user.setName(t.getNom());
		user.setPassword(t.getPassword());
		user.setUsername(t.getUsername());
		Set<String> strRoles =new HashSet<>();
		strRoles.add("agent");
		Set<Role> roles = new HashSet<>();
		Role userRole = role.findByName(RoleName.ROLE_AGENT)
				.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
		roles.add(userRole);
		user.setRoles(roles);
		userr.save(user);
		return t;
		
	}

	@Override
	public void UpdateAgent(Agent t,Long code) {
		Agence agence=mm.findById(code).get();
		if(agence==null) throw new RuntimeException("Agence "+code+" introuvable!");
		t.setAgence(agence);
		em.save(t);		
	}

	@Override
	public void DeleteAgent(Long code) {
		Agent agent =em.findById(code).get();
		String username = agent.getUsername();
		User user=userr.findByUserName(username);
		Long codeuser=user.getId();
		userr.deleteById(codeuser);
		em.deleteById(code);
		
	}

	@Override
	public List<Agent> ListAgents() {
		return em.findAll();
	
	}
	@Override
	public void SetParameters(Parameters p) {
		ep.save(p);
		
	}
	@Override
	public Parameters ListParameters() {
		return ep.findById((long) 1).get();
	
	}

	@Override
	public void SetLibelles(Libelles l) {
		el.save(l);
		
	}

	@Override
	public Libelles ListLibelles() {
		return el.findById((long) 1).get();
	}

	@Override
	@Transactional
	public Agence CreateAgence(Agence a,Long code) {
		Admin admin=ad.findById(code).get();
		if(admin==null) throw new RuntimeException("Admin "+code+" introuvable!");
		a.setAdmin(admin);
		mm.save(a);
		return a;
	}

	@Override
	public void UpdateAgence(Agence a) {
		mm.save(a);		
	}

	@Override
	public void DeleteAgence(Long code) {
		mm.deleteById(code);
		
	}
	@Override
	public List<Agence> ListAgences(){
		return mm.findAll();
	}
	@Override
	public List<Compte> getComptes(){
		return cp.findAll();
	}

	@Override
	public Agent FindAgent(Long code) {
		return em.findById(code).get();
	}
	@Override
	public Agent findByUsename(String username) {
		
		return em.findByUserName(username);
	}


}
