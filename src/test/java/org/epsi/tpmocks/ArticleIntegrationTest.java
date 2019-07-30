package org.epsi.tpmocks;

import org.epsi.tpmocks.entities.Article;
import org.epsi.tpmocks.repositories.ArticleRepository;
import org.epsi.tpmocks.services.ArticleService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleIntegrationTest {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private ArticleRepository articleRepository;

	/*
	@Before
	public void initData() { //on insere dans le before pour verifier si c'est en base et les supprimer dans un after
		articleRepository.save(new Article("premier test" , "contenu premier test"));
		articleRepository.save(new Article("second test" , "contenu second test"));
	}
	*/

	@Test
	public void contextLoads() {

	}

	@Test
	public void shouldFindArticles() {
		List<Article> articles = articleService.findAll();
		Assert.assertEquals(2 , articles.size());
		Assert.assertEquals( "Mon premier article", articles.get(0).getTitle());
		Assert.assertEquals( "Mon second article", articles.get(1).getTitle());
	}

	@Test
	public void shouldFindOneArticle() {
		Optional<Article> article = articleService.findOne(1L);
		Assert.assertTrue(article.isPresent());
		Assert.assertEquals( "Ceci est le contenu de mon premier article !", article.orElseThrow().getContent());
	}



}
