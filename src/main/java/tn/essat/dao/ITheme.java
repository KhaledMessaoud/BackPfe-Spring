package tn.essat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.essat.model.Theme;

@Repository
public interface ITheme extends JpaRepository<Theme, Integer> {

}
