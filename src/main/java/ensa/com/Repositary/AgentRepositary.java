package ensa.com.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import ensa.com.entity.Agent;
@Repository
@Component("em")
@CrossOrigin("*")
public interface AgentRepositary extends JpaRepository<Agent,Long> {
	@Async
    @Query("SELECT a FROM Agent a where a.Username = :username") 
    Agent findByUserName(@Param("username") String username);



}
