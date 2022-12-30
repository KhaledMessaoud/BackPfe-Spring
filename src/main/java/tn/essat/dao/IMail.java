package tn.essat.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.essat.model.Mail;

@Repository
public interface IMail extends JpaRepository<Mail, Integer>{
	
	@Query("select m from Mail m where m.user_send.id=:x")
	public List<Mail> getAllMessagesSendByIdUser(@Param("x")Integer id) ;



	@Query("select m from Mail m where m.user_receive.id=:x")
	public List<Mail> getAllMessagesRecusByIdUser(@Param("x")Integer id) ;

}
