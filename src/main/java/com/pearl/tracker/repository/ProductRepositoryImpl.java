package com.pearl.tracker.repository;

import com.pearl.tracker.model.Product;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Named(value = "productRepository")
@SessionScoped
/*@Transactional*/
@NamedQueries({

})
public class ProductRepositoryImpl implements ProductRepository, Serializable {

    /*  @PersistenceContext(unitName = "myH2PU")
      private EntityManager em;
  */
    @Inject
    Validator validator;

//    ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
//    Validator validator = vf.getValidator();
    Set<ConstraintViolation<Product>> vialations = new HashSet();

    private static final String query = "select p from Product p where p.name = :productName";

    EntityManagerFactory emf;
    EntityManager em;

    List<Product> productList = null;


    @PostConstruct
    public void init(){

        TypedQuery<Product> q = em.createQuery(query,Product.class);

        emf.addNamedQuery("product.findbyProductNameD",q);
    }

    public EntityManager createEM() {

        emf = Persistence.createEntityManagerFactory("myH2PU");
        em = emf.createEntityManager();
        return em;
    }

    @Override
    public String addProduct(Product product) {

        /*createEM();

        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        em.persist(product);

        em.getTransaction().commit();
        em.close();
        emf.close();
        System.out.println("Success full Persist");*/


        vialations = validator.validate(product);

        if (vialations.size() > 0){
            throw new ConstraintViolationException(vialations);
        }

        productList.add(product);
        return "success";
    }

    public List<Product> getProducts() {

        /*List<Product> products = null;
        createEM();

        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }

        try {
            TypedQuery query = em.createQuery("select s from Product s", Product.class);
            query.setMaxResults(10);

            products = query.getResultList();
            em.getTransaction().commit();
//            return products;
        } catch (NullPointerException e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
*/
        return productList;
    }

    public Product findProductByName(String productName) {
        return em.createNamedQuery("product.findByProductName", Product.class)
                .setParameter("productName", productName)
                .getSingleResult();
    }
}
