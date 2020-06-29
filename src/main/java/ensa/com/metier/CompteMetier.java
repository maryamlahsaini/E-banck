package ensa.com.metier;

import ensa.com.entity.Compte;
import java.util.List;
import java.util.Optional;

public interface CompteMetier {
	public Compte SaveCompte(Compte cp,Long codeagent, Long codeclient);
	public Compte getCompte(Long code);
	public List<Compte> getComptesByClient(Long codeCli);
	 public List<Compte> getComptesByAgent(Long codeAgent);
	 public List<Compte>  listCompte();
	public void modifierCompte(Compte comptec);
	public void SupprimerCompte(Long code);
	public Optional<Compte> getCompteById(Long code);


}
