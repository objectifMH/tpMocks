/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.epsi.tpmocks.entities;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author epsi
 */

@Entity 
@Data // créée les getters et setters, hashcode et toString
@RequiredArgsConstructor
public class Article {
    
    @GeneratedValue @Id
    private Long id ;
    
    private final String title;
    private final String content;

    public Article(){
        title = null;
        content = null;
    }
    
}
