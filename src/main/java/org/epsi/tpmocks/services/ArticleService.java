/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.epsi.tpmocks.services;

import org.epsi.tpmocks.repositories.ArticleRepository;
import org.epsi.tpmocks.entities.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author epsi
 */
@Service
public class ArticleService  {

    @Autowired
    private ArticleRepository articleRepository;

    public Optional<Article> findOne(Long id) {
        return articleRepository.findById(id);

    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }


    public List<Article> findArticlesContaininWords(List<String> wordsToMatch) {
      /*  List<Article> articles = articleRepository.findAll();
        List<Article> resArticles = new ArrayList<>();

        for ( Article article : articles ) {
            boolean match = true ;
            for ( String wordToMatch : wordsToMatch) {
                if ( !article.getContent().toLowerCase().contains(wordToMatch.toLowerCase()))
                {
                    match = false;
                }
            }
            if ( match )
            {
                resArticles.add(article);
            }
        }*/
      
      List<Article> articles = articleRepository.findAll();
      return articles.stream().filter(
              article -> wordsToMatch.stream().allMatch(
              wordToMatch -> article.getContent().toLowerCase().contains(wordToMatch.toLowerCase()))).collect(
                      Collectors.toList());
    }
}
