package ensa.com.metier;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ensa.com.Repositary.AgentRepositary;
import ensa.com.Repositary.CompteRepositary;
import ensa.com.Repositary.OperationRepositary;
import ensa.com.Repositary.ParametersRepository;
import ensa.com.entity.Agent;
import ensa.com.entity.Compte;
import ensa.com.entity.Operation;
import ensa.com.entity.Parameters;
import ensa.com.entity.Retrait;
import ensa.com.entity.Versement;


@Service

public class OperationMetierImpl implements OperationMetier {
	@Autowired
   private OperationRepositary operationrepositary;
	@Autowired
	private CompteRepositary compterepositary;
	@Autowired
	private AgentRepositary agentrepositary;
	@Autowired
	private ParametersRepository pametersrepositary;
	@Override
	public boolean verser(Long code, double montant , Long agent) {
		// TODO Auto-generated method stub
		Compte c=compterepositary.findById(code).get();
		Agent ag=agentrepositary.findById(agent).get();
		Operation o=new Versement();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(c);
		o.setAgent(ag);
		operationrepositary.save(o);
		c.setSolde(c.getSolde()+montant);
		compterepositary.save(c);
		return true;
	}

	@Override
	public boolean retirer(Long code, double montant , Long agent) {
		
		// TODO Auto-generated method stub
		Compte c=compterepositary.getOne(code);
		Agent ag=agentrepositary.getOne(agent);
		if(c.getSolde()< montant) throw new RuntimeException("solde insuffisant");
		Operation o=new Versement();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(c);
		o.setAgent(ag);
		operationrepositary.save(o);
		c.setSolde(c.getSolde()-montant);
		compterepositary.save(c);
		return true;
	}

	@Override
	public boolean virement(Long code1, Long code2, double montant) {
		// TODO Auto-generated method stubCompte c=compterepositary.getOne(code);
		Compte c=compterepositary.getOne(code1);
		if(c.getSolde()< montant) throw new RuntimeException("solde insuffisant");
		Operation o=new Retrait();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(c);
		operationrepositary.save(o);
		c.setSolde(c.getSolde()-montant);
		Compte cp=compterepositary.getOne(code2);
		Operation op=new  Versement();
		op.setDateOperation(new Date());
		op.setMontant(montant);
		op.setCompte(cp);
		operationrepositary.save(op);
		cp.setSolde(cp.getSolde()+montant);
		compterepositary.save(c);
		compterepositary.save(cp);
		return true;
	}

	@Override
	public double conversionDhToEuro(double montant) {
		// TODO Auto-generated method stub
		Long param=(long) 1;
		Parameters param1=pametersrepositary.getOne(param);
		double euro=param1.getEtd();
		return montant/euro;
	}

	@Override
	public double conversionEuroToDh(double montant) {
		// TODO Auto-generated method stub
		Long param=(long) 1;
		Parameters param1=pametersrepositary.getOne(param);
		double euro=param1.getEtd();
		return montant*euro;
		
	}

	@Override
	public double conversionDhToDolar(double montant) {
		// TODO Auto-generated method stub
		Long param=(long) 1;
		Parameters param1=pametersrepositary.getOne(param);
		double dolar=param1.getDtd();
		return montant/dolar;
	}

	@Override
	public double conversionDolarToDh(double montant) {
		// TODO Auto-generated method stub
		Long param=(long) 1;
		Parameters param1=pametersrepositary.getOne(param);
		double dolar=param1.getDtd();
		return montant*dolar;
	}

	@Override
	public boolean retirer(Long code, double montant) {
		Compte c=compterepositary.getOne(code);
		if(c.getSolde()< montant) throw new RuntimeException("solde insuffisant");
		Operation o=new Versement();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(c);
		operationrepositary.save(o);
		c.setSolde(c.getSolde()-montant);
		compterepositary.save(c);
		return true;
	}


}