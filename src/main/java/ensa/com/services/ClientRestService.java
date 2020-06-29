package ensa.com.services;

import java.util.List;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ensa.com.entity.Client;
import ensa.com.entity.Compte;
import ensa.com.metier.ClientMetier;
@CrossOrigin("*")
@RestController
public class ClientRestService {
	@Autowired 
	private ClientMetier clientmetier;

	@PreAuthorize("hasRole('AGENT')")
	@RequestMapping(value="/addclients",method=RequestMethod.POST)
	public Client saveClient(@RequestBody Client c) {
		
		return clientmetier.saveClient(c);
	}
	@PreAuthorize("hasRole('AGENT')")
	@RequestMapping(value="/afficherclients",method=RequestMethod.GET)
	public List<Client> listClient() {
		return clientmetier.listClient();
	}
	@PreAuthorize("hasRole('AGENT') or hasRole('CLIENT')")
	@RequestMapping(value="/clients/comptes/{code}",method=RequestMethod.GET)
	public List<Compte> listCompte(@PathVariable("code") Long code) {
		return clientmetier.listCompte(code);
	}
	@PreAuthorize("hasRole('AGENT')")
	@RequestMapping(value="/modifierClient",method=RequestMethod.POST)
	public void modifierClient(@RequestBody Client c) {
		clientmetier.modifierClient(c);
	}
	@PreAuthorize("hasRole('AGENT')")
	@RequestMapping(value="/supprimerClient/{code}",method=RequestMethod.POST)
	public void SupprimerClient(@PathVariable Long code) {
		clientmetier.SupprimerClient(code);
	}
     
	@PreAuthorize("hasRole('AGENT')")
	@RequestMapping(value="/client/{code}",method=RequestMethod.GET)
	public Client consulterClient(@PathVariable Long code ) {
		
		return clientmetier.consulterClient(code);
	}	
	
	
}