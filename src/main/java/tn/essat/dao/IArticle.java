package tn.essat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.essat.model.Article;

@Repository
public interface IArticle extends JpaRepository<Article, Integer> {

}
