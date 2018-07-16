package com.pearl.tracker.repository;

import com.pearl.tracker.model.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Named(value = "productRepository")
@SessionScoped
/*@Transactional*/
@NamedQueries({

})
public class ProductRepositoryImpl implements ProductRepository , Serializable {

    /*  @PersistenceContext(unitName = "myH2PU")
      private EntityManager em;
  */
    EntityManagerFactory emf;
    EntityManager em;


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
        em.persist(product);

        em.getTransaction().commit();
        em.close();
        emf.close();
        System.out.println("Success full Persist");

        return "success";
    }

    public List<Product> getProducts() {

        createEM();

        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        TypedQuery query = em.createQuery("select s from Product s", Product.class);
        query.setMaxResults(10);
        List<Product> products = query.getResultList();
        em.getTransaction().commit();

        em.close();
        emf.close();

        return products;
    }
}
