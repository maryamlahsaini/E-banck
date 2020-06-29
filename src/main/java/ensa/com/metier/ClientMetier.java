package ensa.com.metier;

import java.util.List;

import ensa.com.entity.Client;
import ensa.com.entity.Compte;
import java.util.Optional;


public interface ClientMetier {
	public Client saveClient(Client c);

	public List<Client>  listClient();
	public List<Compte>  listCompte(Long code);
	
	public Client consulterClient(Long codeCli);
	public void modifierClient(Client c);
	public void SupprimerClient(Long code);
	public Optional<Client> getClientById(Long code);
	public Client FindByUsename(String username);
    
}
