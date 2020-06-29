package ensa.com.Repositary;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ensa.com.entity.Client;

@Repository
@Component
public interface ClientRepositary extends JpaRepository<Client,Long>{ 
	
	 @Async
	    @Query("SELECT t FROM Client t where t.Username = :username") 
	      Client findByUsername(@Param("username") String username);

}
