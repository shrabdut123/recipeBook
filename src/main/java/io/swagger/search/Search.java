package io.swagger.search;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;

import io.swagger.model.Ingredient;
import io.swagger.model.Recipe;

@Repository
@Transactional
public class Search {

  // Spring will inject here the entity manager object
  @PersistenceContext
  private EntityManager entityManager;
    
  /**
   * A basic search for the entity Ingredient. The search is done by exact match per
   * keywords on field name.
   * 
   * @param text The query text.
   */
  public List<Ingredient> searchIngredient(String text) {
    
    // get the full text entity manager
    FullTextEntityManager fullTextEntityManager =
        org.hibernate.search.jpa.Search.
        getFullTextEntityManager(entityManager);
    
    // create the query using Hibernate Search query DSL
    QueryBuilder queryBuilder = 
        fullTextEntityManager.getSearchFactory()
        .buildQueryBuilder().forEntity(Ingredient.class).get();
    
    /*
    // a very basic query by keywords
    org.apache.lucene.search.Query query =
        queryBuilder
          .keyword()
          .onFields("name")
          .matching(text)
          .createQuery();
    */
    Query phraseQuery = queryBuilder
    		  .phrase()
    		  .withSlop(1)
    		  .onField("name")
    		  .sentence(text)
    		  .createQuery();

    // wrap Ingredient query in an Hibernate Query object
    org.hibernate.search.jpa.FullTextQuery jpaQuery =
        fullTextEntityManager.createFullTextQuery(phraseQuery, Ingredient.class);
  
    // execute search and return results (sorted by relevance as default)
    @SuppressWarnings("unchecked")
    List<Ingredient> results = jpaQuery.getResultList();
    
    return results;
  } 
  
  /**
   * A basic search for the entity Ingredient. The search is done by exact match per
   * keywords on field name.
   * 
   * @param text The query text.
   */
  public List<Recipe> searchRecipe(String text) {
    
    // get the full text entity manager
    FullTextEntityManager fullTextEntityManager =
        org.hibernate.search.jpa.Search.
        getFullTextEntityManager(entityManager);
    
    // create the query using Hibernate Search query DSL
    QueryBuilder queryBuilder = 
        fullTextEntityManager.getSearchFactory()
        .buildQueryBuilder().forEntity(Recipe.class).get();
    /*
    // a very basic query by keywords
    org.apache.lucene.search.Query query =
        queryBuilder
          .keyword()
          .onFields("name")
          .matching(text)
          .createQuery();*/
    Query phraseQuery = queryBuilder
  		  .phrase()
  		  .withSlop(1)
  		  .onField("name")
  		  .sentence(text)
  		  .createQuery();
    
    // wrap Ingredient query in an Hibernate Query object
    org.hibernate.search.jpa.FullTextQuery jpaQuery =
        fullTextEntityManager.createFullTextQuery(phraseQuery, Recipe.class);
  
    // execute search and return results (sorted by relevance as default)
    @SuppressWarnings("unchecked")
    List<Recipe> results = jpaQuery.getResultList();
    
    return results;
  }

} 