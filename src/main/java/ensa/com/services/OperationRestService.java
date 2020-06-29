package ensa.com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import ensa.com.metier.OperationMetier;

@RestController
@CrossOrigin("*")
public class OperationRestService {
	@Autowired
	private OperationMetier operationmetier;
	@PreAuthorize("hasRole('AGENT')")
	@RequestMapping(value="/versement/{code}/{montant}/{codeagnet}",method=RequestMethod.PUT)
	public boolean verser(@PathVariable("code") Long code, @PathVariable("montant") double montant ,@PathVariable("codeagnet") Long codeagnet) {
		return operationmetier.verser(code, montant , codeagnet);
	}
	@PreAuthorize("hasRole('AGENT')")
	@RequestMapping(value="/retrait/{code}/{montant}/{codeagnet}",method= {RequestMethod.PUT,RequestMethod.GET})
	public boolean retirer(@PathVariable("code") Long code,@PathVariable("montant") double montant ,@PathVariable("codeagnet") Long  codeagnet) {
		return operationmetier.retirer(code, montant, codeagnet);
	}
	@PreAuthorize("hasRole('CLIENT')")
	@RequestMapping(value="/virement/{code1}/{code2}/{montant}",method=RequestMethod.PUT)
	public boolean virement(@PathVariable("code1") Long code1,@PathVariable("code2")  Long code2,@PathVariable("montant") double montant) {
		return operationmetier.virement(code1, code2, montant);
	}
	@PreAuthorize("hasRole('AGENT')")
	@RequestMapping(value="/convertdhToEuro/{montant}",method= {RequestMethod.PUT,RequestMethod.GET})
	public double conversionDhToEuro(@PathVariable("montant")  double montant) {
		return operationmetier.conversionDhToEuro(montant);
	}
	@PreAuthorize("hasRole('AGENT')")
	@RequestMapping(value="/convertEuroToDh/{montant}",method= {RequestMethod.PUT,RequestMethod.GET})
	public double conversionEuroToDh(@PathVariable("montant")double montant) {
		return operationmetier.conversionEuroToDh(montant);
	}
	@PreAuthorize("hasRole('AGENT')")
	@RequestMapping(value="/convertDhToDolar/{montant}",method= {RequestMethod.PUT,RequestMethod.GET})
	public double conversionDhToDolar(@PathVariable("montant") double montant) {
		return operationmetier.conversionDhToDolar(montant);
	}
	@PreAuthorize("hasRole('AGENT')")
	@RequestMapping(value="/convertDolarToDh/{montant}",method= {RequestMethod.PUT,RequestMethod.GET})
	public double conversionDolarToDh(@PathVariable("montant") double montant) {
		return operationmetier.conversionDolarToDh(montant);
	}
	

}