package ensa.com.metier;

import org.springframework.beans.factory.annotation.Autowired;

import ensa.com.Repositary.ParametersRepository;
import ensa.com.entity.Parameters;

public class ParametersMetierImpl implements ParametersMetier  {
    
	@Autowired
	private ParametersRepository pametersrepositary;
	@Override
	public Parameters getparameters(Long code) {
		Parameters param=pametersrepositary.getOne(code);
		return param;
	}
	

}
