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

import java.util.List;
import java.util.Optional;

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


    
}
