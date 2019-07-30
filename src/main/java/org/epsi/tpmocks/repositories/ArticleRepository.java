/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.epsi.tpmocks.repositories;

import org.epsi.tpmocks.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author epsi
 */
public interface ArticleRepository extends JpaRepository<Article, Long>{
    
    
}
