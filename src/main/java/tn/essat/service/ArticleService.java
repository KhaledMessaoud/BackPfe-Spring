package tn.essat.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tn.essat.dao.IArticle;
import tn.essat.model.Article;

@Service
public class ArticleService {
	
	@Autowired
	IArticle article_dao;

	public Article store(MultipartFile article) throws IOException {
		LocalDate localDate = LocalDate.now();
		String articlename = article.getOriginalFilename();
		Article newarticle = new Article(articlename, article.getContentType(), article.getBytes(), localDate, null, null);
		return article_dao.save(newarticle);
	}

	public Article getFileById(Integer id) {

		Optional<Article> fileOptional = article_dao.findById(id);

		if (fileOptional.isPresent()) {
			return fileOptional.get();
		}
		return null;
	}

	public List<Article> getFileList() {
		return article_dao.findAll();
	}
}
