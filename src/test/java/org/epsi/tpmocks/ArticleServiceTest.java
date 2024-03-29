package org.epsi.tpmocks;

import org.epsi.tpmocks.entities.Article;
import org.epsi.tpmocks.repositories.ArticleRepository;
import org.epsi.tpmocks.services.ArticleService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;

import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class ArticleServiceTest {

    @Mock
    private ArticleRepository articleRepository;

    // @Autowired pas de autowired car on est pas dans un contexte Spring
    @InjectMocks
    private ArticleService articleService;

    @Before  // pour exécuter avant chaque @Test
    public void init(){
        Mockito.when(articleRepository.findAll()).thenReturn(List.of(
                new Article("Mon premier article" , " Contenu premier article"),
                new Article("Mon second article" , " Contenu second article")
        ));

        Article ar = new Article("Mon 12 article" , " Contenu 12 article");
        ar.setId(12L);
        Mockito.when(articleRepository.findById(12L)).thenReturn(Optional.of(ar));
    }

    @Test
    public void shouldFindArticles(){
        List<Article> articles = articleService.findAll();
        Assert.assertEquals(2 , articles.size());
        Assert.assertEquals( "Mon premier article", articles.get(0).getTitle());
        Assert.assertEquals( "Mon second article", articles.get(1).getTitle());

    }


    @Test
    public void shouldFindOneArticle() {
        Optional<Article> article = articleService.findOne(12L);
        Assert.assertTrue(article.isPresent()); //Article("Mon 12 article" , " Contenu 12 article");
        Assert.assertEquals( " Contenu 12 article", article.orElseThrow().getContent());
    }


    @Test
    public void shouldFindOneArticlesContaininWords() {
        Article article1 = new Article("Recette1" , "Mayo Ketchup et Frites tomate concombre ciboulette");
        Article article2 = new Article("Recette2" , "Quelques Tomates, du concombre mais pas trop, de la mayonnaise");
        Article article3 = new Article("Recette3" , "Du pop corn avec du caramel et du  Ketchup et Frites");
        Article article4 = new Article("Recette4" , "Des Concombre à la tomate saupoudrés de mayonnaise à la ciboulette sans  Ketchup et Frites");

        Mockito.when(articleRepository.findAll()).thenReturn(List.of(article1 , article2 , article3, article4));

        List<Article> articles = articleService.findArticlesContaininWords(List.of("tomate" , "concombre" , "ciboulette"));
        Assert.assertEquals(2 , articles.size() );
        Assert.assertTrue(articles.contains(article1) );
        Assert.assertTrue(articles.contains(article4) );

    }
}
