package tn.essat.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import tn.essat.model.User;

@Repository
public interface IUser extends JpaRepository<User, Integer>{
	public List<User> findByUsernameAndPassword(String username,String Password);
	
	public User findByUsername(String username);
	
	public User findByEmail(String email);
	
	/*@Query("select u from User u Join Role r where r.id =:x")
	public List<User> getAllUserByRole(@Param("x") Integer id);*/
	
	
	
}
