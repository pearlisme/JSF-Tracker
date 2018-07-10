package com.pearl.tracker.repository;

import com.pearl.tracker.model.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.*;
import javax.transaction.Transactional;

@Named(value = "productRepository")
@ApplicationScoped
/*@Transactional*/
public class ProductRepositoryImpl implements ProductRepository {

   /* @PersistenceContext(unitName = "myPU")
    private EntityManager em;*/

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
    EntityManager em = emf.createEntityManager();


    @Override
    public void addProduct(Product product) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(product);
        tx.commit();

        System.out.println("Success full Persist");
    }
}
