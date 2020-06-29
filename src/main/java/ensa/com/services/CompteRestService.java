package ensa.com.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ensa.com.entity.Compte;
import ensa.com.metier.CompteMetier;
@CrossOrigin("*")
@RestController
public class CompteRestService {
	@Autowired
	private CompteMetier comptemetier;
	@PreAuthorize("hasRole('AGENT')")
	@RequestMapping(value="/addcompte/{codeagent}/{codeclient}",method=RequestMethod.POST)
	public Compte SaveCompte( @RequestBody Compte cp ,@PathVariable(name="codeagent") Long codeagent , @PathVariable(name="codeclient") Long codeclient) {
		return comptemetier.SaveCompte(cp, codeagent, codeclient);
	}

	@PreAuthorize("hasRole('AGENT')")
	@RequestMapping(value="/affichercompte/{code}",method=RequestMethod.GET)
	public Compte getCompte(@PathVariable Long code) {
		return comptemetier.getCompte(code);
	}
	@PreAuthorize("hasRole('AGENT') or hasRole('CLIENT') ")
	@RequestMapping(value="/affichercomptes",method=RequestMethod.GET)
	public List<Compte> listCompte() {
		
		return comptemetier.listCompte();
	}
	@PreAuthorize("hasRole('AGENT')")
	@RequestMapping(value="/modifierCompte",method=RequestMethod.POST)
	public void modifierClient(@RequestBody Compte c) {
		comptemetier.modifierCompte(c);
	}
	@PreAuthorize("hasRole('AGENT')")
	@RequestMapping(value="/supprimerCompte/{code}",method=RequestMethod.POST)
	public void SupprimerCompte(@PathVariable Long code) {
		comptemetier.SupprimerCompte(code);
	}
	
	@PreAuthorize("hasRole('CLIENT')")
	@RequestMapping(value="/compteC/{codeCli}",method=RequestMethod.GET)
	public List<Compte> getComptesByClient(@PathVariable Long codeCli) {
		return comptemetier.getComptesByClient(codeCli);
	}
	@PreAuthorize("hasRole('AGENT')")
	@RequestMapping(value="/compteA/{codeAgent}",method=RequestMethod.GET)
	public List<Compte> getComptesByAgent(@PathVariable Long codeAgent) {
		return comptemetier.getComptesByAgent(codeAgent);
	}




	
}
