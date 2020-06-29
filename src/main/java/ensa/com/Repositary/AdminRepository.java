package ensa.com.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ensa.com.entity.Admin;
@Repository
@Component
public interface AdminRepository extends JpaRepository<Admin,Long>{

}
