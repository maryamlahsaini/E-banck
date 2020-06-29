package ensa.com.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import ensa.com.entity.Compte;
@Repository
@Component
public interface CompteRepositary extends JpaRepository<Compte,Long> {
	@Query("select c from Compte c where c.client.code=:x")
	public List<Compte>getComptesByClient(@Param("x")Long codeCli);
	

	@Query("select c from Compte c where c.agent.code=:x")
	public List<Compte>getComptesByAgent(@Param("x")Long codeAgent);


}
