package ensa.com.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import ensa.com.entity.Libelles;
@Repository
@Component
@CrossOrigin("*")
public interface LibellesRepository extends JpaRepository<Libelles,Long>{

}
