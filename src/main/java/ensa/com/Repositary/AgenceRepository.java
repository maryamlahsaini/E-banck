package ensa.com.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import ensa.com.entity.Agence;
@Repository
@Component
@CrossOrigin("*")
public interface AgenceRepository  extends JpaRepository<Agence,Long>{
	 @Async
	    @Query("SELECT t FROM Agence t where t.name = :name") 
	    Agence findByName(@Param("name") String name);

}
