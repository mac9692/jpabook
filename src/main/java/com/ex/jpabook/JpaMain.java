package com.ex.jpabook;

import com.ex.jpabook.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.extern.log4j.Log4j2;

import java.util.List;
@Log4j2
public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-study");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            logic(entityManager);
            transaction.commit();
        } catch (Exception e) {
            log.error(e);
            transaction.rollback();
        } finally {
            entityManager.close();
        }
        entityManagerFactory.close();
    }

    public static void logic(EntityManager entityManager) {
        String id = "id1";
        Member member = new Member();
        member.setId(id);
        member.setUserName("진성");
        member.setAge(31);

        entityManager.persist(member);

        member.setAge(30);

        Member findMember = entityManager.find(Member.class, id);
        log.info("findMember age= {}", findMember.getAge());

        List<Member> memberList = entityManager.createQuery("select m from Member m", Member.class).getResultList();
        log.info("memberList size = {}", memberList.size());

        entityManager.remove(member);
    }
}