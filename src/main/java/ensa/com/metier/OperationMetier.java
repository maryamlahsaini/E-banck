package ensa.com.metier;

public interface OperationMetier {
	public boolean verser(Long code, double montant ,Long codeagent);
	public boolean retirer(Long code, double montant , Long codeagent);
	public boolean retirer(Long code, double montant);
	public boolean virement(Long code1 , Long code2 , double montant);
	public double conversionDhToEuro(double montant );
	public double conversionEuroToDh(double montant );
	public double conversionDhToDolar(double montant );
	public double conversionDolarToDh(double montant );

}