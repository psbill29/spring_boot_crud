package com.trinity.springbootcrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.trinity.springbootcrud.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Modifying
	@Query(value="delete from User u where u.name=?1")
	void deleteByName(String name);

	User findByName(String name);
}
