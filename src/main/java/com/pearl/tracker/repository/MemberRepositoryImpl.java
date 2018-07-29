package com.pearl.tracker.repository;

import com.pearl.tracker.annotations.Loggable;
import com.pearl.tracker.model.Member;

import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;

@Named(value = "memberRepository")
@SessionScoped
public class MemberRepositoryImpl implements MemberRepository, Serializable {

   /* @PersistenceContext(unitName = "myH2PU")
    private EntityManager entityManager;*/

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
    private EntityManager entityManager  = entityManagerFactory.createEntityManager();



    /*@PostConstruct
    public void init() {
        System.out.println("Entering into the PostConstruct");
        entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
        entityManager = entityManagerFactory.createEntityManager();
    }
*/
    @Override
    @Loggable
    public Member addMember(Member member) {

        Member memberValue = entityManager.find(Member.class, member.getId());

        if (memberValue != null) {

            FacesContext.getCurrentInstance().getMessageList().add(new FacesMessage("Member Already exist"));

            return memberValue;
        }
        entityManager.persist(member);

        return member;
    }


    @PreDestroy
    public void destroy() {
        System.out.println("Entering into PreDestroy");
        entityManager.close();
        entityManagerFactory.close();
    }
}
