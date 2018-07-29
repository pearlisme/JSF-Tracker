package com.pearl.tracker.repository;

import com.pearl.tracker.model.Product;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "productRepository")
@SessionScoped
/*@Transactional*/
@NamedQueries({

})
public class ProductRepositoryImpl implements ProductRepository, Serializable {

    /*  @PersistenceContext(unitName = "myH2PU")
      private EntityManager em;
  */

    private static final String query = "select p from Product p where p.name = :productName";

    EntityManagerFactory emf;
    EntityManager em;

    List<Product> productList = new ArrayList<Product>();


   /* @PostConstruct
    public void init(){

        TypedQuery<Product> q = em.createQuery(query,Product.class);

        emf.addNamedQuery("product.findbyProductNameD",q);
    }*/

//   @PostConstruct
    public EntityManager createEM() {

        emf = Persistence.createEntityManagerFactory("myH2PU");
        em = emf.createEntityManager();
        return em;
    }

    @Override
    public String addProduct(Product product) {

        createEM();

        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }

        try {
            em.persist(product);
        } catch (Exception e) {
            e.printStackTrace();
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
        System.out.println("Success full Persist");


        return "success";
    }

    public List<Product> getProducts() {

        List<Product> products = new ArrayList<>();
        createEM();

        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }

        try {
            TypedQuery query = em.createQuery("select s from Product s", Product.class);
            query.setMaxResults(10);

            products = query.getResultList();
            em.getTransaction().commit();
            return products;
        } catch (NullPointerException e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
        return productList;
    }

    public Product findProductByName(String productName) {
        return em.createNamedQuery("product.findByProductName", Product.class)
                .setParameter("productName", productName)
                .getSingleResult();
    }
}
