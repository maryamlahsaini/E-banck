package ensa.com.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ensa.com.Repositary.ClientRepositary;
import ensa.com.Repositary.RoleRepository;
import ensa.com.Repositary.UserRepository;
import ensa.com.entity.Agent;
import ensa.com.entity.Client;
import ensa.com.entity.Compte;
import ensa.com.entity.Role;
import ensa.com.entity.RoleName;
import ensa.com.entity.User;
import java.util.HashSet;
import java.util.Set;


import java.util.Optional;

@Service 
public class ClientMetierImpl implements ClientMetier {
   @Autowired
	private ClientRepositary clientrepositary;
   @Autowired
	private UserRepository userrepositary;
   @Autowired
	private RoleRepository rolerepositary;
   @Override
	public Client saveClient(Client c) {
		clientrepositary.save(c);
	
		User user=new User();
		user.setEmail(c.getEmail());
		user.setName(c.getNom());
		user.setPassword(c.getPassword());
		user.setUsername(c.getUsername());
		Set<String> strRoles =new HashSet<>();
		strRoles.add("client");
		Set<Role> roles = new HashSet<>();
		Role userRole = rolerepositary.findByName(RoleName.ROLE_CLIENT)
				.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
		roles.add(userRole);
		user.setRoles(roles);
		userrepositary.save(user);
		return c;
		
		
		
	}

	@Override
	public List<Client> listClient() {
	
		return clientrepositary.findAll();
	}

	@Override
	public List<Compte> listCompte(Long code) {
		// TODO Auto-generated method stub
		Client c=clientrepositary.getOne(code);
		
		return c.getComptes();
	}
	
	@Override
	public Client consulterClient(Long codeCli) {
		// TODO Auto-generated method stub
		return clientrepositary.findById(codeCli).orElse(null);
	}

	@Override
	public void modifierClient(Client c) {
		
		 clientrepositary.save(c);
		
	}

	@Override
	public void SupprimerClient(Long code) {
		Client c1 =clientrepositary.findById(code).get();
		String username = c1.getUsername();
		User user=userrepositary.findByUserName(username);
		Long codeuser=user.getId();
		userrepositary.deleteById(codeuser);
		Optional<Client> client = clientrepositary.findById(code);
		if(client.isPresent()) {
			clientrepositary.delete(client.get());
		}
		
	}
	@Override
	public Optional<Client> getClientById(Long code) {
		return clientrepositary.findById(code);
	}

	@Override
	public Client FindByUsename(String username) {
		
		return clientrepositary.findByUsername(username);
	}
	
	

}