package br.com.springboot.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.springboot.api.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

	
	

}
