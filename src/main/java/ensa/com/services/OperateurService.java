package ensa.com.services;

import java.util.List;

import javax.jws.WebMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ensa.com.Repositary.ClientRepositary;
import ensa.com.Repositary.CompteRepositary;
import ensa.com.entity.Client;
import ensa.com.entity.Compte;
import ensa.com.entity.Retrait;
import ensa.com.metier.OperationMetier;
import ensa.com.webservice.Operateur;
import ensa.com.webservice.OperateurControllerService;

@CrossOrigin("*")
@Component
@RestController
public class OperateurService {
	
	@Autowired
	CompteRepositary cpt;
	
	@Autowired
	private OperationMetier operationmetier;
	
	@Autowired
	private ClientRepositary clientRepository;
	
	@RequestMapping(value="/Operateur/recharge/compte/{username}",method=RequestMethod.GET)
	@PreAuthorize("hasRole('CLIENT')")
    public List<Compte> findCompteByUsername(@PathVariable("username")String username) {
		Client c =clientRepository.findByUsername(username);
		List<Compte> comptes=c.getComptes();
		return comptes;
		
	}

	@RequestMapping(value="/Operateur/recharge/{num}/{nom}/{code}/{montant}",method=RequestMethod.POST)
	@PreAuthorize("hasRole('CLIENT')")
	public boolean recharge(@PathVariable("num")int num,@PathVariable("nom")String nom,@PathVariable("code")Long code,@PathVariable("montant")double montant) {
    	Operateur operateur = new OperateurControllerService().getOperateurPort();
    	boolean value = operateur.findOpByNameAndNum(num,nom);
    	if(value) {
         Compte compte =cpt.findById(code).get();
         double solde =compte.getSolde();
         if(solde>=montant) {
        	 operationmetier.retirer(code, montant);
        	 return true;
         }
         else {
        	 return false;
        	 
         }
    	}
    	return false;
	}
}
