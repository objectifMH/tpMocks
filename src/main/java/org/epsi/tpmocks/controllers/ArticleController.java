/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.epsi.tpmocks.controllers;

import org.epsi.tpmocks.entities.Article;
import org.epsi.tpmocks.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author epsi
 */

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles/{id}")
    public Optional<Article> findById(@PathVariable Long id) {
        return articleService.findOne(id);
    }

    @GetMapping("/articles")
    public List<Article> findAll() {
        return articleService.findAll();
    }


}
