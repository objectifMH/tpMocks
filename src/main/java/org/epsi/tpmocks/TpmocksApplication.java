package org.epsi.tpmocks;

import org.epsi.tpmocks.entities.Article;
import org.epsi.tpmocks.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TpmocksApplication {
	public static void main(String[] args) {
		SpringApplication.run(TpmocksApplication.class, args);
	}
	@Autowired
	private ArticleRepository articleRepository;
	@PostConstruct
	private void init(){
		//List<Long> articlesId = articleRepository.findAll().stream().map(Article::getId).collect(Collectors.toList());
		List<Long> articlesId = new ArrayList<>();
		List<Article> articles = articleRepository.findAll();
		for(Article article : articles) {
			articlesId.add(article.getId());
		}
		if(!articlesId.contains(1L)){
			articleRepository.save(new Article("Mon premier article", "Ceci est le contenu de mon premier article !"));
		}
		if(!articlesId.contains(2L)){
			articleRepository.save(new Article("Mon second article", "Ceci est le contenu de mon second article !"));
		}
	}
}